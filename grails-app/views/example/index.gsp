<!DOCTYPE html>
<html>
<head>
	<meta name="layout" content="main"/>

	<asset:javascript src="application" />
	<asset:javascript src="spring-websocket" />

	<script type="text/javascript">
		 	$(function() {
				var socket = new SockJS("${createLink(uri: '/stomp')}");
				var client = Stomp.over(socket);

				client.connect({}, function() {
					client.subscribe("/topic/hello", function(message) {
						$("#helloDiv").append(message.body);
					});
					client.subscribe("/topic/hellow", function(message) {
						$("#hellowDiv").append(message.body);
					});
				});

				$("#helloButton").click(function() {
					client.send("/app/hello", {}, JSON.stringify("world"));
				});

				$("#hellowButton").click(function() {
					client.send("/app/hellow", {}, JSON.stringify("world"));
				});
			});
		</script>
</head>
<body>
<button id="helloButton">hello</button>
<div id="helloDiv"></div>

<button id="hellowButton">hellow</button>
<div id="hellowDiv"></div>
</body>
</html>