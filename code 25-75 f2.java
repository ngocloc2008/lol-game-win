
// var _currentUser = user.name;
// var _authenUser;
// var _checkUser = false;
// $.get('https://raw.githubusercontent.com/mhqbdiceplayer/luckygames_baomai/master/user1.txt', function (data, status) {}).done(function (data) {
	// _authenUser = JSON.parse(data);
	// for (i = 0; i < _authenUser.length; i++)
		// if (_authenUser[i] == _currentUser)
			// _checkUser = true;
	// if (_checkUser == true) {
		$('#listContainer').css('display', 'none');
		$('#news').css('display', 'none');
		$('#main').css('min-width', '100%');
		$('#body').css('background', 'none');
		$('#content').css('height', '0px');
		$('#controlContainer').css('background', 'none');
		$('#controlContainer').css('visibility', 'hidden');
		$('#footer').css('display', 'none');
		$('#gameContainer').css('display', 'none');
		$('#frontText').css('display', 'none');
		$('div[class="tab tab-show"]:nth-child(4)').css('display', 'none');
		$('#header').html('<div id="left"><input id="baseBetAmount" type="text" value="" style="text-align: center;" placeholder="Base Bet"> <input id="overBalance" type="text" value="" style="text-align: center;" placeholder="Over Balance"> <input id="underBalance" type="text" value="" style="text-align: center;" placeholder="Under Balance"><br><br> <button id="minBet" onclick="minBet();">Min BET</button> <button id="startButton" onclick="startBot();">Start BOT</button> <button id="stopButton" onclick="stopBot();">Stop BOT</button> <button id="resetButton" onclick="resetBot();">Reset BOT</button> <button id="exitButton" onclick="exit();">Exit BOT</button><br><br> <button id="hideStatistics" onclick="hideStatistics();">Hide Statistics</button> <button id="viewStatistics" onclick="viewStatistics();">View Statistics</button> <p id="statistics"> Coin Play: ' + ($('#coin').val()).toUpperCase() + '<br> Time Play: <span id="playDay">0</span>:<span id="playHour">0</span>:<span id="playMinute">0</span>:<span id="playSecond">0</span><br> Speed Bet: <span id="speedBet">0.00</span><br> Balance: <span id="myBalance">0</span><br> Profit: <span id="totalProfit">0.00000000</span><br> Largest Bet: <span id="largestBet">0.00000000</span><br> Bet: <span id="bet">0</span><br> Win: <span id="win">0</span><br> Lose: <span id="lose">0</span><br> Win Streak: <span id="winStreak">0</span><br> Max Win Streak: <span id="maxWinStreak">0</span><br>  Max Lose Streak: <span id="loseStreak">0</span><br>Lose Streak: <span id="maxLoseStreak">0</span></p> <p id="author"><h3 style="margin: 0px;">Dice BOT 10 bet/ 50000000 </h3> Strategy by <span id="strategy"></span><br> Develop by <a href="https://www.facebook.com/mhqbdiceplayer" target="_blank" style="color: #fff;">Mai Hoang Quoc Bao</a><br> Donate to developer via <a href="https://luckygames.io/user/mhqbdicer" target="_blank"  style="color: #fff;">Send tips</a></p></div> <div id="right"> <button id="hideLog" onclick="hideLog();">Hide Log</button> <button id="viewLog" onclick="viewLog();">View Log</button> <div id="showLog"></div></div> <div id="end"><button id="hideLog" onclick="hideChart();">Hide Chart</button> <button id="viewChart" onclick="viewChart();">View Chart</button> <div id="chart"> </div></div>');
		$('#header').css('width', '80%');
		$('#header').css('background', 'none');
		$('#header').css('margin', 'auto');
		$('#header').css('padding-top', '20px');
		$('#header').css('border', 'none');
		$('#left').css('width', '50%');
		$('#left').css('float', 'left');
		$('#left').css('color', '#fff');
		$('#left').css('font-size', '14px');
		$('#right').css('width', '50%');
		$('#right').css('float', 'right');
		$('#showLog').css('overflow', 'auto');
		$('#showLog').css('width', '100%');
		$('#showLog').css('height', '365px');
		$('#showLog').css('margin-top', '20px');
		$('#showLog').css('padding', '5px');
		$('#showLog').css('color', '#5C89A2');
		$('#showLog').css('font-size', '14px');
		$('#showLog').css('border', '1px solid #fff');
		$('#end').css('width', '100%');
		$('#end').css('padding-top', '10px');
		$('#end').css('clear', 'both');
		$('#chart').css('margin-top', '20px');
		$('#strategy').html('<a href="https://www.facebook.com/nguyenloc.nguyen.737" target="_blank" style="color: #fff;">NGUYEN LOC NGUYEN</a>');
		$('#myBalance').html(_startBalance);
		$('#stopButton').prop('disabled', true);
		showLog('BOT has apliped!');
		randomizeSeed();
		// return;
	// } else {
		// alert('you do not have permission to use, contact the developer!');
		// window.location.replace('https://www.facebook.com/mhqbdiceplayer');
	// }
