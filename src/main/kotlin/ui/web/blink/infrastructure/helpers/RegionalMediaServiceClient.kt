package ui.web.blink.infrastructure.helpers

class RegionalMediaServiceClient(regionId: String, blinkUrl: String) :
    BaseService("https://rest-${regionId}.${blinkUrl}", BodyMapper.NONE, BodyMapper.NONE) {
    companion object {
        fun requestOptionsAuthKey(authKey: String, requestOptions: RequestOptions = RequestOptions()): RequestOptions {
            requestOptions.headers["token-auth"] = authKey
            return requestOptions
        }
    }
}