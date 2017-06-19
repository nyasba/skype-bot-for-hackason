# AWS lambdaで動かすための手順

### jarの作成

```
./mvnw package 
```

target配下にjarが作成される

### Lambda関数の作成にて

パッケージは上記で作成したjarをアップロード。
ハンドラとして```jp.co.gxp.bot.skype.LambdaHandler::handleRequest```を指定する