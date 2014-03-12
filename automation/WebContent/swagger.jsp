<!DOCTYPE html>
<html>
<head>
<title></title>
<!-- 
<link href='//fonts.googleapis.com/css?family=Droid+Sans:400,700'
	rel='stylesheet' type='text/css' />
 -->
<link href='swagger-ui/css/hightlight.default.css' media='screen' rel='stylesheet'
	type='text/css' />
<link href='swagger-ui/css/screen.css' media='screen' rel='stylesheet'
	type='text/css' />
<script src='swagger-ui/lib/jquery-1.9.1.min.js' type='text/javascript'></script>
<script src='swagger-ui/lib/jquery.slideto.min.js' type='text/javascript'></script>
<script src='swagger-ui/lib/jquery.wiggle.min.js' type='text/javascript'></script>
<script src='swagger-ui/lib/jquery.ba-bbq.min.js' type='text/javascript'></script>
<script src='swagger-ui/lib/handlebars-1.0.rc.1.js' type='text/javascript'></script>
<script src='swagger-ui/lib/underscore-min.js' type='text/javascript'></script>
<script src='swagger-ui/lib/backbone-min.js' type='text/javascript'></script>
<script src='swagger-ui/lib/swagger.js' type='text/javascript'></script>
<script src='swagger-ui/swagger-ui.js' type='text/javascript'></script>
<script src='swagger-ui/lib/highlight.7.3.pack.js' type='text/javascript'></script>

<script type="text/javascript">
			//headers: { "content-type": "application/x-www-form-urlencoded"},
	$(function() {
		window.swaggerUi = new SwaggerUi({
			discoveryUrl : "http://"+ location.host+"/automation/api/resourceList",
			dom_id : "swagger-ui-container",
			supportHeaderParams : false,
			supportedSubmitMethods : [ 'get', 'post', 'put', 'delete' ],
			onComplete : function(swaggerApi, swaggerUi) {
				if (console) {
					console.log("Loaded SwaggerUI")
					console.log(swaggerApi);
					console.log(swaggerUi);
				}
				$('pre code').each(function(i, e) {
					hljs.highlightBlock(e)
				});
				$('.fullwidth').find('th').each(function(i){ if($(this).html() == 'HTTP Status Code') $(this).html("HTTP/TRIM Status");});
			},
			onFailure : function(data) {
				if (console) {
					console.log("Unable to Load SwaggerUI");
					console.log(data);
				}
			},
			docExpansion : "none"
		});

		window.swaggerUi.load();
		
	});

</script>
</head>

<body>
	<div id='header'>
		<div class="swagger-ui-wrap">
			<!--         <a id="logo" href="http://swagger.wordnik.com">TRIM</a> -->
			<a id="logo" href="/automation/">AUTOMATION</a>

			<form id='api_selector'>

				<!-- 	 <div class='input icon-btn'>
                <img id="show-pet-store-icon" src="images/pet_store_api.png" title="Show Swagger Petstore Example Apis">
            </div>
            <div class='input icon-btn'>
                <img id="show-wordnik-dev-icon" src="images/wordnik_api.png" title="Show Wordnik Developer Apis">
            </div> 
				 <div class='input'><input placeholder="http://example.com/api" id="input_baseUrl" name="baseUrl"
                                      type="text"/></div> 
				<div class='input'>
					<input placeholder="api_key" id="input_apiKey" name="apiKey"
						type="text" />
				</div>
				<div class='input'>
					<a id="explore" href="#">Explore</a>
				</div>
				-->

			</form>
		</div>
	</div>
	<div class="swagger-ui-wrap">
		<div id="message-bar">&nbsp;</div>
		<div>
			<h1>API document</h1>
		</div>
		<div id="swagger-ui-container"></div>
	</div>
</body>

</html>
