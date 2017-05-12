package jp.co.gxp.bot.skype.repository.skype;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Repository;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestOperations;

import jp.co.gxp.bot.skype.domain.base.SkypeApiException;
import jp.co.gxp.bot.skype.domain.skype.SkypeBotApiAccessToken;
import jp.co.gxp.bot.skype.domain.skype.SkypeMessage;
import jp.co.gxp.bot.skype.domain.skype.SkypeRoom;
import jp.co.gxp.bot.skype.domain.skype.SkypeRoomDefined;
import jp.co.gxp.bot.skype.domain.skype.SkypeRoomUndefined;

@Repository
public class SkypeBotApiRepository implements SkypeBotRepository {

    private static Logger logger = LoggerFactory.getLogger(SkypeBotRepository.class);

    private final RestOperations restOperations;

    public SkypeBotApiRepository(RestTemplateBuilder restTemplateBuilder) {
        this.restOperations = restTemplateBuilder.build();
    }

    /**
     * BotFrameworkのアクセストークンを取得する
     * <p>
     * <p>MicrosoftBotFrameworkのAPIのcurl呼び出しサンプル
     * <p>Request
     * <pre class="code">
     * POST https://login.microsoftonline.com/botframework.com/oauth2/v2.0/token
     * Content-Type: application/x-www-form-urlencoded
     * <p>
     * grant_type=client_credentials&client_id=1f7dd6e9-cbd7-4c38-adf2-6e9bcab5310a&client_secret=6wyxeJ4...&scope=https%3A%2F%2Fapi.botframework.com%2F.default
     * </pre>
     * <p>Response
     * <pre class="code">
     * HTTP/1.1 200 OK
     * Content-Type: application/json; charset=utf-8
     * {
     * "token_type": "Bearer",
     * "expires_in": 3599,
     * "ext_expires_in": 0,
     * "access_token": "eyJ0eXAiOi..."
     * }
     * </pre>
     */
    @Retryable(value = SkypeApiException.class, backoff = @Backoff(delay = 1000L, maxDelay = 10000L)) // リトライの設定
    @Override
    public SkypeBotApiAccessToken auth() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

        MultiValueMap<String, String> data = new LinkedMultiValueMap<>();
        data.add("grant_type", "client_credentials");
        data.add("client_id", System.getenv("skype_client_id"));
        data.add("client_secret", System.getenv("skype_client_secret"));
        data.add("scope", "https://graph.microsoft.com/.default");

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<>(data, headers);

        String url = "https://login.microsoftonline.com/common/oauth2/v2.0/token";

        try {
            ResponseEntity<SkypeBotApiAuthResponse> response = restOperations.postForEntity(url, request, SkypeBotApiAuthResponse.class);
            logger.info("auth result : " + response.getStatusCode().toString());
            logger.debug("header : " + response.getHeaders().toString());
            logger.debug("body : " + response.getBody().toString());
            return response.getBody().getAccessToken();
        } catch (RestClientException e) {
            logger.error(e.toString());
            throw new SkypeApiException("auth is failed : " + e.getMessage());
        }
    }

    /**
     * Skypeへメッセージを投稿する
     * <p>
     * <p>MicrosoftBotFrameworkのAPIのcurl呼び出しサンプル
     * <p>Request
     * <pre class="code">
     * POST https://api.skype.net/v3/conversations/19:f6a...4@thread.skype/activities/
     * Authorization: Bearer eyJ0eXAiOi...
     * Content-Type: application/json; charset=utf-8
     * <p>
     * { "type" : "message/text", "text" : "Hello!" }
     * </pre>
     * <p>Response
     * <pre class="code">
     * </pre>
     *
     * @param accessToken アクセストークン
     * @param room        メッセージを投稿するチャットルーム
     * @param message     メッセージ
     */
    @Override
    public void postMessage(SkypeBotApiAccessToken accessToken, SkypeRoom room, SkypeMessage message) {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + accessToken.getValue());
        headers.setContentType(MediaType.APPLICATION_JSON);

        SkypeBotApiPostRequest json = new SkypeBotApiPostRequest(message);
        HttpEntity<SkypeBotApiPostRequest> request = new HttpEntity<>(json, headers);

        String url = "https://api.skype.net/v3/conversations/{room_id}/activities/";

        try {
            ResponseEntity<String> response = restOperations.postForEntity(url, request, String.class, room.getId());
            logger.info("post message result : " + response.getStatusCode().toString());
            logger.debug("header : " + response.getHeaders().toString());
            logger.debug("body : " + response.getBody());
        } catch (HttpClientErrorException e) {
            logger.error("post message is failed by : " + e.getMessage());
            logger.error("header : " + e.getResponseHeaders().toString());
            logger.error("body : " + e.getResponseBodyAsString());
            throw new SkypeApiException("post message is failed :" + e.getMessage());
        } catch (RestClientException e) {
            logger.error(e.toString());
            throw new SkypeApiException("post message is failed :" + e.getMessage());
        }
    }
}