// });
var _startBalance = parseFloat($('#balance').val());
var _onBalance = 0;

var _profit = 0;
var _totalProfit = 0;
var _largestProfit = 0;

var _overBalance = 0;
var _underBalance = 0;
var _a = 0;
var _b = 0;
var _h = 0;
var _l = 0;
var _chance = 0;
var _prediction = 25;
var _direction = 'under';
var _baseBetAmount = 0;
var _betAmount = 0;
var _l = 0;

var _basenBetAmount = 0;
var _largestBet = 0;

var _bet = 0;
var _win = 0;
var _winStreak = 0;
var _maxWinStreak = 0;

var _lose = 0;
var _loseStreak = 0;
var _loseStreak1 = 0;
var _maxLoseStreak = 0;

var _startTime = 0;
var _onTime = 0;
var _playTime = 0;
var _playDay = 0;
var _playHour = 0;
var _playMinute = 0;
var _playSecond = 0;

var _speedBet = 0;

var _stoped = true;

var _runSeed = 0;
var _runLog = 0;

var _dps = [];
var _chart;

$.getScript('https://canvasjs.com/assets/script/canvasjs.min.js')
.done(function (script, textStatus) {
	_dps = [{
			x: 0,
			y: 0
		}
	];
	_chart = new CanvasJS.Chart('chart', {
			theme: 'light2',
			zoomEnabled: true,
			height: 340,
			title: {
				text: 'Live Profit',
				fontSize: 14
			},
			data: [{
					type: 'stepLine',
					dataPoints: _dps,
				}
			]
		});
	_chart.render();
});

function updateChart(_gameResult, _bet, _totalProfit) {
	var _x = _bet;
	var _y = _totalProfit;
	var _type = _gameResult;
	if (_type == 'win') {
		var _color = '#4491BB';
	} else {
		var _color = '#FF000B';
	}
	_dps.push({
		x: _x,
		y: _y,
		color: _color
	});
	if (_dps[_dps.length - 2]) {
		_dps[_dps.length - 2].lineColor = _color;
	}
	if (_dps.length > 1000) {
		_dps.shift();
	}
	_chart.render();
}

function minBet() {
	$('#baseBetAmount').val((0.00000001).toFixed(8));
}

function hideStatistics() {
	document.getElementById('statistics').hidden = true;
}

function viewStatistics() {
	document.getElementById('statistics').hidden = false;
}

function hideLog() {
	document.getElementById('showLog').hidden = true;
}

function viewLog() {
	document.getElementById('showLog').hidden = false;
}

function hideChart() {
	document.getElementById('chart').hidden = true;
}

function viewChart() {
	document.getElementById('chart').hidden = false;
}

