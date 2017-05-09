package jp.co.gxp.bot.skype.controller.api.bot;

import jp.co.gxp.bot.skype.controller.api.bot.request.BotInputControllerRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * BotFrameworkの受け口となるController
 */
@RestController
public class BotInputContoller {
    
    private static Logger logger = LoggerFactory.getLogger(BotInputContoller.class);
    
    
    /**
     * BotFrameworkから呼び出されるエンドポイントとなるController
     *
     * @param request リクエストパラメータ
     * @param errors  バリデーションエラー
     * @return HttpResponse
     */
    @PostMapping("/bot")
    public ResponseEntity<?> post(@Valid @RequestBody BotInputControllerRequest request, Errors errors) {
        
        if (errors.hasErrors()) {
            List<String> errorList = errors.getAllErrors().stream()
                    .map(ObjectError::toString)
                    .collect(Collectors.toList());
            errorList.forEach(e -> logger.error("validation error : " + e));
            return ResponseEntity.accepted().build();
        }
        
        logger.info("input:" + request.toString());
        
        return ResponseEntity.accepted().build();
    }
    
}
