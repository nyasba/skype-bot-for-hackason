# skype-bot-for-hackason

skype bot 用のサンプルプロジェクトです

### 事前準備

環境変数の設定を行う
* skype_client_id
* skype_client_secret


### デプロイについて

ElasticBeanstalkにデプロイする想定。
ただし、botframeworkからだとhttpsしか認められていないため、APIGatewayをプロキシとして利用する

本文のマッピング変換は以下のように行っている前提

```
{
  "body" : $input.json('$'),
  "headers": {
    #foreach($param in $input.params().header.keySet())
    "$param": "$util.escapeJavaScript($input.params().header.get($param))" #if($foreach.hasNext),#end
    #end  
  }
}
```