function showLog(string) {
	$('<p style="margin: 0;">' + string + '</p>').appendTo('#showLog');
	$('#showLog').stop().animate({
		scrollTop: $('#showLog')[0].scrollHeight
	}, 100);
}

function startBot() {
	_stoped = false;
	_startTime = new Date();
	if ($('#baseBetAmount').val() == '') {
		_baseBetAmount = _startBalance * 0.00000001;
	} else {
		_baseBetAmount = parseFloat($('#baseBetAmount').val());
	}
	if ($('#overBalance').val() == '') {
		_overBalance = 0;
	} else {
		_overBalance = parseFloat($('#overBalance').val());
	}
	if ($('#underBalance').val() == '') {
		_underBalance = 0;
	} else {
		_underBalance = parseFloat($('#underBalance').val());
	}
	_betAmount = _baseBetAmount;
	_basenBetAmount = _baseBetAmount * 15;
	$('#baseBetAmount').val(_baseBetAmount.toFixed(8));
	$('#baseBetAmount').prop('disabled', true);
	$('#overBalance').val(_overBalance.toFixed(8));
	$('#overBalance').prop('disabled', true);
	$('#underBalance').val(_underBalance.toFixed(8));
	$('#underBalance').prop('disabled', true);
	$('#minBet').prop('disabled', true);
	$('#startButton').prop('disabled', true);
	$('#stopButton').prop('disabled', false);
	$('#resetButton').prop('disabled', true);
	$('#exitButton').prop('disabled', true);
	doBet();
}

function stopBot() {
	_stoped = true;
	$('#baseBetAmount').prop('disabled', false);
	$('#overBalance').prop('disabled', false);
	$('#underBalance').prop('disabled', false);
	$('#minBet').prop('disabled', false);
	$('#startButton').prop('disabled', false);
	$('#stopButton').prop('disabled', true);
	$('#resetButton').prop('disabled', false);
	$('#exitButton').prop('disabled', false);
	showLog('BOT has stopped!');
}

function resetBot() {
	$.getScript('https://canvasjs.com/assets/script/canvasjs.min.js')
	.done(function (script, textStatus) {
		_dps = [{
				x: 0,
				y: 0
			}
		];
		_chart = new CanvasJS.Chart('chart', {
				theme: 'light2',
				zoomEnabled: true,
				height: 350,
				title: {
					text: 'Live Profit',
					fontSize: 14
				},
				data: [{
						type: 'stepLine',
						dataPoints: _dps,
					}
				]
			});
		_chart.render();
	});
	randomizeSeed();

	_startBalance = parseFloat($('#balance').val());
	_onBalance = 0;

	_profit = 0;
	_totalProfit = 0;
	_largestProfit = 0;

	_overBalance = 0;
	_underBalance = 0;

	_prediction = 25;
	_direction = 'under';
	_baseBetAmount = 0;
	_betAmount = 0;

	_basenBetAmount = 0;
	_largestBet = 0;

	_bet = 0;
	_win = 0;
	_winStreak = 0;
	_maxWinStreak = 0;

	_lose = 0;
	_loseStreak = 0;
	_maxLoseStreak = 0;

	_startTime = 0;
	_onTime = 0;
	_playTime = 0;
	_playDay = 0;
	_playHour = 0;
	_playMinute = 0;
	_playSecond = 0;

	_speedBet = 0;

	_stoped = true;

	_runSeed = 0;
	_runLog = 0;

	$('#speedBet').html(_speedBet.toFixed(2));
	$('#playDay').html(_playDay);
	$('#playHour').html(_playHour);
	$('#playMinute').html(_playMinute);
	$('#playSecond').html(_playSecond);
	$('#totalProfit').html(_totalProfit.toFixed(8));
	$('#largestBet').html(_largestBet.toFixed(8));
	$('#bet').html(_bet);
	$('#win').html(_win);
	$('#lose').html(_lose);
	$('#winStreak').html(_winStreak);
	$('#maxWinStreak').html(_maxWinStreak);
	$('#loseStreak').html(_loseStreak);
	$('#maxLoseStreak').html(_maxLoseStreak);
	$("#showLog p").remove();
	showLog('BOT has reset!');
}

