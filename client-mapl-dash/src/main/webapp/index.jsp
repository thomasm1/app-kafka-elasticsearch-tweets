
<!DOCTYPE html>

<head>

	<link
			rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
			integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
			crossorigin="anonymous"
	/>
	<link
			href="https://fonts.googleapis.com/css?family=Playfair+Display"
			rel="stylesheet"
	/>

	<title>ArrayMaker</title>
	<meta charset="UTF-8" />
	<link rel="stylesheet" href="css/styles.css" />

	<link
			rel="stylesheet"
			href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
	/>

	<script src="lib/rxjs.5.4.3.js"></script>
	<!-- <script src="https://cdnjs.cloudflare.com/ajax/libs/rxjs/5.4.3/Rx.js"></script> -->
	<script src="lib/d3.v4.min.js"></script>
	<!-- <script src="https://d3js.org/d3.v4.min.js"></script> -->

	<!-- <script src="node_modules/jsdom/lib/api.js"></script> -->
	<style>

	</style>
	<link href="webjars/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" />
	<link href="proj1style.css" rel="stylesheet" />

	<link rel="shortcut favicon" href="https://tmm-nov.s3.amazonaws.com/img/favicon.ico" />
	<!-- /project1/src/main/webapp/favicon.ico
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
    integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
   -->
</head>

<body  id="body" onload="sessionInfo();listRequest(true, 0)">
	<!-- getUser(); -->
	<nav class="navbar navbar-default">
		<ul class="nav navbar-nav  userdata-mid ">
			<li id="left-header">
				<span id="role">
					<h3><strong><em>FRIENDS OF GROOT SOCIETY</em></strong></h3>
				</span>
				<span id="bal"></span>
			</li>

			<li class="active"><a href="/data/crypto.html">CRYPTO</a></li>
			<li><a href="/data/admin.html">STATUS</a></li>

		</ul>

		<ul class="nav navbar-nav navbar-right userdata">
			<li class="user  ">
				<div class="">
					<a href="/project1/request.html" class="pull-left">
						<button class="btn btn-primary logout ">&nbsp;&nbsp;Login In
							 &nbsp;&nbsp;</button>&nbsp;&nbsp;&nbsp;</a>
					<a onclick="logout()" href="/project1/login.html" class="pull-right">
						<button class="btn btn-default logout">&nbsp;&nbsp;Sign Out&nbsp;&nbsp;</button>&nbsp;&nbsp;
					</a>
					<a href="register.html"><button class="btn btn-primary logout">REGISTER</button></a>
				</div>

				<span>User</span><span class="id" id="headerId"> </span><br />
				<span>ID</span> <span class="id" id="userAdminId"></span><br />
				<span>Dept</span> <span class="id" id="userAdminDept"></span><br />
				<span>Super</span> <span class="id" id="userAdminSuper"></span><br />
				</div>
			</li>
		</ul>
	</nav>
	<a href="portfolio.html" class="buton"><button class="btn btn-primary buton">Resume Cubed Thomas Maestas</button></a>
	<div id="module"></div>
	<script  src='js/module.js'></script>

	<!--MAP: dataVisuals/populations.js -->
	<div id="ckmeans"></div>
	<!--Title:  public/appTitle.js -->
	<div class="appTitle"></div>
	<script src="./appTitle.js"></script>

	<div class="container">
		<!--MAP: dataVisuals/dataQueues_D3.js -->
		<div id="dataQueues"></div>
		<div class="container">

			<h2>CalculateCard</h2>
			<a href="<%=request.getContextPath()%>/data/login.do" style="font-size:16px;color:white;margin-left:1150px;text-decoration:none;">Login</a>
			<a href="<%=request.getContextPath()%>/data/logout" style="font-size:16px;color:white;margin-left:10px;text-decoration:none;">Logout</a>
			<a href="grootadder.html">Groot</a>
			<table id="table">
			</table>

