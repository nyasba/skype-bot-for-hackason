package jp.co.gxp.bot.skype.controller.api.user;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import jp.co.gxp.bot.skype.controller.api.user.request.SampleControllerRequest;
import jp.co.gxp.bot.skype.service.SkypeMessagePostService;

/**
 * サンプルController
 */
@RestController
public class SampleContoller {

    private static Logger logger = LoggerFactory.getLogger(SampleContoller.class);

    @Autowired
    private SkypeMessagePostService skypeMessagePostService;

    /**
     * Skypeへ投稿するための外部からのエンドポイントとなるController
     * <p>
     * curlでのサンプル
     * <pre class="code">
     * curl -X POST -v \
     * -H "Accept: application/json" \
     * -H "Content-Type: application/json" \
     * -d "{ \"room\" : \"test\", \"message\" : \"hello from controller\" }" \
     * http://localhost:8080/message
     * </pre>
     *
     * @param request リクエストパラメータ
     * @param errors  バリデーションエラー
     * @return HttpResponse
     */
    @PostMapping("/message")
    public ResponseEntity<?> post(@Valid @RequestBody SampleControllerRequest request, Errors errors) {

        if (errors.hasErrors()) {
            List<String> errorList = errors.getAllErrors().stream()
                    .map(ObjectError::toString)
                    .collect(Collectors.toList());
            errorList.forEach(e -> logger.error("validation error : " + e));
            return ResponseEntity.badRequest().body(String.join(",", errorList));
        }

        skypeMessagePostService.postMessage(
                request.getRoom(),
                request.getMessage()
        );

        return ResponseEntity.ok().build();
    }

    // curl -s http://localhost:8080/healthcheck でOKが返ってくる（本来はactuator使うべき）
    @GetMapping("/healthcheck")
    public ResponseEntity<?> get() {
        return ResponseEntity.ok("OK");
    }
}