function exit() {
	var _donate = confirm('Please donate to author!');
	if (_donate == true) {
		window.open('https://luckygames.io/user/mhqbdicer', '_blank');
		location.reload();
	} else {
		return;
	}
}

function doBet() {
	if (_stoped === false) {
		jQuery.ajax({
			url: '/ajx/',
			type: 'POST',
			dataType: 'html',
			timeout: 2e4,
			data: {
				game: 'dice',
				coin: $('#coin').val(),
				betAmount: _betAmount,
				prediction: _prediction,
				direction: _direction,
				clientSeed: $("#clientSeed").val(),
				serverSeedHash: $("#serverSeedHash").html(),
				action: "playBet",
				hash: user.hash
			},
			success: function (data) {
				var _a = JSON.parse(data);
				var _result = _a.result;
				if (_result === true) {
					var _gameResult = _a.gameResult;
					var _resultNumber = _a.resultNumber;
					var _balance = _a.balance;
					var _previous_betAmount = _betAmount;
					$('#serverSeedHash').html(_a.serverSeedHash);
					$('#prevServerSeed').html(_a.prevServerSeed);
					$('#prevServerSeedHash').html(_a.prevServerSeedHash);
					$('#prevClientSeed').html(_a.prevClientSeed);
					$('#balance').val(_a.balance);
					_onBalance = _a.balance;
					_profit = _a.profit;
					_fixProfit = parseFloat(_profit);
					_totalProfit = _onBalance - _startBalance;
					_onTime = new Date().getTime();
					_playTime = _onTime - _startTime;
					_playDay = Math.floor(_playTime / (1000 * 60 * 60 * 24));
					_playHour = Math.floor((_playTime % (1000 * 60 * 60 * 24)) / (1000 * 60 * 60));
					_playMinute = Math.floor((_playTime % (1000 * 60 * 60)) / (1000 * 60));
					_playSecond = Math.floor((_playTime % (1000 * 60)) / 1000);
					_speedBet = parseFloat((_bet / _playTime) * 1000);
					_bet++;
					// _runSeed++;
					// if (_runSeed >= 1000) {
					// _runSeed = 0;
					// randomizeSeed();
					// }
					_runLog++;
					if (_runLog >= 1000) {
						_runLog = 0;
						$("#showLog p").remove();
					}
					showLog('Betting ' + _betAmount.toFixed(8) + ' at ' + _prediction + '% ' + _direction + ' - roll ' + _resultNumber + ' to ' + _gameResult + ' ' + _fixProfit.toFixed(8));
					if (_gameResult == 'win') {
						_win++;
						_winStreak++;
						_loseStreak = 0;
					} else {
						_lose++;
						_winStreak = 0;
						_loseStreak++;
					}
					if (_betAmount > _onBalance) {
						stopBot();
						showLog('You lose!');
					} else {
						if (_overBalance > 0 && _onBalance > _overBalance) {
							stopBot();
							showLog('Over balance!');
						} else {
							if (_underBalance > 0 && _onBalance <= _underBalance) {
								stopBot();
								alert('Under balance!');
							} else {

								if (_gameResult == 'win') {
									randomizeSeed();
									_prediction = 75;
									_betAmount = _baseBetAmount;
								} else {
									_chance = 25;
									_prediction = _chance

										if (_loseStreak == 5) {
											_prediction = 75;
											_chance = _prediction
											_betAmount = _previous_betAmount * 5;
										}
										if (_loseStreak == 6) {
											_prediction = 75;
											_chance = _prediction
											_betAmount = _previous_betAmount * 3;
										}
										if (_loseStreak == 7) {
												_betAmount = _previous_betAmount * 3;
										}
										if (_loseStreak == 8) {
											_betAmount = _previous_betAmount * 3.5;
										}
										if (_loseStreak == 9) {
											_betAmount = _previous_betAmount * 3;
										}
										if (_loseStreak == 10) {
											_prediction = 25;
											_chance = _prediction
												_betAmount = _previous_betAmount *1.1;
										}
										if (_loseStreak == 15) {
											_prediction = 75;
											_chance = _prediction
												_betAmount = _previous_betAmount * 3.5;
										}
										if (_loseStreak == 16) {
												_betAmount = _previous_betAmount * 5;
										}
										if (_loseStreak == 17) {
												_betAmount = _previous_betAmount * 3.5;
										}
										if (_loseStreak == 18) {
												_betAmount = _previous_betAmount * 3;
										
										}
										if (_loseStreak == 19) {
												_betAmount = _previous_betAmount * 3.5;
										}
										if (_loseStreak == 20) {
											_prediction = 25;
											_chance = _prediction
												_betAmount = _previous_betAmount /3;
										
										}
										if (_loseStreak == 30) {
												_prediction = 25;
												_chance = _prediction
												_betAmount = _previous_betAmount * 5;
										}
										if (_loseStreak == 35) {
												_prediction = 25;
												_chance = _prediction
												_betAmount = _previous_betAmount * 1.1;
										
										}
										if (_loseStreak == 40) {
												_prediction = 75;
												_chance = _prediction
												_betAmount = _previous_betAmount * 5;
										}
										if (_loseStreak == 45) {
												_prediction = 25;
												_chance = _prediction
												_betAmount = _previous_betAmount * 1.1;
										}
										if (_loseStreak == 50) {
												_prediction = 75;
												_chance = _prediction
												_betAmount = _previous_betAmount * 5;
										}if (_loseStreak == 55) {
												_prediction = 25;
												_chance = _prediction
												_betAmount = _previous_betAmount * 1.1;
										
										}
										if (_loseStreak == 60) {
												_prediction = 75;
												_chance = _prediction
												_betAmount = _previous_betAmount * 5;
										}
										if (_loseStreak == 65) {
										_prediction = 25;
												_chance = _prediction
												_betAmount = _previous_betAmount * 1.1;
										}
										if (_loseStreak == 70) {
												_prediction = 75;
												_chance = _prediction
												_betAmount = _previous_betAmount * 5;
										}
										
								
										
										if (_loseStreak >= 75) {
												_prediction = 25;
												_chance = _prediction
												_betAmount = _previous_betAmount * 1.05;
										}

								}
							}
						}
					}
					if (_betAmount > _largestBet) {
						_largestBet = _betAmount;
					}
					if (_winStreak > _maxWinStreak) {
						_maxWinStreak = _winStreak;
					}
					if (_loseStreak > _maxLoseStreak) {
						_maxLoseStreak = _loseStreak;
					}

					$('#myBalance').html(_onBalance);
					$('#speedBet').html(_speedBet.toFixed(2));
					$('#playDay').html(_playDay);
					$('#playHour').html(_playHour);
					$('#playMinute').html(_playMinute);
					$('#playSecond').html(_playSecond);
					$('#totalProfit').html(_totalProfit.toFixed(8));
					$('#largestBet').html(_largestBet.toFixed(8));
					$('#bet').html(_bet);
					$('#win').html(_win);
					$('#lose').html(_lose);
					$('#winStreak').html(_winStreak);
					$('#maxWinStreak').html(_maxWinStreak);
					$('#loseStreak').html(_maxLoseStreak);
					$('#maxLoseStreak').html(_loseStreak);
					updateChart(_gameResult, _bet, _totalProfit);
					doBet();
				} else {
					doBet();
				}
			},
			error: function (xhr, ajaxOptions, thrownError) {
				doBet();
			},
			timeout: function (xhr, ajaxOptions, thrownError) {
				check = true;
			},
			abort: function (xhr, ajaxOptions, thrownError) {
				check = true;
			}
		});
	} else {}
}