<a href="/data/user">UserDetails</a>
			<form method="post" action="/data/offer">
				offer Code:<input type="text" name="offer"><br />
				Number 1 : <input name="number1"/><br/>
				Number 2: <input name="number2"/><br/>
				<input type="submit" value="Get Discount">
			</form>

			<!--
					<calculate-card></calculate-card>
			-->

		</div>

		<div class="contain">
			<div id="output" class="output"></div>
			<div class="row btc">
				<div class="dataConvert col col-xs-4" id="dataConvert0"></div>
				<div class="dataConvert col col-xs-4" id="dataConvert1"></div>
				<div class="dataConvert col col-xs-4" id="dataConvert2"></div>
			</div>
			<h3 align="center">API Data Fetchers.</h3>
			<div class="row">
				<!-- <div class="dataGetters col col-xs-4">
                        <div id="scraperBtc"></div>
                        <div id="scraperEther"></div>
                    </div> -->
				<div class="dataGetters col col-xs-6">
					<div id="fetchAsyncBtc"></div>
					<div id="fetchAsyncEther"></div>
				</div>
				<div class="dataGetters col col-xs-6">
					<div id="promiseAll"></div>
					<div id="promises"></div>
				</div>
			</div>

			<div id="app"></div>

			<script src="js/dataScraper.js"></script>
			<script src="js/dataAsyncPromise.js"></script>
			<script src="js/dataFetch.js"></script>
			<script src="js/serverless.js"></script>

			<div align="center">
				<h3 onmouseover="show()" onmouseout="hide()">
					<span class="hover">Serverless API Serving Bitcoin Prices</span>
				</h3>
			</div>
			<div>
				<code id="code"> </code>
				<div align="center">
					<button class="btn btn-primary" onclick="myFunction()">
						GET DATA
					</button>
				</div>
				<div class="row">
					<div class="dataXMLH col col-xs-6">
						<h5>Response from XMLHttpRequest:</h5>
						<div id="tom-tom"></div>
					</div>
					<div class="dataXMLH col col-xs-6">
						<h5>Bitcoin Daily Prices:</h5>
						<ul id="bitcoin"></ul>
					</div>
				</div>
				<code
				>curl -X GET
					"https://jdkxd2ny04.execute-api.us-east-1.amazonaws.com/prod/thomasMiltonFunction"</code
				>
			</div>

			<h3 align="center">Array and Object Structures</h3>
			<div id="calcs" class="calcs">


			</div>



			<h3 align="center">RxJS Vanilla Data Stream Manipulation</h3>
			<div class="row rxjs analytics">
				<div class="col col-xs-6">
					<div id="analyticsNum2"></div>
					<hr />
					<div id="array1"></div>
					<hr />
					<div id="analytics"></div>
				</div>

				<div class="pull-right col col-xs-5 col-right">
					<div id="analytics2"></div>
				</div>

				<div id="mouse"></div>
			</div>

		</div>

	</div>

<script src="lib/queue.v1.min.js"></script>
<!-- <script src="http://d3js.org/queue.v1.min.js"></script> -->

<script src="lib/topojson.v1.min.js"></script>
<!-- <script src="http://d3js.org/topojson.v1.min.js"></script> -->

<script src="lib/d3-geo-projection.v1.min.js"></script>
<!-- <script src="https://d3js.org/d3-geo-projection.v1.min.js"></script> -->
<script src="lib/d3-tip.js"></script>
<script src="lib/simple-statistics.2.0.min.js"></script>
<!-- <script src='https://unpkg.com/simple-statistics@2.0.0/dist/simple-statistics.min.js'></script> -->

<script src="lib/babel.6.10.3.min.js"></script>
<!-- <script src='https://cdnjs.cloudflare.com/ajax/libs/babel-standalone/6.10.3/babel.min.js'></script> -->
<script lang="babel" type="text/babel" src="js/populations.js">

      </script>
<!-- <script lang="babel" type="text/babel"    src='dataVisuals/indexModule.js'></script>
<script  lang="babel" type="text/babel"   src='dataVisuals/index.js'></script> -->
<script src="js/dataStreamsRxJS.js"></script>
<script src="js/csvJson.js"></script>
<script src="js/arrayMethods.js"></script>
<script src="js/dataStacks.js"></script>
<script src="js/dataLinkedList.js"></script>
<script src="js/dataSets.js"></script>
<script src="js/dataQueues.js"></script>
<script src="js/dataBinaryTree.js"></script>
<script src="js/dataHashTable.js"></script>
<script src="js/dataTrieStruct.js"></script>
<script src="js/dataHeap.js"></script>
<script src="js/dataGraphs.js"></script>
<script src="js/dataSorting.js"></script>
<script src="js/dataQueues_D3.js"></script>

<script src="js/bigO.js"></script>

<script src="js/orderedSearch.js"></script>

<script src="js/consecDays.js"></script>
<script src="js/searchDays.js"></script>


<script src="session.js"></script>
<script src="proj1js.js"></script>

<script src="webjars/jquery/1.9.1/jquery.min.js"></script>
<script src="webjars/bootstrap/3.3.6/js/bootstrap.min.js"></script>
	<footer class="footer">
		<h5>Copyright &copy; 2019 All Rights Reserved.</h5>
		<h5>
			<a
					href="mailto:thomasm1.maestas@gmail.com"
					title="Contact Information: thomasmaestas.net/"
			>
				Contact Thomas Maestas</a
			>
			&nbsp;&nbsp; | &nbsp;&nbsp;
			<a href="https://thomasmaestas.net">thomasmaestas.net</a>
		</h5>
	</footer>
</body>
</HTML>