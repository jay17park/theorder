var gcm = require('node-gcm');

// create a message with default values
var message = new gcm.Message();

// or with object values
var message = new gcm.Message({
    collapseKey: 'demo',
    delayWhileIdle: true,
    timeToLive: 3,
    data: {
        key1: 'HIHI',
        key2: 'TheOrder Push!'
    }
});

var server_access_key = 'AIzaSyDT7ICni8aXVsCbHvQoUtPH3gK7jWs31UA';
var sender = new gcm.Sender(server_access_key);
var registrationIds = [];

var registration_id = 'eQAZxv99l5k:APA91bFKbllk5PlKwOERMSupaMA5r82xgBpZaVJoIiJFAd6VLG5fsJ7X1aiCsB72FTDgPvapCXH8WlnePaJyLdLAyqnUvxloUaohGtWM6u43rdvm8ESoqCdXcys8Rou4f2-ehYxsMVKT';
// At least one required
registrationIds.push(registration_id);

/**
 * Params: message-literal, registrationIds-array, No. of retries, callback-function
 **/
sender.send(message, registrationIds, 4, function (err, result) {
    console.log(result);
});
