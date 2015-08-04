<?php
	$app->get('/events/find/:eventDesc', function ($eventDesc) use ($app){
		
		$model = new findEventsModel($eventDesc, $app);
		$saveString = $eventDesc.
					$app->request()->params('userLat').
					$app->request()->params('userLng').
					$app->request()->params('city').
					$app->request()->params('state').
					$app->request()->params('date').
					$app->request()->params('sources').
					$app->request()->params('radius');
		$json_response = getCachedContent($saveString, $model->getJsonWithChecksum());
		
		$app->contentType('application/json');
		echo $json_response;
		/*
		$options = array(
		'lifeTime' => 86400, //24 hours
		'pearErrorMode' => CACHE_LITE_ERROR_DIE
		);
		$cache = new Cache_Lite($options);

		$cache->clean();
		echo "cache cleaned!";
		*/
		
	});	
?>