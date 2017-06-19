package jp.co.gxp.bot.skype;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import jp.co.gxp.bot.skype.domain.skype.SkypeMessage;
import jp.co.gxp.bot.skype.domain.skype.SkypeRoomDefined;
import jp.co.gxp.bot.skype.service.SkypeMessagePostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * AWS Lambdaのエントリーポイントとなるクラス
 */
@SpringBootApplication
public class LambdaHandler implements RequestHandler<Object, Object> {
    
    @Autowired
    private SkypeMessagePostService skypeMessagePostService;
    
    private Object input;
    private Context context;
    
    @Override
    public Object handleRequest(Object input, Context context) {
        context.getLogger().log("-----start.-----");
        String args[] = new String[0];
        try (ConfigurableApplicationContext ctx = SpringApplication.run(LambdaHandler.class, args)) {
            LambdaHandler app = ctx.getBean(LambdaHandler.class);
            app.setInput(input);
            app.setContext(context);
            app.run(args);
            context.getLogger().log("-----end.-----");
            return "success.";
        } catch (Exception e) {
            e.printStackTrace();
            context.getLogger().log("error.\n");
            return "error.";
        }
    }
    
    public void run(String... args) throws Exception {
        skypeMessagePostService.postMessage(SkypeRoomDefined.TEST, new SkypeMessage("test " + LocalDateTime.now().format(DateTimeFormatter.BASIC_ISO_DATE)));
    }
    
    public void setInput(Object input) {
        this.input = input;
    }
    
    public void setContext(Context context) {
        this.context = context;
    }
}
