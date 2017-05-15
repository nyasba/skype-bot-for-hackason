package jp.co.gxp.bot.skype.controller.api.bot;

import jp.co.gxp.bot.skype.controller.api.bot.request.BotInputControllerRequest;
import jp.co.gxp.bot.skype.domain.skype.SkypeRoomDefined;
import jp.co.gxp.bot.skype.service.AutoBotWorkService;
import jp.co.gxp.bot.skype.service.BotWorkService;
import jp.co.gxp.bot.skype.service.OnichanResponseService;
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

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

/**
 * BotFrameworkの受け口となるController
 */
@RestController
public class BotInputContoller {

    private static Logger logger = LoggerFactory.getLogger(BotInputContoller.class);
    
    @Autowired
    private OnichanResponseService onichanResponseService;


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

        logger.info("message:" + request.getMessage().getValue());
        logger.info("room:" + request.getRoom().getId());
        logger.info("token:" + request.getToken().getValue());
    
        // 鬼ちゃん用にする
        onichanResponseService.postMessage(request.getRoom(), request.getMessage()
        );

        return ResponseEntity.accepted().build();
    }

    @Autowired
    private BotWorkService botWorkService;

    @Autowired
    private AutoBotWorkService autoBotWorkService;


    @PostMapping("/botwork")
    public void botWork(@Valid @RequestBody BotInputControllerRequest request, Errors errors){

    	if(errors.hasErrors()){

    	}

    	botWorkService.makeMessage(request.getToken(),
    			request.getRoom(),request.getMessage());
    }

    @GetMapping("/notice")
    public void autoBotWork(){

        /*if (errors.hasErrors()) {
            List<String> errorList = errors.getAllErrors().stream()
                    .map(ObjectError::toString)
                    .collect(Collectors.toList());
            errorList.forEach(e -> logger.error("validation error : " + e));
        }*/

    	autoBotWorkService.makeNotice(SkypeRoomDefined.TEST);
    }

}
