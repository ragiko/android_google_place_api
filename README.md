#概要
Google Place Api の情報を取得

#詳細
* TheadからHTTPリクエストでGoogle Place Apiの情報を取得(JSON形式)
* JSONをGsonを使ってParseする

##参考URL
(gson)  
http://stackoverflow.com/questions/20037251/parsing-data-with-gson-from-google-places  

(Http request)  
http://kuwagames.nows.jp/top/?p=177


##Sample Get URL
https://maps.googleapis.com/maps/api/place/nearbysearch/json?location=-33.8670522,151.1957362&radius=500&types=food&name=harbour&sensor=false&key=YOUR_APIKEY
