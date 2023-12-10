var dailyTech = angular.module('app');

dailyTech.controller('ArchivesController', ['$scope', '$http', '$location', '$routeParams', function ArchivesController($scope, $http, $location, $routeParams){

	console.log(' ArchivesController loaded...');
 
 
/*
	console.log('header');
	var headerauth = "--Ryan Dahl, Creator of JavaScript's Node.JS";
	var headerquote = `  
	 <strong>You Can Never Understand Everything.<br /><br />But You can Push Yourself to Understand the System.</strong>	 
	`;
	document.getElementById("featured").innerHTML = `
	<p class="left" id="headerquote">
	${headerquote}</p>  <p> -- ${headerauth} </p>
	`;
	*/ 
	var secretButtonMP = document.querySelector('#secret-buttonMP'); // MY PHILOSOPHY (dailytech mission)
	var secretParagraphMP = document.querySelector('#secret-paragraphMP');
	//
	var secretButton = document.querySelector('#secret-button'); // ME
	var secretParagraph = document.querySelector('#secret-paragraph');
	
	var secretButtonMPB = document.querySelector('#secret-buttonMPB'); // FEB
	var secretParagraphMPB = document.querySelector('#secret-paragraphMPB');
	var secretButtonMAR = document.querySelector('#secret-buttonMAR'); // MAR
	var secretParagraphMAR = document.querySelector('#secret-paragraphMAR');
	var secretButtonAPR = document.querySelector('#secret-buttonAPR'); // APR
	var secretParagraphAPR = document.querySelector('#secret-paragraphAPR');
	var secretButtonMAY = document.querySelector('#secret-buttonMAY'); // MAY
	var secretParagraphMAY = document.querySelector('#secret-paragraphMAY');
	var secretButtonJUNE = document.querySelector('#secret-buttonJUNE'); // JUNE
	var secretParagraphJUNE = document.querySelector('#secret-paragraphJUNE'); 
	var secretButtonJULY = document.querySelector('#secret-buttonJULY'); // JULY
	var secretParagraphJULY = document.querySelector('#secret-paragraphJULY');///////////////////////////////// 
	var secretButtonAUG = document.querySelector('#secret-buttonAUG'); // AUG
	var secretParagraphAUG = document.querySelector('#secret-paragraphAUG');///////////////////////////////// 
	var showSecret = false;
	var showSecretMP = false; 
	
	var showSecretMPB = false;
	var showSecretMAR = false;
	var showSecretAPR = false;
	var showSecretMAY = false;
	var showSecretJUNE = false;
	var showSecretJULY = false;
	var showSecretAUG = false;
	/////////////////////////////// 
	secretButton.addEventListener('click', toggleSecretState);
	secretButtonMP.addEventListener('click', toggleSecretStateMP);
	
	
	secretButtonMPB.addEventListener('click', toggleSecretStateMPB);
	updateSecretParagraphMPB();
	secretButtonMAR.addEventListener('click', toggleSecretStateMAR);
	updateSecretParagraphMAR();
	secretButtonAPR.addEventListener('click', toggleSecretStateAPR);
	updateSecretParagraphAPR();
	secretButtonMAY.addEventListener('click', toggleSecretStateMAY);
	updateSecretParagraphMAY();
	secretButtonJUNE.addEventListener('click', toggleSecretStateJUNE);
	updateSecretParagraphJUNE();
	secretButtonJULY.addEventListener('click', toggleSecretStateJULY);
	updateSecretParagraphJULY();
	secretButtonAUG.addEventListener('click', toggleSecretStateAUG);
	updateSecretParagraphAUG();
	/////////////////////////////// 
	function toggleSecretState() {
	  showSecret = !showSecret;
	  updateSecretParagraph();
	  updateSecretButton();
	}
	
	function toggleSecretStateMP() {
	  showSecretMP = !showSecretMP;
	  updateSecretParagraphMP();
	  updateSecretButtonMP();
	}
	
	
	
	function toggleSecretStateMPB() {
	  showSecretMPB = !showSecretMPB;
	  updateSecretParagraphMPB();
	  updateSecretButtonMPB();
	}
	
	function toggleSecretStateMAR() {
	  showSecretMAR = !showSecretMAR;
	  updateSecretParagraphMAR();
	  updateSecretButtonMAR();
	}
	
	function toggleSecretStateAPR() {
	  showSecretAPR = !showSecretAPR;
	  updateSecretParagraphAPR();
	  updateSecretButtonAPR();
	}
	function toggleSecretStateMAY() {
	  showSecretMAY = !showSecretMAY;
	  updateSecretParagraphMAY();
	  updateSecretButtonMAY();
	}
	function toggleSecretStateJUNE() {
	  showSecretJUNE = !showSecretJUNE;
	  updateSecretParagraphJUNE();
	  updateSecretButtonJUNE();
	}
	function toggleSecretStateJULY() {
	  showSecretJULY = !showSecretJULY;
	  updateSecretParagraphJULY();
	  updateSecretButtonJULY();
	}
	function toggleSecretStateAUG() {
	  showSecretAUG = !showSecretAUG;
	  updateSecretParagraphAUG();
	  updateSecretButtonAUG();
	}
	/////////////////////////////// 
	function updateSecretButton() {
	  if (showSecret) {
		secretButton.textContent = 'About Thomas'; // GOES BACK TO DEFAULT
	  } else {
		secretButton.textContent = ' Thomas M. Maestas'; // TOGGLE OPEN
	  }
	}
	
	function updateSecretButtonMP() {
	  if (showSecretMP) {
		secretButtonMP.innerHTML = 'DAILY &nbsp;&nbsp;  TECH &nbsp;&nbsp; MISSION &nbsp; STATEMENT'; // GOES BACK TO DEFAULT
		secretButtonMP.style.fontFamily = 'Monoton';
	  } else {
		secretButtonMP.innerHTML = 'DAILY &nbsp;&nbsp;  TECH &nbsp;&nbsp; MISSION  &nbsp; STATEMENT ';
		secretButtonMP.style.fontFamily = 'Monoton';
	  }
	}
	
	
	
	function updateSecretButtonMPB() {
	  if (showSecretMPB) {
		secretButtonMPB.innerHTML = '  Close Feb Archives   '; // GOES BACK TO DEFAULT
		secretButtonMPB.style.fontFamily = 'Monoton';
		secretButtonMPB.style.color = 'lightsteelblue';
	  } else {
		secretButtonMPB.innerHTML = 'OUR  &nbsp;&nbsp;  DAILY &nbsp;&nbsp;  TECH &nbsp;&nbsp; FEBRUARY ';
		secretButtonMPB.style.fontFamily = 'Monoton';
		secretButtonMPB.style.color = 'lightsteelblue';
	  }
	}
	
	function updateSecretButtonMAR() {
	  if (showSecretMAR) {
		secretButtonMAR.innerHTML = ' Close March Archives  '; // GOES BACK TO DEFAULT
		secretButtonMAR.style.fontFamily = 'Monoton';
		secretButtonMAR.style.color = 'lightsteelblue';
	  } else {
		secretButtonMAR.innerHTML = 'OUR  &nbsp;&nbsp;  DAILY &nbsp;&nbsp;  TECH &nbsp;&nbsp; MARCH ';
		secretButtonMAR.style.fontFamily = 'Monoton';
		secretButtonMAR.style.color = 'lightsteelblue';
	  }
	}
	
	function updateSecretButtonAPR() {
	  if (showSecretAPR) {
		secretButtonAPR.innerHTML = ' Close April Archives  '; // GOES BACK TO DEFAULT
		secretButtonAPR.style.fontFamily = 'Monoton';
		secretButtonAPR.style.color = 'lightsteelblue';
	  } else {
		secretButtonAPR.innerHTML = 'OUR  &nbsp;&nbsp;  DAILY &nbsp;&nbsp;  TECH &nbsp;&nbsp; APRIL ';
		secretButtonAPR.style.fontFamily = 'Monoton';
		secretButtonAPR.style.color = 'lightsteelblue';
	  }
	}
	function updateSecretButtonMAY() {
	  if (showSecretMAY) {
		secretButtonMAY.innerHTML = ' Close May Archives  '; // GOES BACK TO DEFAULT
		secretButtonMAY.style.fontFamily = 'Monoton';
		secretButtonMAY.style.color = 'lightsteelblue';
	  } else {
		secretButtonMAY.innerHTML = 'OUR  &nbsp;&nbsp;  DAILY &nbsp;&nbsp;  TECH &nbsp;&nbsp; MAY';
		secretButtonMAY.style.fontFamily = 'Monoton';
		secretButtonMAY.style.color = 'lightsteelblue';
	  }
	}
 

	function updateSecretButtonJUNE() {
	  if (showSecretJUNE) {
		secretButtonJUNE.innerHTML = ' Close JUNE Archives  '; // GOES BACK TO DEFAULT
		secretButtonJUNE.style.fontFamily = 'Monoton';
		secretButtonJUNE.style.color = 'lightsteelblue';
	  } else {
		secretButtonJUNE.innerHTML = 'OUR  &nbsp;&nbsp;  DAILY &nbsp;&nbsp;  TECH &nbsp;&nbsp; JUNE';
		secretButtonJUNE.style.fontFamily = 'Monoton';
		secretButtonJUNE.style.color = 'lightsteelblue';
	  }
	}

	function updateSecretButtonJULY() {
	  if (showSecretJULY) {
		secretButtonJULY.innerHTML = ' Close JULY Archives  '; // GOES BACK TO DEFAULT
		secretButtonJULY.style.fontFamily = 'Monoton';
		secretButtonJULY.style.color = 'lightsteelblue';
	  } else {
		secretButtonJULY.innerHTML = 'OUR  &nbsp;&nbsp;  DAILY &nbsp;&nbsp;  TECH &nbsp;&nbsp; JULY';
		secretButtonJULY.style.fontFamily = 'Monoton';
		secretButtonJULY.style.color = 'lightsteelblue';
	  }
	}	
	function updateSecretButtonAUG() {
		if (showSecretAUG) {
		  secretButtonAUG.innerHTML = ' Close AUG Archives  '; // GOES BACK TO DEFAULT
		  secretButtonAUG.style.fontFamily = 'Monoton';
		  secretButtonAUG.style.color = 'lightsteelblue';
		} else {
		  secretButtonAUG.innerHTML = 'OUR  &nbsp;&nbsp;  DAILY &nbsp;&nbsp;  TECH &nbsp;&nbsp; AUG';
		  secretButtonAUG.style.fontFamily = 'Monoton';
		  secretButtonAUG.style.color = 'lightsteelblue';
		}
	  }
	/////////////////////////////// 
	function updateSecretParagraph() {
	  if (showSecret) {
		secretParagraph.style.display = 'block';
		secretParagraph.style.fontFamily = 'Roboto';
		secretParagraph.style.backgroundColor = 'steelblue';
		secretParagraph.style.color = 'aliceblue';
		secretParagraph.style.textAlign = 'left';
	
		secretParagraph.innerHTML = `<div   ><h5 style="text-align:center">Hello, I'm Thomas, Thank you for  visiting my tech blog.</h5>
			<p class="firstparagraph">   Technology shapes much of my life, and in many respects it frames my future plans! <br />
			Technology is integral to my professional, academic, and enterprising endeavors, 
			and I hope to share helpful knowledge from what I've learned along the journey. Besides, 
			I love to chime in about so many topics of the Day... hope you enjoy!
	
		   </p><p  class="firstparagraph"
			My consulting services focus on latest technology with a Master's level data analysis methodology.   My data analysis experience has focused on education evaluation in K-12 and higher education. Now, I handle nearly all domains of data analysis. I focus on web-app design and development, specializing in data visualization with JavaScript and Python programming language.<br /><br /> 
					   
	   </p>
	   <ul class="list-unstyled list-spaced left">
										 <li> Thomas Provides Contractual Services and Consulting for Big &amp; Small Data and Web solutions since 2016 </span>
	
												<a href="http://www.thomasmaestas.net/"> <span> T M M</span></a>
											 
													 <li>Masters Sociology and Bachelors French History <a href="http://www.unm.edu" target="_blank"> <span>University of New Mexico, Albuquerque</span></a>
									  
									
									  
												   <li> Social Media
													<span><a href="https://www.quora.com" target="_blank">Quora,</a><a href="https://www.historum.com" target="_blank"> Historium, </a><a href="https://www.instagram.com" target="_blank">Instagram, </a><a href="https://www.facebook.com" target="_blank">Facebook, </a><a href="https://www.meetup.com" target="_blank">Meet-Up, </a> Hiking Group, and Alliance Francaise</span>
								 
													<li>Began sociology of education doctoral studies at <a href="" target="_blank">l'Universit&eacute; de Montr&eacute;al</a> in the Fall of 2016
													 </li>  
												  <li>Lived in
	<a href="https://www.parisinfo.com/" target="_blank">Paris, France</a> and
	<a href="http://www.ny.gov/" target="_blank">New York</a> and <a href="https://www.visittheusa.com/state/texas" target="_blank">Texas.
	</a>   </li>  
	</ul>
	</div>
	
	
	`;
	
	  } else {
	
		secretParagraph.style.display = 'none';
	
	  }
	
	};
	
	////////
	console.log("TMM PHILOSOPHY");
	
	function updateSecretParagraphMP() {
	
	  if (showSecretMP) {
	
		secretParagraphMP.style.display = 'block';
	
		secretParagraphMP.style.fontFamily = 'Roboto';
		secretParagraphMP.style.background = 'RGBA(1,2,2,.2)';
	
		secretParagraphMP.style.textAlign = 'left';
		secretParagraphMP.style.padding = '10px';
		secretParagraphMP.style.color = 'white';
		secretParagraphMP.innerHTML = `  
	<h4 class="center">My Beliefs &amp; Our Daily Tech Blog Mission</h4>
	
	<p class="dailytitle" >by Thomas Maestas, MA</p> 
	 
	 <p class="firstparagraph">Dialectical Materialism<br />I construct my philosophical guidance from a post-Hegelian, Historical-Materialist Philosophy that sees improvement by each iteration of problem-solving. My personal philosophy holds that right actions and true knowledge begin with a final, teleological goal in sight, i.e., the <i>improvement of the Human condition</i>. <br />Post-Hegelian Logic determines a set, then compares the practical <i>thesis</i> of present empirical, perceived conditions against the ideal <i>antithesis</i> toward higher ethical, rational solutions, in order to achieve an improved synthesis, to again be repeated as a new thesis.</p>
	<p class="firstparagraph">Sharing<br />    
	Given that assumptions about population growth and climate change are true (I believe both are true), then global population well-being is threatened earlier than expected. Therefore, my antithesis holds that  smart, effective <i>Sharing of Burden</i>, Sharing of Power, and <i>Sharing of Resources</i> is critical to meeting the imminent challenges of the two said assumptions.  
	</p>
	<p class="firstparagraph">Diversity and Equality<br />
	Workplace culture too often abides by the ethos of "work harder, not smarter." Non-diverse workplaces lack the full set of problem-solving tools that are necessary in a complex, diverse world. 
	</p>
	<p>A better workforce integration along gender, racial, and socio-economic lines is a more heterogeneous workforce: more agile, creative, and efficiently team-oriented workforce--in short, a smarter workforce.
	</p> 
	`;
	
	  } else {
	
		secretParagraphMP.style.display = 'none';
	
	  }
	
	};
	
	
	
	function updateSecretParagraphMPB() {
	
	  if (showSecretMPB) {
	
		secretParagraphMPB.style.display = 'block';
		secretParagraphMPB.style.fontFamily = 'Roboto';
		secretParagraphMPB.style.opacity = '1';
		secretParagraphMPB.style.color = 'darkslategray';
		secretParagraphMPB.innerHTML = ` 
	 
					<hr />
				 
					<button id="afebtop">
					  <a href="#afebend">PAGE END</a>
					</button>        <hr />
					



					<h4>POSTS FEBRUARY 2018</h4>   <hr />


					
<!--
					<div id="feb-18-02-10">
	
	
	
					  <h5 class="title dailytech longtitle">OUR DAILY TECH: </h5>
					  <h5 class="subdailytech">Musing Blockchain</h5>
	
	
	
					  <p class="author">by Thomas Maestas, MA</p>
	
	
	
	
	
	
	
					  <h6 class="chapternumber">
	
	
	
	
	
	
	
						Feb 10, 2018</h6>
					  <h6>First Blog Post!</h6>
	
	
	
	
	
	
					  <h6 class="chapternumber dailytitle">Why are Sociologists now the Key Players in Data Analysis within the Domain of Blockchain Technologies?</h6>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					  <p class="firstparagraph">Blockchain technologies, i.e. Government contracts, Business contracts, Bitcoin and other
	
					  cryptocurrencies, all rely on network graph theory, both on the low-level programming technology (peer-to-peer global
					  
					  ip networks) across the spectrum to high-level interfaces for institutional, corporate, individual needs and uses.
					  
					  These blockchain &quot;network&quot; analyses depend on highly variable--and simultaneous--network changes, node
					  
					  changes, and link changes; and, the latter three may arbitrarily change interdependantly or not.</p>
					  
					  
					  
					  <p>Therefore, blockchain technologies must first accomodate  complex node variables, including one- or two-way contracts (relationships) that
					  
					   depend on<i> arbitrarily hierarchical mappings and conditional data structures.</i> Secondly, blockchain tech must face analytical
					  
					  challenges that arise from informal practices<sup>1</sup><span class="new">--you can survey opinions, but how do you measure whim?</span>
					  The organizational nodes (employees) choose to deviate from their employment roles&#39; protocol <span class="new">because it it is sunny outside, or maybe because the traffic was long today, or because a butterfly's wing-swish cooled a rash decision down to reason.  That small detail often trumps statistical patterns of efficiency, convenience, company culture, and multiple other levels of analysis of human factors.</p>
					  
					  
					  
					  <p>Sociologists Meyer &amp; Rowan&#39;s (1977)
					  
					  <i>New Institutionalism</i> explains how employees change practices and decouple
					  
					  <i>actual</i> organizational structure from recorded rules, as a function of organizational size, time, convenience,
					  
					  etc. Noone can argue against this wall of reason. <span class="new"><i> The problem is not the reason, the problem is the static, frozen wall called Social Science Theory, constructed from a pastiche of different meanings</i> and arbitrary theoretical starting points.  <span class="new">The esteemed Scholar of Comparative Politics, Dr. Ellen M. Immergut, undermined modern sociology concepts in 1998--a logical blow from which Sociology has never recovered (nor yet faced). She writes:</span>
					  </p>
					  <p class="quote new">
					  Further confusion has arisen because the new institutionalists do not propose one generally accepted definition of an institution, nor do they appear to share a common research program or methodology. In fact, three separate branches of scholarship--rational choice, organizational theory, and historical institutionalism -- all lay claim to the label, seemingly without adhering to an overarching theoretical framework.<sup>3</sup></p>
					  <p class="new">
					  In other words, the long-standing Civil War within the discipline of Sociology (beginning with Functionalists' irreconcilable contradictions of Conflict Theorists' entire World-View--and vice-versa). From this initial schism begins the disassembling of the discipline--as it stands until today. 
					  All of that talent and no single vision to harness a lasting explanatory platform.  And this is <i>before</i> addressing--from a Scientific Method Paradigm--the problem of continually new, unknown constraints on data that must be intimately understood without falling back to the old, "USA Today" habits of 'Theoretical Relativism'.</p>
					  </span>
					  <p>
					  So, how do we recognize unwritten, soft rules and behaviors of a bank, a person,
					  
					  or a company&#39;s internal bot?</p> 
					  
					  <p>The hard sciences domain of Software Engineering, Computer Science, and Mathematics have brilliantly brought the
					  
					  world the blockchain tool, based on a <span class="new"><i>technical, numerical aptitude--numeracy--for which the Hard Sciences can and must share and propogate it's technical expertise and higher standard of metric truth</i><s style="color:purple" class="strike-purple"> not contribute everything, especially relating with</s> to the other sciences that are still lagging behind--namely The Discipline of Sociology</s> toward acclimating to the modern age's social priorities and needs. Ask yourself, how well do 1,000 top blockchain-related programmers understand the multi-dimensional layers of hierarchical social, corporate, and governmental relationship networks--probably 700 of the 1,000. And how many social scientists can understand the technological sciences? Probably 200 out of 1,000. This means that <i>a chunk of the scientific displines suffer from acute innumeracy</i>. So how do we bridge this massive knowledge gap between qualitative meaning in the smart-contract?</span></p>
					  
					  <p>In the past, the layers of abstraction from raw technological tool to societal use was refined, improved, integrated through multiple layers of &quot;middlemen&quot;, such as lawyers, corporate lawyers, government institutions, non-governmental, non-profit and for-profit actors. Blockchain technology, by its very nature, erases the middlemen. Suddenly, one programmer, for example, is writing the same healthcare insurance crypto-contract, that last month an entire team of hospital employees spent a month writing; then overseeing and managing different facets of this same thing.</p>
					  
					  
					  
					  <p>However, the crypto-contract, once deployed to the blockchain, auto-manages the rest, forever or for the life of
					  the contract. Therefore, rather than redoing the trials and errors of 200 years&#39; Sociology Network Analysts&#39;
					  research and analytical development. <span class="new"> Therefore, much of the social scientists have arrived at the end of the line of technology, still shackled to analog methodology relegated to the Sine and Cosine of progress; while the World leaves it behind, led by the Hard Sciences of Software Engineering--the new social fabric of the 21st Century. So, can the anthropological and social domains survive this existential threat to any authority--that depends if the Hard Sciences, Gatekeepers of Empirical Science will extend an open door and pro-actively share technical instructions for the soft sciences.  Therefore, the social sciences are not safe hiding at home, within the academic
					  tower--far removed from the pace of societal and technological change.  
					   </p>
					   
					  
					  <p class="new">The point is this: The innumeracy of the Soft Sciences increasingly loses authority, with the less it can prove at the Command Line Interface. So, how will an analog academic field in the early 21st century compete with artifical intelligence? Problems grow exponentially in the modern age, and only the sciences with  machine-learnig on their side can expect to thrive by applying extraordinary applications of machine-learning to network theories. <span class="new">
					   Sociologists deal with real-time, logical and hierarchical network mappings that appear arbitrary, yet are characterized by fixed patterns. This implies a higher level of competency to accurately judge a point-of-view without the ability to directly consult machine learning. <i>This is a Code or Be Coded moment in the life trajectory of the social sciences.</i></span></p>
					  
					  
					  
					  <p>  <i>the Power  of the Social Sciences, even while paraliyzed, cannot be underestimated:</i> No other academic field than sociology has advanced into the details, and endless network rabbit-holes that characterize societal behavior. Not until this second millenial decade could the marriage of Large Number Statistical Theory
					  
					  become consumated with the brilliance of early 1900&#39;s Sociological French Network Theories, like Maurice Halbswach&#39;s
					  
					  work on the clearly defined network patterns of a society&#39;s Collective Memory.</p>
					  
					  
					  
					  <p>So, current sociology, having collected and refined knowledge on network arbitrariness, such that Economic&#39;s &quot;irrational
					  
					  behaviors&quot; and Mathematical &quot;complexity models&quot; do not
					  
					  <i>touch to the bone</i> the meaning, the intersectionality of network analysis, which must incorporate simultaneous
					  
					  node changes (person gets job /or/ does not get job), network changes (All get jobs /or/ only 3 of 15 network groups
					  
					  get jobs), and most importantly the
					  
					  <i>relationship</i> changes (all jobs always useful /or/ half of job groups no longer useful) across time and fixed.</p>
					  
					  
					  
					  <p>Fine. So, why is Sociology&#39;s network theory so valuable, yet inaccessible, beyond just the network insights gleaned from 19th and
					  
					  20th centuries&#39; network problems?  European sociology came of age in the analog social era, while North
					  
					  American Sociology only recently come of age (Quebec in the 1960&#39;s [post-1968], U.S. in the 1990&#39;s[post-1999],
					  
					  in the digital social era. Therefore, the problem-solving patterns of past sociology are inherently small-data and
					  
					  more qualitative analysis, and thus only Sociology incorporates &quot;human-ness&quot; into the billion rows and
					  
					  columns of quantitative--numbers-only--analysis.</p>
					  
					  
					  
					  <p>For example, Oxford-developed S.I.E.N.A. Software accomplishes this task. SIENA--named for Simulation Investigation
					  
					  for Empirical Network Analysis--software calculates the real-time values, direction, and conditions of each relationship
					  
					  (link) in a network, simultaneously as each node, network, or alter-link changes or is changed; with this, it is
					  
					  possible to isolate directional, conditional
					  
					  <i>influence change</i> in real-time. Real-time sounds impossible, however, the SIENA documentation
					  
					  <sup  >2</sup> describes its program algorithm to the statistical analysis of network data, with the focus on social networks.</p>
					  
					  
					  
					  <p>This is the concept of whether a person
					  
					  <i>self-selects </i>(e.g., due to subconscious leanings) into a group and thus matches to fruition the group&#39;s
					  
					  behavior with little group influence? Or does this same person join a group and emulates the group&#39;s behavior,
					  
					  by the group&#39;s influence over time. Sociological network analysis, using Snjder&#39;s SIENA software, achieves
					  
					  the impossible with the closed, directed graph networks that characterize blockchain technology. The network graph
					  
					  can be here understood as entire (complete) networks (i.e, the blockchain in its entirety without hard forks), not
					  
					  as personal (egocentered) networks: Using this SIENA model allows for the necessary assumptions that a set of nodes
					  
					  (social actors) is given, and all ties (links) between these nodes are known - except perhaps for a moderate amount 
					  of missing data</p> 
					  
					  <p>If, and only if, this level of analysis may be achieved, the blockchain development may follow a linear, directed
					  
					  path of maturity with social and world needs.<span class="new"> Until   Social Science Network Theorists stop from basing their numerical analysis on the mutable sand of theory, rather than theory based on the   foundation of numerical science, <i>any attempt at conclusion...you guessed it...cannot be conclusive.</i>So, the social sciences must consult the hard sciences, otherwise they risk squandering countless years of talented theorists' work; <i>the discipline's executive functions are cut off from it's increasingly inaccessible (and increasingly powerful) knowledge base.</i> --Such a talented, powerful Thoroughbred of a Science, that still wanders without a head for technical direction.</span></p>
					   
					  
					   
	
	
	
	
					  <p class="footnotes">
						<a href="http://www.journals.uchicago.edu/doi/abs/10.1086/226550" target="_blank" id="9one">1. http://www.journals.uchicago.edu/doi/abs/10.1086/226550</a>
						<br />
	
	
	
	
	
	
	
						<a href="https://www.stats.ox.ac.uk/~snijders/siena/" target="_blank" id="9one">2. https://www.stats.ox.ac.uk/~snijders/siena/</a>
	
	
	
	
	
	
	
					  </p>
	
	
	
	
	
	
	
					</div>
	
	
	-->
	
	
	
	
	
	
	
	
	
	
	
	
					<div id="feb-18-02-11">
	
	
	
	
	
	
	
					  <h5 class="title dailytech longtitle">OUR DAILY TECH: </h5>
					  <h5 class="subdailytech">Web Dev Affairs</h5>
	
	
	
	
	
	
	
					  <p class="author">by Thomas Maestas, MA</p>
	
	
	
	
	
	
	
					  <h6 class="chapternumber">
	
	
	
	
	
	
	
						Feb 11, 2018</h6>
	
	
	
	
	
	
	
					  <h6 class="chapternumber dailytitle">How Can We Best Modularize our App Designs in Order to Achieve the Much Vaunted "Separation of Concerns"?</h6>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					  <p class="firstparagraph">There was once a time for App Developers that our habits followed our inner-philosophers--as an Esteemed
						Order of Coders--we held ourselves in the highest regard to separate form from function, and style from
						structural design. Hence, in the early 2000's, a tri-partite, sensible world guided every web coder to
						abide by The scaffolding of HTML, functionality of JavaScript, and styling of CSS. A decade later, we
						must throw out this antiquated division of labor within web coding. </p>
					  <p>Library modularization, (think JQuery, JSX, Bootstrap, etc.) within Javascript ES16 reveals that modules
						and components Must hold together CSS/HTML/JS, part by part. So, if a decade ago three teams handled
						html, js, css, it is now requisite to divide up 3 teams to 3 components (a team for the carousel widget,
						a team for the navigation widgets, and
						<i> each</i> of these component teams
						<strong>must</strong> be maintained together, not separately, the module's required html, js, css. </p>
					  <p>
	
	
	
	
	
	
	
						This means that the new Division of Labour can no longer follow past patterns from 5 years ago. Otherwise, any and all coding
						will necessarily begin to 'reinvent the wheel.' This is because any module, any library you go to, will
						<i>already</i> have its HTML pre-configured, JS pre-configured, CSS pre-configured. Thus, attempts to extricate
						new css from one module to another (or worse yet, sharing css of modules), will only invite eventual
						misery, almost instantly setting booby traps for the next coders upon arrival.</p>
	
	
	
					  <p>So, where is the creativity? Where is the originality then? It is not gone. It has evolved to a higher
						level of abstraction, leaving to automation the boring stuff. So, if Vanilla JS is considered malpractice
						in the modern world, and if ad-hoc JQuery is mocked and scoffed at by React coders, then where is creativity?
						If yesterday's craft was the hoisting of 15 javascript functions on each page, the New Art of modular
						coding is akin to a game of Tetris. Part by part, module by module, the modern coder open-source window-browses
						and window-shops; goes home, and cuts and pastes, and folds and clips, then assembles and hangs to dry.
						Do Python programmers rewrite each particular module definition? That's absurd. Equally absurd is the
						javascript programmer that rewrites from scratch their modules. </p>
	
	
	
					  <p>The esteemed Order of JavaScript Coders must wake up, and regain its work-load balance in this new age--an
						age that each year since 2014, the JavaScript language is rewritten, each year now, in both syntactic
						sugar and also fundamental structure--especially the importing and exporting of modules. Therefore, philosophical
						Honor behooves each of us to a higher complexity, and a new commitment to, the "Separation of Concerns."
						We can allow ourselves a break, thankful for Progress, a progress by which we must
						<i>Stand on the Shoulders of Giants</i>, and Code-Create! </p>
	
	
	
	
	
	
	
					</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					<div id="feb-18-02-12">
					  <h5 class="title dailytech longtitle">OUR DAILY TECH: </h5>
					  <h5 class="subdailytech">Web Dev Affairs</h5>
	
	
	
	
	
	
	
					  <p class="author">by Thomas Maestas, MA</p>
	
	
	
	
	
	
	
					  <h6 class="chapternumber">
	
	
	
	
	
	
	
						Feb 12, 2018</h6>
	
	
	
	
	
	
	
					  <h6 class="chapternumber dailytitle">Mark Zuckerberg's Innocence</h6>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					  <p class="firstparagraph">Facebook Scandals
						<sup>1</sup> of recent months have demoralized the leadership for a role of misinformation in the Tech Age,
						however I charge Mark Zuckerberg's innocence
						<i>not</i> because all of us, as a society, were equally warned. Rather, arbitrary mathematical forces created
						abnormal, never-before-seen network structural density and symmetry patterns. Technological shifts were
						so efficient at multiplying and exacerbating misinformation because a curious sociological network phenomenon
						rendered parts of our daily social learning and acculturating process to network forces out of our own
						control.
					  </p>
	
	
	
	
	
	
	
					  <p>A January 2016 American Sociology Association Newsletter Editorial
						<sup> 2</sup> from Sally T. Hillsman, in which she explained how the social mechanisms of our own misinformation
						were not entirely within our own control to resist. In fact, the arbitrary (often random) social structural
						changes from higher social-media hours, create an arbitrary social network structure whose links (in
						their content and influence) begin to dominate over nodes (each of us). In other words, the sway of trends
						and opinionated critical thought becomes dominated by the relationships, e.g., the "likes" and "shares",
						leading to a statistically natural propensity toward homogeneity--a.k.a. group-think. The mechanism is
						akin to peacefully swimming close and parallel to the coastline, and (due to random coastal floor structure),
						a rip-tide suddenly ships you far out to sea--a fatal and tragic fate rendering experienced swimmers
						out of their own control. Same principle with an arbitrary
						<i>underlying and unseen</i> network structure.</p>
					  <p>Our social network structures always are prone to continual shift, and so the usual "interruptions" that
						previously stopped this inward shift soon began to disappear. Hillsman explains: </p>
	
	
	
	
	
	
	
					  <p class="quote">Lies, half-truths, and misinformation spread so rapidly across the public through digital communication
						that the timespan for thoughtful, effective correction or rebuttal is infinitesimal. Because of confirmation
						Bias, misinformation and outright lies quickly strengthen preconceived truths or pre-held beliefs that
						are already hard to change. </p>
	
					  <p>Therefore, even though we all have been pointedly warned,
						<i> none of us</i> without advanced sociological analysis skills could understand that a curious network
						phenomonenon--ultimately driven by some arbitrary mathematical calculation involving size, density, symmetry,
						conditional influences, and the strength of ties outweighing network nodes. For the reasons of these
						factors, our social inclinations were
						<i>out of our control</i> -- no, but really, this time they were! </p>
	
					  <p>And so, we can learn from Sociology what steps to take in order to counteract random, but risky, network
						phenomena -- because nobody likes to go for a swim at the beach, and unwittingly get shipped out to sea!
	
	
	
	
	
	
	
					  </p>
	
	
	
	
	
	
	
					  <p class="footnotes">
	
	
	
	
	
	
	
						1. Wired Magazine
						<i>Inside the Two Years that Shook Facebook--and the World</i> (February, 2018)
						<a href="https://www.wired.com/story/inside-facebook-mark-zuckerberg-2-years-of-hell" target="_blank"> Wired Magazine, </a>
	
	
	
	
	
	
	
						<br />
	
	
	
	
	
	
	
						<br /> 2. ASA
						<i>Footnotes</i>. (January, 2016)
						<a href="http://www.asanet.org/footnotes/jan16/index.html" target="_blank">
						  www.asanet.org/footnotes/jan16/</a>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					  </p>
	
	
	
	
	
	
	
	
	
	
	
					</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					<div id="feb-18-02-13">
					  <h5 class="title dailytech longtitle">OUR DAILY TECH: </h5>
					  <h5 class="subdailytech">Sociology Tomorrow!</h5>
	
	
	
	
	
	
	
					  <p class="author">by Thomas Maestas, MA</p>
	
	
	
	
	
	
	
					  <h6 class="chapternumber">
	
	
	
	
	
	
	
						Feb 13, 2018</h6>
	
	
	
	
	
	
	
					  <h6 class="chapternumber dailytitle">The Modern Doctors' Updated Preparation for the Oath
						<sup>1</sup> of Hippocrates:
						<br />On the 2015 Social Sciences Modification to the AAMC Medical College Admissions Test (MCAT)</h6>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					  <p class="firstparagraph">Other than college pre-med students, few know the MCAT exam--the gatekeeper of U.S. &amp; Canadian Medical
						Schools--underwent a major modification in 2015.
						<sup>2</sup> Much deeper than Biological and Technological updates, major sections were added and/or expanded
						including the Social, Pyschological and Biological foundations of
						<i>behavior</i>. Named the
						<i>Health Systems Science</i>
						<sup>3</sup>, the American Medical Association's modern, holistic approach articulates outcomes-based measures
						for healthy living and disease prevention efforts. You could say the AMA is indeed,
						<i>woke</i>. </p>
					  <p>But really, what's the difference and why would we care? And, who doesn't know that an apple-a-day keeps
						the doctor away? Dr. Jeffrey Borkan, MD, PHD of Brown University's Warren Alpert Medical School, explains
						the evident role of all those unnoticed social interactions involved in obtaining and consuming that
						apple. Further, the spatial and economic
						<i>availability</i> of that apple also plays a role in keeping the doctor away. Borkan explains:
	
	
	
	
	
	
	
					  </p>
					  <p class="quote">It's time for us to take a leap forward in educating physicians for the health care delivery models of
						the future—those that aim to improve not just the health of the individual patient and their family,
						but also the community and the population.
						<sup>4</sup>
	
	
	
	
	
	
	
					  </p>
					  <p>What, then, specifically, are the mechanisms that a community network's aggregated health may be inextricably
						tied up with
						<i>our own</i> individual health? In short, they are the sharing of health-promoting resources, timely assistance,
						health-promoting information channels -- all this, among the countless perks of a healthy social circle!
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					  </p>
	
	
	
	
	
	
	
					  <p class="citations">
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
						1.
						<a target="_blank" href="http://www.greekmedicine.net/whos_who/The_Hippocratic_Oath.html">The Oath of Hippocrates</a>
						<br /> 2.
						<a target="_blank" href="https://students-residents.aamc.org/applying-medical-school/article/changing-mcat-exam/">The 2015 AAMA Changes to the Medical College Admissions Test</a>
						<br /> 3.
						<a target="_blank" href="https://www.ama-assn.org/education/teaching-new-content-health-systems-science">American Medical Association's
						  <i>Teaching New Content Health Systems Science</i>
						</a>
						<br /> 4.
						<a target="_blank" href="https://www.ama-assn.org/education/teaching-new-content-health-systems-science">ibid.</a>
						<br />
	
	
	
	
	
	
	
					  </p>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					<div id="feb-18-02-14">
	
	
	
					  <h5 class="title dailytech longtitle">OUR DAILY TECH: </h5>
					  <h5 class="subdailytech">
						<s>Web Dev Affairs</s> Sociology Tomorrow!</h5>
	
	
	
	
	
	
	
					  <p class="author">by Thomas Maestas, MA</p>
	
	
	
	
	
	
	
					  <h6 class="chapternumber">
	
	
	
	
	
	
	
						Feb 14, 2018</h6>
					  <p style="color:green;">
						<i>Due to the Tragic Events in Florida, Tech to the Rescue blog Rescheduled to February 16th ...]</i>
					  </p>
	
	
	
	
	
	
	
					  <h6 class="chapternumber dailytitle">
						<s>Tech to the Rescue: Secondary health effects of the Fitbit toward health-information sharing channels
						  within a community.</s>
					  </h6>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					  <p class="firstparagraph" style="color:green;">
						<s>Given that a community network's aggregated health is inextricably, and symmetrically, tied up with
						  <i>our own</i> individual health, app-developers may design activity- and communication-based apps more
						  responsibly, and in touch with modern healthcare recommendations. After all, if the Saintly Mark Zuckerberg's
						  communication- and activity-based app inadvertantly led to novel, and deeply consequential, effects,
						  then ...
						  <br />
					  </p>
	
	
	
	
	
	
	
					  </s>
					  <span class="alert">* Given the Tragic Events in the School Shooting in Florida, I felt a topic of more gravity was in order
						... :(
	
	
	
	
	
	
	
					  </span>
	
	
	
	
	
	
	
					  <h6 class="chapternumber">
	
	
	
	
	
	
	
						Feb 14, 2018</h6>
	
	
	
	
	
	
	
					  <h6 class="chapternumber dailytitle">A New Kernel, and the Manifestation of a Two-Hundred Year Problem named
						<i>Anomie</i>
					  </h6>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					  <p class="firstparagraph">Given the tragic events at a Florida school over Valentine's Day, 2018, who can write about Fitbits? So,
						thoughts and sympathy for those students today that endured this horror. 19 years after the first-of-its-kind
						school shooting, we as an American society have not become 'numb' to these events. It hurts as much as
						it did in 1999.</p>
					  <p> Darn that innocuous Spring day in 1999, when we heard the most absurd news-- students attacked their own
						colleagues at Colombine? In my blog post from January 10, I wrote that American Sociology, along with
						Qu&eacute;bec, came of age much later than European Sociology. The past 50 years' social changes and
						new problems are generally atrributed for the increasing demand for sociological expertise after 1999,
						after a singular, senseless tragedy of a school shooting--this event, like a small kernel of societal
						desperation for a solution--led to a flurry of self-professed sociologists &agrave; la Michael Moore's
						Colombine, and other social-responsibility themed social consciousness. So far, only mutually incompatible
						solutions. The problem, however, is not new, only the manifestation of it.</p>
					  <p>Suicide rates in 19th century France, disproportionately high, also served as a symptomatic manifestation
						of the same problem, called
						<i>Anomie.</i>
						<sup>1</sup> The term,
						<i>Anomie</i>, coined by Emile Durkheim in the late 1800's, captured the sense of instability, cultural
						and moral relativism that undermined a shared sense of meaning. Suicides, week-after-week, month-after-month?
						In 1897 France, noone had ever seen it before--at such rates--and people wanted answers. Alas, a kernel
						of social desperation leading to inquiry.</p>
					  <p>
	
	
	
	
	
	
	
						People wanted to know why so many in the population responded negatively to the rapid changes, urbanization (Dreadful factory
						conditions &agrave; la
						<i>Taylorism's</i> calculated efficiency) new technologies, i.e. electricity, railroads, steam engines;
						these created an arbitrarily new world, very suddenly. Suddenly, like trying for the first time a roller-coaster,
						when all you've ever known has been the carousel. So, we see technology's role for well or for ill, our
						job is to understand how to dial-in the tech specs necessary to keep society smiling on this roller coaster
						through another, yet not altogether new, technological thrill-ride.
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					  </p>
	
	
	
	
	
	
	
					  <p>
	
	
	
	
	
	
	
						1.
						<a href="https://www.researchgate.net/publication/228173911_The_Sociology_of_Suicide" target="_blank">1897, Suicide, &Eacute;mile Durkheim.</a>
	
	
	
	
	
	
	
					  </p>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					<div id="feb-18-02-15">
	
	
	
	
	
	
	
					  <h5 class="title dailytech">OUR DAILY TECH: </h5>
					  <h5 class="subdailytech">Musing Blockchain</h5>
	
	
	
	
	
	
	
					  <p class="author">by Thomas Maestas, MA</p>
	
	
	
	
	
	
	
					  <h6 class="chapternumber">
	
	
	
	
	
	
	
						Feb 15, 2018</h6>
	
	
	
	
	
	
	
					  <h6 class="chapternumber dailytitle">Blockchains, Bitcoins and The Unnecessary Risk of Shopping at Target with a Credit Card</h6>
	
	
	
					  <h6>
	
	
	
						<small class="jargon">Tech blockchain jargon alert ahead, with all effort made for clarity! I treat a broad overview of the
						  existing trajectory of blockchain-related micro-economic advancements. I make a technical &amp; contextualizing
						  <abbr title="this link just goes down 5 paragraphs to Feb. 17th">
							<a href="#18-02-17"> three-part blog series in my Feb. 17-20 posts</a> on the micro-economic horizon of blockchain technologies.</abbr>
						</small>
	
	
	
					  </h6>
	
	
	
					  <p class="firstparagraph">Has anyone else been underwhelmed by the lack of Bitcoin's daily
						<i>presence</i>, despite its everpresence at the dinner tables and caf&eacute;s across America. Sure, it's
						more of a "metropolitan" phenomenon; and sure, it's become an accepted global platform--along with myriad
						other crypto-currencies, but it's exchange-worthiness remains shrowded, and misunderstood by many. Cryptocurrencies
						are useful as a vehicle for investment, and yes, there are Bitcoin millionaires due to the currency's
						rise to fame with last year's increase in value (from $1,000 to ~$20,000) etc., etc. But, so far its
						contributions, uses, fame are one-sidedly
						<i>macro-</i>economic. A recent CNET article
						<sup>1</sup>, among others, documents miniscule (and not improving) percentage of
						<i>actual</i> use at the "cash-registers" of society.</p>
	
	
	
	
	
	
	
					  <p>Is there something wrong with such little micro-economic usage? Not at all! According to general sociological
						<i>Early Adopter</i> theory--based on Everett M. Roger's Diffusion of Innovations
						<sup>2</sup>--the timeline of the Innovation Adoption Lifecycle is fairly ordinary. That is, the Roger's bell
						curve ranges from the beginning innovators, to early adopters, early majority, and late majority. However,
						the blockchain articles always miss the point. Currencies are more of a distraction compared to the genuine
						usefulness for the every-person, in every-day affairs, on a given day--i.e., micro-economic use.</p>
	
	
	
	
	
	
	
					  <p>The true value, the kind that makes our lives easier on any given day, and for the every-person, is
						<i>not</i> the currency, it is the contract, that allows for individualized, targeted sharing of specific
						information--whether financial, governmental, or any other centralized database. An example is in order
						before I continue, since we can all relate to the risk of using a credit or debit card, the risk most
						notably concerning Target store credit card hacks a couple years ago. </p>
					  <p>Suppose a person shops at 3 different retailers, using a different credit card for each. For these 3 transactions,
						this person had only needed to provide two discrete pieces of information about themselves for each transaction:
						they prove they have the $27, $200, and $5; and they prove a third party(i.e.,CC or bank)will make that
						$27, $200, or $5 available, if their client agrees. Instead, for each transaction, they open their
						<i>entire</i> financial information, and can only hope that law-enforcement will prevent cyber-theft; and
						if the store's databases are hacked, then tough-luck! </p>
					  <p>Crypto-contracts provide the technology for this individualized, risk-free transaction, rather than for
						each transaction, providing the generalized information for individual transaction. Highly inefficient!
						Nobody thinks to walk around with their life-savings in cash, then at the 7-11 store, to open their wad
						of cash and peel out a bill. The credit card system, blessed as it is, did not previously have technology
						to avoid this very thing. So, financial institutions have had to rely on the many layers of security,
						passwords, pins, mothers' maiden names, etc. Then, based on the mathematics behind prime numbers, they
						hope to keep your money safe in one, centralized spot--with a bright red target on it. </p>
					  <p>Now, the crypto-contract provides this decidedly *micro-economic* experience for the everyday person. And
						that, my friends, has nothing to do with crypto-currencies. There is no micro-economic value in crypto-currency,
						instead the crypto-
						<i>contract</i> is the true, unsung hero, and a hero we will all get to know. [personal opinion - this hero's
						name is the Ethereum Virtual Machine]. In any case, Crypto-contracts provide this ability to provide
						pinpointed,
						<i>specific, targeted information</i> as citizens, too. When we provide our drivers license number, for
						the sake of renting that car, we provide every aspect of information of ourselves to Hertz. They don't
						need this. They need to know only and exclusively driving-record related details--not the entire governmental
						database of information about you!
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					  </p>
	
	
	
	
	
	
	
					  <p>1.
						<a href="https://www.cnet.com/news/bitcoin-cryptocurrency-big-in-investing-but-still-lousy-for-buying-a-sandwich/" target="_blank">https://www.cnet.com/news/bitcoin-cryptocurrency-big-in-investing-but-still-lousy-for-buying-a-sandwich/</a>
	
	
	
					  </p>
	
	
	
					  <p>
	
	
	
	
	
	
	
						2.
						<a href="https://eric.ed.gov/?id=ED065999" target="_blank">Rogers, E. M., & Shoemaker, F. F. (1971). Communication of Innovations; A Cross-Cultural Approach.</a>
	
	
	
	
	
	
	
						<br />
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					  </p>
	
	
	
					</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					<div id="feb-18-02-16">
	
	
	
					  <h5 class="title dailytech">OUR DAILY TECH</h5>
	
	
	
					  <h5 class="subdailytech">Web Dev Affairs</h5>
	
	
	
	
	
	
	
					  <p class="author">by Thomas Maestas, MA</p>
	
	
	
	
	
	
	
					  <h6 class="chapternumber">
	
	
	
	
	
	
	
						Feb 16, 2018</h6>
	
	
	
	
	
	
	
					  <h6 class="chapternumber dailytitle"> Tech on the Regret: Unintended, secondary effects of communication- and activity-based app-designs </h6>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					  <p class="firstparagraph">Given that our app-use is inextricably tied up with our own behavior, activity/communication-based app
						developers have in the past year accepted (mostly in word) a renewed responsibility. More like resposibility
						for a multi-faceted power of influence granted to an industry, suddenly, disproportionately great, and
						<i>semi-arbitrarily related</i> to the designer's intent (and control!). After all, if the Saintly Mark
						Zuckerberg's activity/communication-based app inadvertantly led to novel, and deeply consequential, effects,
						then anyone could. </p>
					  <p>After all, who could guess
						<i>how</i> these app-design effects would affect the users, years later. Who do we think programmers are,
						sociologists? More specifically, who could know
						<i>which</i> mundane coding practices, arbitrary app-design--like sharing permissions/features? Sure, everyone
						deep down knew their company practices yield unfathomable power of influence over the daily habits of
						cell-users, a.k.a. everyone. The easy part is knowing; the hard part is learning how and why certain
						app-features lead to behavioral risks.</p>
					  <p>There could be no better example than the Alcoholic faced with an intervention by a loving family longing
						for change. The alcoholic could be forgiven for past misdeeds, but without actual
						<i>Acknowledgement</i> of a crisis in direction, which necessitates professional help from social scientists.
						Therefore, the recent
						<i>acknowledgments</i> signify something deeper--they signify a humility that app-designers are not sociologists,
						generally speaking. So, that means hiring sociologists, psychologists, anthropologists for every N
						<small>th</small> app-coder and software engineer. History can't be rewritten, but it can be interpreted and
						learned from. The acknowledgment is itself a victory if it induces learning from the raw, social sciences,
						whose expertise
						<i>can</i> predict how or why certain "life"-features, practices, and policies often unfold with undue and
						unintended social consequences. </p>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					  <p>Water under the bridge, but going forward, it is one thing to claim a "renewed sense of remorse", another
						to acknowledge, learn and change. Like last November
						<sup>1</sup> when Facebook co-founder Sean Parker confessed certain designs like "social-validation feedback
						loop" and other app-design intentions, while ignoring potential secondary effects on society. So, the
						<i>Acknowledgment</i> is the big win here--not so much the remorse!
	
	
	
	
	
	
	
					  </p>
	
	
	
	
	
	
	
					  <p>1.
						<a href="https://digitaladdictsblog.com/facebook-co-founder-says-company-built-to-exploit-you/" target="_blank">https://digitaladdictsblog.com/facebook-co-founder-says-company-built-to-exploit-you/</a>
					  </p>
	
	
	
					</div>
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
					<div id="feb-18-02-17">
					  <h5 class="title dailytech">OUR DAILY TECH</h5>
	
	
	
					  <h5 class="subdailytech">Musing Blockchain</h5>
	
	
	
	
	
	
	
					  <p class="author">by Thomas Maestas, MA</p>
	
	
	
	
	
	
	
					  <h6 class="chapternumber">
	
	
	
						Feb 17-18, 2018
						<br /> Weekend
	
	
	
					  </h6>
	
	
	
	
	
	
	
					  <h6 class="chapternumber dailytitle">Blockchains, Bitcoins and The Unnecessary Risk of Shopping at Target with a Credit Card, Part II:
						<br />
						<br />Seven Nuts &amp; Bolts Features of the New Blockchain Micro-Economy
						<br />
	
	
	
						<small class="jargon">Tech jargon alert ahead, with all effort made for clarity! Here, I provide a technical &amp; contextualizing
						  addition to my
						  <abbr title="this link just goes up 7 paragraphs to Feb. 15th">
							<a href="#18-02-15"> February 15th blog post</a>
						  </abbr> on the micro-economic horizon of blockchain technologies. </small>
					  </h6>
	
	
	
					  <p class="firstparagraph">7 Ethereum-based technological features offer us a new world -- a decentralized new world, not dependent
						on the centralized servers of Instagram, Comcast, T-Mobile, Amazon, etc. With that statement ends general
						consensus among blockchain experts, pundits, and authors. However, if the current logistical obstacles
						provide controversy and competing algorithms over sustainability, security, and scalability, then they
						reveal much more about the general pathway of social uses (and potential effects) than they hide. In
						my February 15th
						<a href="#18-02-15">blog</a>, I touched on a few features of micro-economic uses so as to distinguish the more certain aspects
						of the crypto-contract horizon.</p>
	
	
	
					  <p>
						<strong>Prologue</strong>
	
	
	
					  </p>
	
	
	
					  <p>So, what are some core features of block-chain technology that affect the quality of our lives, and the
						<i>productivity</i> of our work as a society of academics, public-sector and private-sector professionals?
						First, a little background and context before I outline seven blockchain functionalities. The Ethereum
						blockchain helps distinguish itself--and its blockchain-native language Solidity--from earlier tech,
						like Bitcoin and other Proof of Work-based blockchains. Ethereum blockchain offers a syntax and programming
						features, e.g. "looping", "recursion", with the full power of a
						<i>Turing Complete</i> language--that is, given enough resources, the language can solve any programmable
						problem. </p>
	
	
	
	
	
	
	
					  <p>More background and a clarifying metaphor are in order: The Bitcoin blockchain transaction resembles the
						accounting system of a foos-ball table point rack with a basic calculator glued to the side. In contradistinction,
						An Ethereum blockchain transaction would resemble a network of computers,
						<i>which is itself,</i> a computer--hence, the name Ethereum Virtual Machine. This allows for Quickbooks
						to calculate into a PDF to be sent via an email contract-signing program. Much more useful!</p>
	
	
	
	
	
	
	
					  <p>Therefore, Ethereum's Blockchain is more than a networked, chained list of blocks, like Bitcoin. The Ethereum
						blockchain is actually a "Virtual Machine", like a a big networked "home computer". The native language
						of the blockchain, Solidity, allows for an
						<i>application binary interface</i>, ABI. So, for example, I can type up an Ethereum contract on my home
						computer, then directly access by command line the blockchain itself. In layman's terms, the manner that
						modern-day app, for example Instagram, is a centralized API (Application Programming Interface) that
						allows one programming system to interact with another, such as Instragram offers a "sharing API" that
						connects to hardware contacts, thus facitilating communicating with third-party aplications, like sharing
						your instagram picture to your Facebook account, via your T-Mobile phone's contacts list. This API relationship
						broadly describes the modern world we live in, wherein a Chryser driving system exchanges API information
						with your T-Mobile Bluetooth network system, which exchanges API information with your own contact list,
						and so on, and our lives are made easier. </p>
	
	
	
	
	
	
	
					  <p>So, are we out of the woods? Has Ethereum solved the blockchain question? Yes, if it were the 1920 pre-relativity
						days; However, with the advent of quantum computing, potential security vulnerabilities immediately arise.
						The reason being that digital math uses binary "on/off" calculations, while quantum math implicates a
						tertiary,
						<i>qubit</i> "simultaneous states". Therefore, we have now entered the 3rd generation of blockchain technology,
						both programmable, but also quantum-proof due to mathematical graph features. For example, IOTA's blockchain
						design utilizes a
						<i>Winternitz One-Time Signature</i>, by which one's transaction is entered into with a private-key, and
						the blockchain moreso resembles a "Tangle" of a directed graph, which allows for computational "states".
						IOTA recently garnered criticism in January 2018 due to an unfortunate crypto-hack, that exposed an apparent
						vulnerability. In truth, this was a case of user-error because users were
						<i>re-using</i> their one-time keys, which significantly decreases security to the point that a home computer
						could crack the code! I choose to not digress further, and quantum computing is not quite advanced enough
						now to cause damage, but in the future could potentially split the blockchain in two, or other quantum
						possibilities.
	
	
	
					  </p>
	
	
	
					  </p>
	
	
	
					  <p>In sum, the technical obstacles change each month, however one must not lose sight of the forest for the
						trees. Social useablity, potential scope and of course unintended consequences have all finally begun
						to emerge, at least in form, with little difference between the 2nd generation blockchain or the 3rd
						generation Patrician directed graph blockchain. The underlying principle of the blockchain's micro-economic
						utiliity through crypto-
						<i>contracts</i> is the same, as opposed to plain crypto-currency. you know the usual bartering solutions
						for Supply &amp; Demand leading to Economics Game Theory, etc. This is where we must take our leave of
						the Hard Sciences of Mathematics, and enter the realm of Sociology, Psychology, Anthropology and Economics.
	
	
	
					  </p>
	
	
	
					  <p>
	
	
	
					  </p>
	
	
	
					</div>
	
	
	
	
	
	
	
					<div id="feb-18-02-19">
					  <h5 class="title dailytech">OUR DAILY TECH</h5>
	
	
	
					  <h5 class="subdailytech">Musing Blockchain</h5>
	
	
	
	
	
	
	
					  <p class="author">by Thomas Maestas, MA</p>
	
	
	
	
	
	
	
					  <h6 class="chapternumber">
	
	
	
						Feb 19, 20189</h6>
	
	
	
	
	
	
	
					  <h6 class="chapternumber dailytitle">Blockchains, Bitcoins and The Unnecessary Risk of Shopping at Target with a Credit Card, Part III:
						<br />
						<br />Seven Features of the New Blockchain Micro-Economy
						<br />
	
	
	
						<small class="jargon">Tech jargon alert ahead, with all effort made for clarity! The first 3 of 7 new possibilities thanks
						  to the programmable blockchain.</small>
					  </h6>
	
	
	
					  <p class="firstparagraph">
	
	
	
						The guiding light through the centuries of scientific paradigms, in the Kuhnian sense
						<sup id="19-1">1</sup>, have derived from deductive ideas from above - whether priestly or royal decree. Then, the primacy
						of the
						<i>Scientific Method</i> from the Renaissance forward--punctuated first by Copernican Heliocentrism, then
						other Paradigm Shifts--has directed rational and ethical norms in each respective period, e.g. Enlightenment
						authors of 17th, 18th century. Fast forward to the modern period, wherein the current era's emerging
						paradigm holds Sharing as a collective-priority and responsibility, then an amazing philosophical moment.
						<i>Historical Materialism</i>
						<sup>2</sup> prescribes what is directly here a novel Paradigm Shift by which authority is not derived from
						governmental, financial sources, but rather the
						<i>shared</i>societal consensus about cryptographic, mathematical proofs as true authority. Further, the
						revolutionary shift also innately provides tools for implemention through decentralized, programmable
						data-sharing. Cryptography has in a sense become a
						<i>de jure</i> middle-person for identification and verification of property. </p>
	
	
	
	
	
	
	
					  <p>
	
	
	
						<strong>I. Protecting rights through immutable records</strong>
						<br />Inalieable Rights can now be identified and verified by the cryptographic authority of a mathematical
						proof, rather than exclusively through governmental or financial institutions from above. The modern
						period also has held this decentralized, individual authority as the
						<i>a priori</i> starting points for philosophical proofs. Premises about truth begin with the conditions
						of humankind, not idealogies. In fact, it was the
						<i>Young Hegelians</i> of early 19th century Vienna &amp; Berlin, who ushered in the Modern Era of Western
						Philosophy, by laying out Truth as inverted, beginning from the empirical "ground" upward. This "upside-down
						tree" defines philosophical modernity. Jean-Paul Sartre wrote that the whole of
						<i>Existentialism</i> and 20th century philsophy is a mere subset, and never escapes Continental Materialism,
						as argued in Sartre's
						<i>Search for a Method</i>.
						<sup>3</sup>
					  </p>
	
	
	
					  <p>All of the Sciences, prodded by this Truth of Empiricism, followed suit through all the tech innovations
						since Hegel. I'm so surprised by this, because for me, the role of cryptography is shocking on two levels.
						First, cryptography resemblees philosophy rather than the Empiricism that I had envisioned would govern
						social rule (Some once thought nuclear sciences held this role--no longer! Mathematics takes the crown.
						Secondly, I'm still dumbfounded that a Paradigm Shift
						<i>first</i> offers the tools to fulfill itself? Staggering to consider the arbitrary changes ahead for
						a society that is provided the tools of social structural change first, but how quite convenient!
	
	
	
					  </p>
	
	
	
	
	
	
	
					  <p>
						<strong>II. Bureaucratic Atomization in a True Sharing Economy</strong>
					  </p>
	
	
	
					  <p>It is satisfyingly reassuring to see the good-natured, altruistic efforts among the thousands, upon thousands
						of open-source volunteers, and blockchain innovators, like Vitalik Buterin author of Ethereum Virtual
						Machine, whose aims and efforts make staggering progress each quarter. The potential for removing the
						"middle-person" from the day-to-day, micro-economic "cost of living". This goes for for the exchanging
						of titles, legal documents, etc. </p>
					  <p>Sharing of Resources is, in my personal opinion, critical to global future--both out of increasing necessity
						in allocating increasingly limited resources; an arbitrary rearrangement of
						<i>Social Structure</i> and distribution of its resources. While the exponential population growth looms
						on the near horizon, a clear, pre-existing solution begins with a focus on
						<i>smart</i>, effective sharing of resources. The driving principle of sustainability is made convenient
						by means of blockchain technology, extending for example to local economies, cooperatives, ride-sharing,
						etc. </p>
	
	
	
					  <p>
						<strong>III. Removing Double-Dipping from International Remittances </strong>
	
	
	
					  </p>
	
	
	
					  <p>
						<i>"Perfection is achieved, not when there is nothing more to add, but when there is nothing left to take
						  away."
	
	
	
						</i>
	
	
	
						<br /> --Antoine de Saint-Exup&eacute;ry, 1939</p>
	
	
	
					  <p>
	
	
	
	
	
	
	
						Taxes and tariffs are difficult enough, the double-dipping of the current international remittance system, &aacute; la Western
						Union, does not reflect the global, sharing Economy of 2018. The existing remittance system (not speaking
						to
						<i>centralized</i>, middle-man alternatives like PayPay, etc.)--supposing if I wire $2 Loonie to a Canadian
						friend's Canadian Bank--requires payments executed through two separate bank transactions in two national
						payments systems, thus the sending country and receiving country each take a cut. Like everything else--c'est
						la vie. Or is it? The beauty of Ethereum is that it "talks" well with others and across borders, while
						Bitcoin remains of little use for micro-transactions that involve semi-basic calculations. The reason
						being that Bitcoin blockchain language, Script, cannot support loops (while statements, etc.) </p>
					  <p>Currently, both EOS and Ethereum blockchains appear poised for the most financial-friendly blockchain tech.
					  </p>
	
	
	
	
	
	
	
					  <p>
	
	
	
						<a href="https://www.economist.com/news/business/21722869-anti-establishment-technology-faces-ironic-turn-fortune-governments-may-be-big-backers"
						  target="_blank">1. https://www.economist.com/news/business/21722869-anti-establishment-technology-faces-ironic-turn-fortune-governments-may-be-big-backers</a>
	
	
	
					  </p>
	
	
	
					  <p>
	
	
	
						2.
						<a href="https://blog.ethereum.org/2016/02/09/cut-and-try-building-a-dream/" target="_blank">https://blog.ethereum.org/2016/02/09/cut-and-try-building-a-dream/</a>
	
	
	
					  </p>
	
	
	
					  <p>
	
	
	
						3.
						<a href="http://www.bard.edu/library/arendt/pdfs/Sartre-Search.pdf" target="_blank">
						  <i> Search for a Method</i>, Jean-Paul Sartre, 1957</a>.
						<br />
						<small>Sartre would later be awarded the Nobel Prize in 1964, but declined it.</small>
					  </p>
	
	
	
					  <p>
	
	
	
						<a href="https://projektintegracija.pravo.hr/_download/repository/Kuhn_Structure_of_Scientific_Revolutions.pdf" target="_blank">4. Kuhn, Thomas, The Structure of Scientific Revolutions, </a>
	
	
	
					  </p>
	
	
	
	
	
	
	
					  <p>
	
	
	
						<a href="https://hbr.org/2017/01/the-truth-about-blockchain" target="_blank">5. Harvard Business Review,
						  <i>The Truth about Blockchain, Feb. 2017. (This is an older article, but very clear &amp; insightful)</i>
						</a>
	
	
	
					  </p>
	
	
	
					</div>
	
	
	
	
	
	
	
					<div id="feb-18-02-20">
					  <h5 class="title dailytech">OUR DAILY TECH</h5>
	
	
	
					  <h5 class="subdailytech"></h5>
	
	
	
	
	
	
	
					  <p class="author">by Thomas Maestas, MA</p>
	
	
	
	
	
	
	
					  <h6 class="chapternumber">
	
	
	
						Feb 20, 2019</h6>
	
	
	
	
	
	
	
					  <h6 class="chapternumber dailytitle">Blockchains, Bitcoins and The Unnecessary Risk of Shopping at Target with a Credit Card, Part IV:
						<br />
						<br />Seven Features of the New Blockchain Micro-Economy
						<br />
	
	
	
						<small class="jargon">Tech jargon alert ahead, with all effort made for clarity! The 4th through 7th outlined Features of the
						  New Blockchain Micro-Economy</small>
					  </h6>
					  <br />
	
	
	
					  <p class="firstparagraph">I feel that data is one of the more underestimated new commodities of the age. Most visualize data as rows
						and columns, and at most only non-conditional dynamic data. Data are not so mute! Data, in most object-oriented
						languages at least, represents
						<i>functions</i>, conditions, and predicted values. And so, our own behavior, coupled with our networks'
						behavior, coupled with predictive analytics--this represents a wealth of information beyond our attributed
						or inherited traits. The programming is
						<i>in</i> the data, however, citizens have become less and less involved, ceding app by centralized app
						our own information and ensuring profit to 3rd party marketers. The centralized nature of the internet
						allows for this, while the new landscape of
						<i>decentralized applications</i> (DAPP) completely upends this structure of the status quo.
	
	
	
					  </p>
	
	
	
	
	
	
	
					  <p>
						<strong>IV. Enabling citizens to own &amp; monetize their data (&amp; protect privacy)</strong>
						<br /> Ethereum offers a decentralized solution to "owning" one's own data, as data can be decentralized and
						returned to the individual's control, and
						<i>profit</i>. As sure as the 19th century's "labor-hour" became commodified to a calculable asset, i.e.
						property, which
						<i>another</i> party controls and makes profit; And as sure as the 20th century's data analytics became
						commodified into calculable assets for another party to take control and make profit; then only now in
						this 21st century does technology offer a new, more egalitarian path.
	
	
	
					  </p>
	
	
	
	
	
	
	
					  <p>
						<strong>V. Ensuring compensation for the Creators of Value
						  <br />
						</strong>
	
	
	
						So, how would decentralized innovations of blockchain
						<i>distributed ledger</i> technology compensate those whose actions, behavior, opinions, friend-networks,
						artwork, music, videos and other contributions profit the creator?
	
	
	
					  </p>
	
	
	
					  <p>
						<strong>VI. The Halcyon Age of Transaction-Chain Enterprise</strong>
					  </p>
	
	
	
					  <p class="quote">
	
	
	
						According to Greek Mythology, the days of eery, noticeable lack of storms have never been interpreted as a period of grace.
						Moreso,
						<i>Halcyon</i> tranquility only means a temporary moratorium on the winds and waves, imposed by Aeolus,
						God of Wind, to protect the nesting eggs of Alcyone, his daughter. </p>
	
	
	
					  <p> If blockchain tech changes how we do research, analysis, and forecasting, as much as it changes international,
						and cross-industry transactions, then are we faced with a similar dilemma as the "novelty", and double-dealing,
						of multi-nationals of the 1990s? No, because blockchain renders organizations, even those with a spotty
						past, into transparent, democratic, efficient, secure and easily scrutinized.
	
	
	
					  </p>
	
	
	
					  <p>
	
	
	
						After all, without transparent proof, how else would I know my bananas are the "pura vida" Costa Rique&ntilde; ones? More
						importantly, what was the carbon footprint of that banana's journey from its native soil to my breakfast
						table? New blockchain companies like
						<a href="https://www.provenance.org/">Provenance.org</a>,
						<a href="http://www.skuchain.com/" target="_blank">skuchain</a>,
						<a href="http://www.blockverify.io/">http://www.blockverify.io/</a> are a few noticeable game-changers. So, for bananas not backed by mathematical
						proofs, I really have to ask myself, is it
						<i>really</i> an authentic Fair Trade banana? </p>
	
	
	
	
	
	
	
					  <p>Transactions are hardly valuable in the products themselves, if removed from the value of the
						<i>transaction per se</i>. International supply chain transactions, by virtue of a recently possible decentralized,
						permanent record and monitoring, have begun to make inroads in agriculture, petroleum, pharmaceuticals,
						food-supply and other multi-stage industries. </p>
	
	
	
	
	
	
	
					  <p>If corporate and governmental transactions are to be made public--many bearing enterprise or State secrets,
						then will forecasting also go the way of birds? Possibly. Online platforms like Augur
						<sup id="20-8">8</sup>are creating global, decentralized prediction markets, in domains like sports betting, financial
						markets speculation and so forth. Armed with vast, transparent knowledge, the everyday person can now
						access the whims and power of Aeolus, and forecasting the winds of Fortune.</p>
	
	
	
	
	
	
	
					  <p>
	
	
	
						<strong>VII. Reinventing Government &amp; Democracy</strong>
						<br /> ...to be completed...
	
	
					  </p>
	
	
	
					  <p>1.
						<a href="https://www.provenance.org/" target="_blank">
	
	
	
						  https://www.provenance.org/
	
	
	
						</a>
					  </p>
	
	
	
	
					  <p>2.
						<a href="http://www.skuchain.com/" target="_blank">
	
	
	
						  http://www.skuchain.com/
	
	
	
						</a>
					  </p>
	
	
	
	
					  <p>3.
						<a href="http://www.blockverify.io/" target="_blank">
	
	
	
						  http://www.blockverify.io/
	
	
	
						</a>
					  </p>
	
	
	
	
	
					</div>
	
	
	
					<div id="feb-18-02-21">
	
	
	
					  <h5 class="title dailytech">OUR DAILY TECH</h5>
	
	
	
					  <h5 class="subdailytech">Data Analysis Musing</h5>
	
	
	
	
	
	
	
					  <p class="author">by Thomas Maestas, MA</p>
	
	
	
	
	
	
	
					  <h6 class="chapternumber">
	
	
	
	
	
	
	
						Feb 21, 2018</h6>
	
	
	
	
	
	
	
					  <h6 class="chapternumber dailytitle">Facebook-Friendly Third-Generation Data Structures</h6>
	
	
	
	
	
	
	
					  <p class="firstparagraph">Today, I'm going to write about data structures, and challenges that face Vitalik Buterin and other blockchain
						architects. ' Now, why in the
						<i>world</i> would I or anyone else care about ooh, merge sorts, bubble sorts, classificatory trees, and
						the advent of a third form of data structure? </p>
	
	
	
					  <p>Today, we live in an ever more relational world. With all our technology, we just can't wait to hear the
						latest gossip about sister Becky's Boyfriend's Brother's Friend that
						<i>also</i> got to meet Shakira. Gossip to one person is a valuable asset to the data analyst. Because,
						how else could an algorithm draw simultaneous conclusions about two friends that "liked" the same Samsung
						VR, and that they are both located near Best Buy. Thanks to classificatorial wisdom of AI &amp; plain
						machine-learning? </p>
	
	
	
					  <p>These relational queries are simply too difficult for relational, row & column SQL data structures. In
						fact, many queries are impossible, due to unprescient database schema architectures. Next, with the need
						to "objectify" data into non-relational objects, rather than an antiquated, rigid row-and-column design.
						Thus, the second major type of data structure is more flexible and adept in finding these relational
						queries that are ever more in vogue. However, the crystal-like, pristine non-relational, No-SQL designs
						quickly turn to spaghetti, and are poor for scalability. Between a rock and a hard place, a third data
						structure has emerged in recent years.</p>
					  <p>
	
	
	
						Graph Data Structures
						<sup>2</sup> allow data queries that had otherwise been impossible to capture in an entity relationship diagram.
						The ideal example to clarify is the manner that the Swiss banks' accounts were discovered to be hiding
						vast amounts of hidden taxes, etc. The cover-up was so well-constructed that not until new, graph database
						queries discovered patterns of money flow
						<sup>1</sup>:
	
	
	
					  </p>
	
	
	
					  <p class="quote">
	
	
	
						The data was then turned into a graph format to detect then fine-tune the connections between the nodes. The Swiss Leak held
						around 60,000 files that contained information about over 100,000 clients in 203 countries, which means
						that the resulting graph database had more than 275,000 nodes with 400,000 relationships among them.
					  </p>
	
	
	
					  <p class="quote">
	
	
	
						By being able to easily visualise the networks around clients and accounts, the reporters found many more connections than
						they had before, which lead to the Swiss Leaks revelations soon being shared with the public and regulators
						across the globe.
	
	
	
	
	
	
	
					  </p>
	
	
	
					  <p>And you thought that plagiarism-detecting software was impressive for complexity! The beauty of this newly
						available software (even Microsoft jumped on board in recent years) means that sociologists, economists
						can begin to make better headway in the way that our many interactions become more complex with more
						data. Remember, in the past ten minutes, more data information was just produced than most of human history!
						Thus, new and upcoming needs in domains like content management &amp; access control, geo-routing (public
						transportation), gene sequencing, bio-informatics, and so on. So, as technology takes us forward, and
						we make our considerations, let's stick by the golden rules of parallel processing, scalability, and,
						now, graph-network mindedness for the new data structures, and schema, of the Era!
	
	
	
					  </p>
	
	
	
					  <p>1.
						<a href="https://www.globalbankingandfinance.com/how-a-graph-database-unearthed-major-financial-improprieties/" target="_blank">
	
	
	
						  https://www.globalbankingandfinance.com/how-a-graph-database-unearthed-major-financial-improprieties/
	
	
	
						</a>
					  </p>
	
	
	
					  <p>
	
	
	
						2.
						<a href="https://neo4j.com/blog/analyzing-panama-papers-neo4j/">By being able to easily visualise the networks around clients and accounts, the reporters found many
						  more connections than they had before, which lead to the Swiss Leaks revelations soon being shared
						  with the public and regulators across the globe.
	
	
	
	
	
	
	
						</a>
						<br />Other major vendors in graph data structures based on Neo4j: OrientDB, ArangoDB, Titan, mongoDB, Complexible
						Stardog, and Franz AllegroGraph.
	
	
	
	
	
	
	
					  </p>
	
	
	
					</div>
	
	
	
	
	
	
	
					<div id="feb-18-02-21">
	
	
	
					  <h5 class="title dailytech">OUR DAILY TECH</h5>
	
	
	
					  <h5 class="subdailytech">Musing Blockchain</h5>
	
	
	
	
	
	
	
					  <p class="author">by Thomas Maestas, MA</p>
	
	
	
	
	
	
	
					  <h6 class="chapternumber">
	
	
	
	
	
	
	
						Feb 22, 2018</h6>
	
	
	
	
	
	
	
					  <h6 class="chapternumber dailytitle">Languages</h6>
	
	
	
	
	
	
	
					  <p class="firstparagraph">While I've had blockchain-related topics on the mind lately, it seems I can't escape it as I broach new
						fields--blockchain is everywhere! Well, I had begun my blog with intentions about the accelerated speed
						of language and syntax formation, and the curious phenomenon I'd call, for lack of a better word or or
						my own reading, "declarative-syntax-merging". This involves the curious, and largely unknown, growth
						of JavaScript scripting language into almost every domain of web apps, data analysis, and even the bounds
						of
						<i>Logic</i> itself. Though I won't submit my readers to a history of a language, suffice it to say that,
						"If a certain algorithm, device, or object is programmable, then it will eventually be programmed in
						JavaScript."
	
	
	
					  </p>
	
	
	
					  <p>Without getting into technicals, I'll instead use a perfect metaphor--the manner by which English merged
						with French, beginning with the conquests of William of Normandy, around 1096 onward. Almost a thousand
						years later, we can see how English grammar inherited it's Anglo-Saxon Linguistic roots, along with the
						core vocabulary; Then, as English vocabulary moves past the first few thousand core words, e.g. "milk"
						or "house" from "melche" or "haus", then more than 70% of English Vocabulary is directly inherited from
						French, e.g. "lactose" or "mansion" from "lait" or "maison".</p>
	
	
	
					  <p>Similarly, the language of the web and original browsers, JavaScript, has similarly morphed into a new
						language called Solidity, but in only a micro-fraction of English's time. The usual FOMO logic propels
						coding language use, for example FOMO induced Microsoft's flagship Text Editor, Visual Code, to adopt
						it years ago.
						<sup id="22-1">1</sup> The language of Ethereum Blockchain is Solidity, which like the above example, has two parents,
						one non-legitimate. It is in all respects totally JavaScript, yet with object-oriented elements of C++.
						For the layperson, let's just say Solidity resembles a "Liger", in it is at it's core JavaScript, yet
						with increasing sophistication based on C++ logic, its head and torso has begun to resemble the powerful
						machine-code of C++ ever more. And it is a beautiful, but curious phenomonenon.
	
	
	
					  </p>
	
	
	
	
	
	
	
					  <p>
						<a href="http://www.ibtimes.co.uk/microsoft-adds-ethereum-language-solidity-visual-studio-1552171">http://www.ibtimes.co.uk/microsoft-adds-ethereum-language-solidity-visual-studio-1552171</a>
	
	
	
					  </p>
	
	
	
	
	
	
	
					</div>
	
	
	
	
	
	
	
	
	
	
	
					<div id="feb-18-02-23">
	
	
	
					  <h5 class="title dailytech">OUR DAILY TECH</h5>
	
	
	
					  <h5 class="subdailytech">Sociology Tomorrow!</h5>
	
	
	
	
	
	
	
					  <p class="author">by Thomas Maestas, MA</p>
	
	
	
	
	
	
	
					  <h6 class="chapternumber">
	
	
	
	
	
	
	
						Feb 23, 2018</h6>
	
	
	
	
	
	
	
					  <h6 class="chapternumber dailytitle">1.4 Million Reasons for more Women in Tech</h6>
	
					  <a href="#18-03-08" rel="stylesheet">
						Blog addressed again March 8, 2018
					  </a>
	
	
	
	
	
					  <p class="firstparagraph">1.4 million
						<i>new</i> jobs by 2020; End over end, year after year, the computer programming industry continues to add
						another 20% more jobs each year, for the next five years. This is the only field that demand outstrips
						the supply--and increasingly short supply. So much so, the US Department of Labor forecasts U.S. citizens
						will be able to fill 39% of those positions; there are not enough Immigration visas (especially in the
						Trumpian era of isolationism) to make up the rest. </p>
	
	
	
					  <p>
	
	
	
					  </p>
	
	
	
					  <p>So, how is it that only 14% of females in the entire field of cybersecurity? Silicon Valley is, at its
						best, obscenely one-sided. At Google, only 17% of the company's tech jobs are filled by women. Facebook
						women staff only 15% of tech jobs, and Twitter? 10% female. The figures on women in computer science
						across the nation, across the entire industry are not improving, but
						<i>declining</i>?
						<sup>1</sup>
	
	
	
					  </p>
	
	
	
					  <p>Of course, we've heard these statistics from any given headline, and in the halls across the university
						landscape, starting with Women in STEM (Science, Tech, Engineering, Mathematics) programs.
						<sup>3</sup> Yet, why, with so much money, so many programs, so many non-governmental, non-profit effort?
	
	
	
					  </p>
	
	
	
					  <p>I argue that tech
						<i>climate
						  <sup id="24-3"></sup>
						</i> is directly to blame. Who then? Not a person, but principles are to blame. Culture--often defined as
						shared beliefs, norms, language and behaviors--can hardly be changed, but it can be understood.
	
	
	
						<br />There is a book, called "Program or be Programmed
						<sup id="24-4">4</sup>
					  </p>, by which the author explains social consequences of a dichotomized society--between those that manipulate
					  the environment around them, whether automating tasks at work, or simply fixing a simple software bug,
					  by adding a comma. This literacy of the Current Era is akin to the 26-letter alphabet of written sentences
					  and paragraphs, and--not to be taken for granted--is the exclusive form of communication, outside of a
					  100-foot perimeter, up until 150 years ago. Knowledge is not power, the communication of knowledge is power.</p>
	
	
	
					  <p>I argue that today, the power is to program one application programming interface (API) to talk to another
						API. In other words, the ability to directly communicate with software at the command-line is not now
						a requisite skill, but promotions would not escape this necessity! So, now reverting back to the subject
						of women in tech, American leadership is in deep peril without more female insight. I will finish by
						citing that Ares, the violent, untamed Greek
						<i>god of war</i>, cannot always drive the Capitalist engine; because She, Athena, the
						<i>goddess of intelligence</i> represents true strategy!
	
	
	
						<p>
	
	
	
						  1.
						  <a href="https://www.huffingtonpost.com/2015/03/27/women-in-tech_n_6955940.html" target="_blank">https://www.huffingtonpost.com/2015/03/27/women-in-tech_n_6955940.html</a>
						</p>
	
	
	
						<p>
	
	
	
						  2.
						  <a href="https://fairygodboss.com/articles/women-in-tech-facts-figures-and-percentages" target="_blank">https://fairygodboss.com/articles/women-in-tech-facts-figures-and-percentages</a>
						</p>
	
	
	
						<p>
	
	
	
						  3.
						  <a href="https://www.aauw.org/research/why-so-few/" target="_blank">https://www.aauw.org/research/why-so-few/</a>
	
	
	
						</p>
	
	
	
					</div>
	
	
	
					<div id="feb-18-02-24">
	
	
	
					  <h5 class="title dailytech">OUR DAILY TECH</h5>
	
	
	
					  <h5 class="subdailytech">Web Dev Affairs</h5>
	
	
	
	
	
	
	
					  <p class="author">by Thomas Maestas, MA</p>
	
	
	
	
	
	
	
					  <h6 class="chapternumber">
	
	
	
	
	
	
	
						Feb 24-25, 2018
						<br /> Weekend
	
	
	
					  </h6>
	
	
	
	
	
	
	
					  <h6 class="chapternumber dailytitle">Joys of Automation</h6>
	
	
	
	
	
	
	
					  <p class="firstparagraph">
	
	
	
	
	
	
	
						While coding up a better shell for this website, I thought it's remarkable how our lives get easier and easier with each
						passing year of tech. Using JavaScript--the primordial web-coding language--I marvel at the convenience
						of delegating mundande coding stuff to taskrunners, like
						<i>Gulp</i>--a programmable package manager that "bundles" up the libraries to be used in the app. It is
						truly a joy! </p>
	
	
	
					  <p>I write four styling
						<i>functions</i>, with about 16
						<i>variables</i> and voil&agrave;! I finish in 3 hours what would have taken me 15 hours, then another 5
						hours a month for upkeep. Instead, now, it's as though I wind up the clock, and need only periodically
						check, and perhaps update a variable or two ... Technology. I'm gushing for joy.</p>
	
	
	
					  <p> This was mere JavaScript--with a truly
						<i>Turing Complete</i>--pan-algorithm status--languages, the possibilities are 100-fold with Python language
						library collection; this library collection includes NASA modules, mathematical proofs, and limitless
						uses from web-scraping for unstructured data to an excellent data visualization collection. Sometimes
						I feel like I'm in the Library of Congress, and better yet because, PIP, the Python package manager acts
						and automates like a cyborg librarian, for lack of better imagery. </p>
	
	
	
					  <p>I just have so much joy watching a project come to life, and it's even a greater delight if this project
						comes to life and stays alive, through the joys of automation!
	
	
	
					  </p>
	
	
	
					  </p>
	
	
	
					</div>
	
	
	
					<div id="feb-18-02-26">
	
	
	
					  <h5 class="title dailytech">OUR DAILY TECH</h5>
	
	
	
					  <h5 class="subdailytech">Musing Blockchain</h5>
	
	
	
	
	
	
	
					  <p class="author">by Thomas Maestas, MA</p>
	
	
	
	
	
	
	
					  <h6 class="chapternumber">
	
	
	
	
	
	
	
						Feb 26, 2018
	
	
	
					  </h6>
	
	
	
	
	
	
	
					  <h6 class="chapternumber dailytitle">Cryptocurrency's Cumbersome Carbon Footprint </h6>
	
	
	
	
	
	
	
					  <p class="firstparagraph">
	
	
	
	
	
	
	
						I must confess that on the very day that Our Daily Tech Blog gets an under-the-head make-over for security's sake, I wrote
						the new formatting file right over today's post. Amazing, and the two occurred nearly simultaneously
						as I worked on them, their paths crossed and poof, gone! Same platform, and I paid the price! Whether
						I change my ways is yet to be seen, but I shall continue with my original theme for the day, namely,
						Sustainability, a.k.a. Carbon Footprint.</p>
	
					  <p class="quote">Power consumption is one of the major costs of bitcoin mining, as dedicated machines crunch the algorithms
						that build a record of every single bitcoin transaction and are rewarded with tiny fractions of a bitcoin
						for their efforts.
						<sup id="explain">1</sup>
	
					  </p>
	
					  <p> Today I have a mild Critique and Praise for the blockchain sustainability problem caused by sky-high electricity
						bills! Computer algorithms do waste electricity, not like your Widescreen. More electricity is gobbled
						up by small and large mining operations in nearly every country than small nations!
						<sup id="electricity">1</sup>. Ethereum, Bitcoin and a handful of other "Proof-of-Work" designs require electricity because
						the investment in equipment itself is investment, but more importantly, two-way incentivation for mining
						drives the system, and the scarcity demand through difficulty computations. </p>
	
	
	
					  <p>So, is the electricity consumption really
						<i>correlated</i> with the value, scarcity, of the currency? Yes. Digiconomist--a cryptocurrency analysis
						site
						<sup id="digiconomist">3</sup> estimates
						<i>each</i>Ethereum transaction represents a 45 Kilowatt-hour of electricity's mining. (A visa credit card
						transaction is 0.00651 kWh. The entire Ethereum global blockchain could be "using as much as 4.2 Terawatt-hours
						(tWh), or slightly more than the country of Cyprus
						<sup id="cyprus">1</sup>." So, electricity comparisons are telling, but how does this relate to its environment impact,
						sustainability itself?</p>
	
					  <p>Carbon Footprint, our energy consumption index, can be compared to another element of scarcity, which dictates
						fluctuations in value: Gold. According to
						<i>Digiconomist</i>, an average household's Carbon Footprint is about 10 tons of CO2 per year. The article
						does the math for us very succinctly: </p>
	
					  <p class="quote">On top of this, we can find that the process of mining Bitcoin isn’t just more energy-intensive, but also
						has a bigger environmental impact. To reach that conclusion, we first need to estimate the carbon footprint
						for both. For Bitcoin we can, again, get this number from the Bitcoin Energy Consumption Index. For gold,
						we assume a carbon footprint of 20 tons of CO2e per every kilogram of gold mined
						<sup id="digiconomist2">3</sup>.
	
					  </p>
	
					  <p>The article continues to clarify that 33,000 kilograms of CO2 per unit mines (comparatively, one Bitcoin's
						worth of Gold is 4,000 kilograms of CO2). At the end of the day, the electricity costs--if not sustainable
						long-term--could spell trouble. Hence, the three S's, mentioned last, sustainability is perhaps a larger
						issue than blockchain Security and Scalability challenges. Again, this is a problem that the third largest
						cryptocurrency does not have:
						<i>Ripple</i>, which does not bear a carbon footprint
						<sup id="ripple">4</sup>.
	
					  </p>
	
					  <p></p>
	
					  <p>
	
						0.
						<a href="https://www.cnet.com/how-to/bitcoin-ethereum-or-litecoin-which-cryptocurrency-is-best-for-you/" target="_blank">https://www.cnet.com/how-to/bitcoin-ethereum-or-litecoin-which-cryptocurrency-is-best-for-you/</a>
						<br />For those new to cryptocurrencies, this is a fairly succinct article to cryptocurrencies, and their underlying
						structure.
	
					  </p>
					  <p>
	
	
	
						1.
						<a href="https://motherboard.vice.com/en_us/article/d3zn9a/ethereum-mining-transaction-electricity-consumption-bitcoin" target="_blank">https://motherboard.vice.com/en_us/article/d3zn9a/ethereum-mining-transaction-electricity-consumption-bitcoin</a>
	
					  </p>
					  <p>
	
						2.
						<a href="http://www.wired.co.uk/article/how-much-energy-does-bitcoin-mining-really-use" target="_blank">http://www.wired.co.uk/article/how-much-energy-does-bitcoin-mining-really-use</a>
	
					  </p>
					  <p>
	
						3.
						<a href="https://digiconomist.net/bitcoin-mining-more-polluting-than-gold-mining" target="_blank">https://digiconomist.net/bitcoin-mining-more-polluting-than-gold-mining</a>
	
					  </p>
					  <p>
	
						4.
						<a href="https://ripple.com/xrp/" target="_blank">https://ripple.com/xrp/</a>
	
					  </p>
					  <p>
	
					</div>
	
					<div id="feb-18-02-27">
	
					  <h5 class="title dailytech">OUR DAILY TECH</h5>
	
					  <h5 class="subdailytech">Web Dev Affairs</h5>
	
	
	
					  <p class="author">by Thomas Maestas, MA</p>
	
	
	
					  <h6 class="chapternumber">
	
	
	
						Feb 27, 2018</h6>
	
	
	
					  <h6 class="chapternumber dailytitle">After Yesterday's Scathing Post, A Look at my own Carbon Footprint </h6>
	
	
	
					  <p class="firstparagraph">In my reflections about environment sustainability issues, I confess I'm sort of a hypocrite ... The whole
						matter that caused my own introspection begins with my usual daily vexation: Tangles of wires!
						<br /> &nbsp; ... I've been having electricity issues, here as of late ...</p>
	
					  <p>
	
						On one side, my tiny Yoga Ultrabook usually likes to charge just fine with my phone charger--if I'm stuck without my charger.
						And due to an untimely end to the charger, I needed a replacement. So, singular errand of the day was
						a trip to Best Buy to peruse for a 45-Watt USB-C charger ( the new oval charging port on Samsung 8's,
						LG G6's and newer Apple products).
						<p>Meanwhile, my credit-card sized Raspberry Pi computer runs on an old-school USB charger--a whole Linux
						  Server Tower on a cell-phone charger. Then, we have my trusty Dell (actual) Tower with 16 Gigs of RAM,
						  2-terabytes, etc. that also seems to need an extra fan to stay cool--probably the sustainability of
						  100 Raspberry computers. My entire carbon footprint changes more with the electrical products that
						  I use, than my vehicle! Well, I also confess my Jeep Cherokee can't even boast 20 miles per hour ...
						  oops, conscience pangs, ouch ... Well, hypocritical, slightly, but found not guilty since I'm a bike-commuter
						  for life!</p>
	
						<p>
	
						</p>
	
					</div>
					<div id="feb-18-02-28">
	
					  <h5 class="title dailytech">OUR DAILY TECH</h5>
	
					  <h5 class="subdailytech">Musing Blockchain</h5>
	
	
	
					  <p class="author">by Thomas Maestas, MA</p>
	
	
	
					  <h6 class="chapternumber">
	
	
	
						Feb 28, 2018</h6>
	
	
	
					  <h6 class="chapternumber dailytitle">One Last Word about Bitcoin's Carbon Footprint </h6>
	
	
	
					  <p class="firstparagraph">Environmental Sustainability, again, and a higher-level view of the dilemmea...I couldn't resist:
						<br /> Bitcoin's Initial Coin Offering was 2011 or so, then Ethereum, with Ether for currency was 2015; These
						two, ever so prescient designs, also have their Achilles Heal. These two are
						<strong>"Proof of Work" currency algorithsms</strong>. This means that the "Demand" side of supply-and-demand,
						derives from
						<i>difficulty levels</i> of crypto-blocks to mine. So, miners are incentivized to spend $1500 on a semi-mediocre-good
						mining rig (which is basically 20 NVIDIA Graphics Cards tied together to stack of two-by-fours with lots
						of fans ... erhem, sustainability?...</p>
					  <p>And for each block that is "solved", hence the block being validated, and somebody's cryptocurrency purchase/transaction
						is resolved! (takes about 12 minutes for the whole global blockchain to cycle, and Ethereum is less than
						a minute). So, the whole cycle continues, churning through coal- and carbon-stained hands of the electricity
						fed to these crypto-mining rigs
						<sup>1</sup>. For many it's a hobby, like the British Hobbyists' love for ham- and short-wave radio setups,
						yet this profitable, yet particular hobby resembles the 1870's coal factory smoke stacks in South London!
					  </p>
	
					  <p>
						Let's face it, if Ethereum is able to successfully hard-fork to a Proof-of-Stake system soon--and Vitalik Buterin and his
						crew assure us it is coming
						<sup>2</sup>--then great--problem solved, everything eventually converts to Ethereum. If
						<i>not</i>they face an existential threat. Because, in a more enlightened ten years from now, those mining
						depots
						<i>would</i> look like unfettered factory smoke-stacks. Proof-of-Stack, whose currency value is not set
						to difficult of algorithm puzzle (hence,
						<i>proof-of-work</i>, but rather to ownership of "voting pools", which is a
						<i>
						  <strong>Consensus-Based Blockchain algorithm</strong>
						</i> [Complex subject best reserved for a rainy day, or better yet, no day! I may revisit this alternative
						in a funner way, here's a glimpse from Vitalk's @VitalikButerin tweet yesterday:</p>
					  <p class="quote">Question for mathematicians: is there a assumed-to-be-normal number (ie. digits are random, like pi or
						e) where you can calculate the nth digit in log(n) (or even polylog(n)) time? If so, then H(x) = digits[x
						... x+100] seems like it would be a cool cryptographic hash algo.</p>
					  <p>Now, I am by no means a detective, but by the sound of those tweets, the Proof-of-Work algorithm seems
						to still be of utmost importance ... </p>
					  <p>
						1.
						<a href="https://blockexplorer.com/news/ethereum-launches-casper-testnet-paving-way-proof-stake/" target="_blank">https://blockexplorer.com/news/ethereum-launches-casper-testnet-paving-way-proof-stake/</a>
						and also,
						<a href="https://www.trustnodes.com/2017/11/28/ethereums-proof-stake-casper-testnet-nears-launch" target="_blank">https://www.trustnodes.com/2017/11/28/ethereums-proof-stake-casper-testnet-nears-launch</a>
					  </p>
					</div>
	
	
		 
		<button id="afebend" >
		<a href="#afebtop">PAGE TOP</a>
	  </button>     
	   <p> &copy; 2018 All Rights Reserved. &nbsp; |
	
	  <a style="color:yellow;text-decoration:none;" href="http://www.thomasmaestas.net">thomasmaestas.net &nbsp; |</a>
	  <a style="color:yellow;text-decoration:none;" href="mailto:thomas@ourdailytech.com"> thomas@ourdailytech.com &nbsp; |</a>
	
	
	  <a title="Contact Information: thomasmaestas.net" href="http://www.thomasmaestas.net/profile.html#contactme"> Contact Information</a>
	</p>  
	`;
	
	  } else { 
		secretParagraphMPB.style.display = 'none'; 
	  } 
	}
	 
	function updateSecretParagraphMAR() {
	
	  if (showSecretMAR) {
	
		secretParagraphMAR.style.display = 'block';
		secretParagraphMAR.style.fontFamily = 'Roboto';
		secretParagraphMAR.style.opacity = '1';
		secretParagraphMAR.style.color = 'darkslategray';
		secretParagraphMAR.innerHTML = `   
		  <div id="mar-18-03-24" class="     mar 18-03 -24">
		  <hr />
		  <button>
		  <a href="#martop">Top</a>
		  </button>&nbsp;
		  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>
		  
		  <h5 class="  subdailytech">Sociology Tomorrow!</h5>
		  
		  <p class="  author">by Thomas Maestas, MA</p>
		  
		  <h6 class="  chapternumber">March 24-25, 2018<br />
		  Weekend </h6>
		  
		  <h6 class="dailytitle chapternumber">1968 Meets 2018: Scalability Issues in the Mean Time
		  </h6>
		  <p class="firstparagraph">Washington D.C.  
		  Not Normally does WonderWoman Show her Face, but the student protest takes the day on gun control. Emma Gonzalez--one of the Parkland School Shooting survivors, addressed, and marched with, hundreds of thousands of middle- and high-schoolers, took to the streets of D.C. to protest lax gun-control, e.g. AK-47's readily available at a moment's notice ... for home protection? I wouldn't want to be a neighbor for fear of collateral damage! So technology keeps one-upping the ol' six-shooter to something easily labeled as <i> a Weapon of Mass Destruction</i> ... so is it still a gun?
		  </p>
		  <p >Last week and this week, the out-of-control handgun problem is in the news. This leads one to believe there is the root problem with the <i>definition</i> of a gun. As always. Definitions start wars and world wars--after all of last century, did anyone decide who controls the Coal of Sudetenland?  You can bet everyone there speaks two languages, still. The <i>definitional </i> answer makes the answer: But this is a problem in the tech age because definitions change, <i>scale of effect changes</i>, and this makes the definition impossible to pin down. The definition is as relative as the technological change makes it.  
		  
		  </p>
		  <p class="cite"><a href="http://www.latimes.com/local/california/la-me-saturday-walkouts-liveupdates-emma-gonzalez-leads-remarkable-moment-of-1521916931-htmlstory.html">http://www.latimes.com/local/california/la-me-saturday-walkouts-liveupdates-emma-gonzalez-leads-remarkable-moment-of-1521916931-htmlstory.html</a> </p>
		  </div> 
	
		  
		  <div id="mar-18-03-23" class="    mar 18-03 -23">
		  <hr />
		  <button>
		  <a href="#martop">Top</a>
		  </button>&nbsp;
		  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>
		  
		  <h5 class="  subdailytech">Musing Blockchain</h5>
		  
		  <p class="  author">by Thomas Maestas, MA</p>
		  
		  <h6 class="  chapternumber">March 23, 2018 </h6>
		  
		  <h6 class="dailytitle chapternumber"><i>It's not about the Blockchain, the Efficient Network Data Distribution is the Answer!</i>
		  </h6>
	  
		  <p class="firstparagraph">The problem is that data structures grow at differential rates, some exponential, some linear, some slower, some as a function of time or other variable.  Yet, our data analysis needs are clear: We need a new technology to handle quickly, securely and efficiently the <i>Networked, Relational Data Problem</i>, which scales exponentially with traditional data structures, like old-fashioned Excel-like Row-&amp;-Column data structures. Yet, as one would logarithmize the equation to best adapt new data, so must the computer data structure adjust accordingly. </p>
		  <p>Too rigid, the world turned to relational, non-Structured Query Language (SQL) data, partially for the need to dislate <i>data objects</i> from their tables. The world needed that cell as a free-radical in order to mimic the data structure of societally-networked society.  Alas, a science already at hard work with Cambridge Analytica--again what's that field of study called again, Sociology, right? </p>
		  <p>
		  
		  </p></div> 
		  <div id="mar-18-03-22" class="   S mar 18-03 -22">
		  <hr />
		  <button>
		  <a href="#martop">Top</a>
		  </button>&nbsp;
		  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>
		  
		  <h5 class="  subdailytech">Web Dev Affairs </h5>
		  
		  <p class="  author">by Thomas Maestas, MA</p>
		  
		  <h6 class="  chapternumber">March 22, 2018 </h6>
		  
		  <h6 class="dailytitle chapternumber">A.I. Part II: Problems with Scale, Kindly Resolved by A.I.
		  </h6>
		  <p class="firstparagraph">I mistakenly laid waste to A.I.'s reputation in my last post. It <i>did</i> let us, our whole society, let us down, and maybe the forensics will give us <i>a few excuses</i> down on the road. However, "homicide by A.I. (aka Uber)" will need to be updated in records. But, artificial intelligence is not at fault. There are a few software engineers that did the best they could--with the time their superiors gave them.  Uber leadership, let's hope, will be deterred from future carelessnes to come.   </p>
		  
		  <p>That diatribe said, I do appreciate an Uber's proximity when I'm stranded at 2:00 am in a bad part of town. Why? Because I don't need to plan ahead -- Uber is there! And, sadly, I don't need to read or study -- Google is there! But wait, don't judge me, I'm not lazy! That being said, I have my own soul-searching to do: TECHNOLOGY AIDS AND ABETS ME AND MY ACTIONS, but it does not run my show> Only I take responsibility for my own actions: I allow technology into my life as a tool, and yet I   hold the power cord. I take responsibility for the tech that follows me--and believe me, I need that tech. And so do you. Not only so, but the world, and the ecological fate of our <i style="color:green">green earth</i>> also depends on tech, A.I. specifically. </p>
		  <p>
		  Humankind has already dug an ecological (dare I say 'alkaline') pit deeper than can be dug out of: Flooding, forest fires, and Species Extinctions. A.I. is <i style="color:brown"> is </i>> the only viable hope so we, i.e. Uber, shouldn't prematurely spoil its development. 
		  </p>
		  <p class="quote">Several questions raise their ugly head when A.I. can't help Earth or humankind. Like it or not, A.I. will need to 3-D print the dykes for the sunken coastal cities--like tiny island Den Haague, the most beautiful city in the world. Next, A.I. will make irrelevant fossil fuels by 2030, if not before; and those caught polluting would be fined to death, anyway. Without A.I., none of these worthwhile goals are possible. This precarious, difficult and most of all laborious job of designing our own solutions will take time: For this reason, Uber should be shamed even further for their short-cuts, and eventual errors of internal, organizational problems. <i>Uber's experiemental, tax-free "Testing Sandbox" cannot be the erstwhile safe neighborhoods of Surburban Phoenix, without proper caution.</i> </p>		
		  <p>Are Uber's corporate desires, market stronghold, and shareholders' delight more worthwhile than <i>an entire sensitive field of machine-learning research?</i> No. Uber must be warned to not steal corporate secrets from Waymo, then proceed to be 86'd from California, then brush aside with excuses the <i>killing of an innocent Arizona bicyclist</i>.</p>
		  <p>
		  Who can count the number of very feisty taxi-men and -women that are not fans of the infamously hasty culture of Uber. The team of lawyers needed to be 86'd from France? Uber already knows, because maybe they know B.D.O! 
		  </p>
		  <p></p>
		  <p class="cite">3.
		  <a href="https://www.theguardian.com/technology/2017/apr/07/uber-waymo-lawsuit-lidar" target="_blank">https://www.theguardian.com/technology/2017/apr/07/uber-waymo-lawsuit-lidar</a>
		  </p>
		  </div> 
		  <div id="mar-18-03-21" class="    mar 18-03 -21  ">
		  <hr />
		  <button>
		  <a href="#top">Top</a>
		  </button>&nbsp;
		  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>
		  
		  <h5 class="  subdailytech">Web Dev Affairs </h5>
		  
		  <p class="  author">by Thomas Maestas, MA</p>
		  
		  <h6 class="  chapternumber">March 21, 2018 </h6>
		  
		  <h6 class="dailytitle chapternumber">Hey Uber Driver, Please Slow Down!
		  </h6>
		  <p class="firstparagraph">A.I. generally, and specifically Uber's Self-Driving Tech, both have failed society this week. Although we could all debate the merits of "Lidar", i.e. laser-based vision, the primary concern, in my view, is Uber's obvious carelessness in rushing their self-driving tech.  Although six thousand (6,000 too many) pedestrians are killed in the U.S. annually, I'd only hope AI wouldn't add to the problem.<sup>2</sup> The Arizona victim was walking her bicycle when struck, and I as bike-commuter can't help but take the affair personally. </p>
		  <p>This first human death is at least a <strong>big Wake-Up moment</strong> for the industry in its haste to roll out A.I. tech.  After all, Uber's questionable leadership morals<sup>2</sup> and being kicked out of San Francisco for running more than six red-lights raises eyebrows to begin with.<sup>3</sup> My problem with Uber is that the car's algorithm, with perfect Lidar vision, did not flinch or slow down for two seconds as it killed the victim. Humans flinch and humans swerve, because protecting fellow humans is in our DNA, not in A.I.'s. So, while we now know Uber's software hasn't caught up with its A.I.-Lidar hardware--let's hope we see defensive driving and some <i>TLC</i> programmed into those A.I. Algorithms!
		  </p>
		  <p class="cite">1.
		  <a href="https://www.theguardian.com/technology/2018/mar/22/video-released-of-uber-self-driving-crash-that-killed-woman-in-arizona" target="_blank">https://www.theguardian.com/technology/2018/mar/22/video-released-of-uber-self-driving-crash-that-killed-woman-in-arizona</a>
		  </p>
		  
		  <p class="cite">2.
		  <a href="https://www.theguardian.com/technology/2017/apr/07/uber-waymo-lawsuit-lidar" target="_blank">https://www.theguardian.com/technology/2017/apr/07/uber-waymo-lawsuit-lidar</a>
		  </p>
		  <p class="cite">3.
		  <a href="http://fortune.com/2017/02/26/uber-self-driving-car-red-lights/" target="_blank">http://fortune.com/2017/02/26/uber-self-driving-car-red-lights/</a>
		  </p>
		  
		  </div>
		  <div id="mar-18-03-20" class="  mar 18-03 -20">
		  <hr />
		  <button>
		  <a href="#martop">Top</a>
		  </button>&nbsp;
		  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>
		  
		  <h5 class="  subdailytech">Web Dev Affairs </h5>
		  
		  <p class="  author">by Thomas Maestas, MA</p>
		  
		  <h6 class="  chapternumber">March 20, 2018 </h6>
		  
		  <h6 class="dailytitle chapternumber">The Facebook Fiasco: Why Zuckerberg Should not have Dropped out of Harvard
		  </h6>
		  <p class="firstparagraph">
		  Universities, private or public institutions, serve as a beacon for
		  <strong>the Fearless Protection and Ethical Regulation</strong> of information and data. This is because data and data research
		  is innate to the university's Mission Statement, whereas business and governmental institutions are relatively new
		  to the game, and often at odds with the
		  <i>Academy</i>, and occasionally against each other. </p>
		  <p class="quote">Threats to student data privacy existed long before the internet. The FBI under J. Edgar Hoover infiltrated Berkeley
		  student groups to counter communism in the 1960s. Around the same time, the CIA manipulated the National Student
		  Association for intelligence gathering in other anti-communism efforts. But the privacy issue is more acute now
		  that the amount of student data in cloud-based systems has grown exponentially and is more widely dispersed.
		  <sup>2</sup>
		  </p>
		  <p> The University's expertise over ethically regulated data collection and management, is better than government, business,
		  and even medical domains for two reasons. First, the institution's long history and ethical motives with data are
		  unique. The norms of data-handling have been codified through the University's Institutional Review Board based
		  on its
		  <strong>stated mission</strong>. In other words, Universities take data seriously
		  <i>for reasons other than corporate profit or governmental control</i>. An example of personal data precautions has
		  played out with Harvard's recent data tiffs leading to the Supreme Court, illustrated by a 2016 article: </p>
		  <p class="quote">Last week undergraduates at Harvard University raised concerns about the institution handing over their data to an
		  anti-affirmative action group as part of a lawsuit. Students for Fair Admissions, which is suing the university
		  for allegedly discriminating against Asian American applicants, will have access to “academic, extracurricular,
		  demographic and other information” from all undergrads who applied to Harvard between the fall 2009 and spring 2015,
		  omitting names and Social Security numbers.
		  <sup>2</sup>
		  </p>
		  <p>The second reason why Universities understand ethical implications for data is that data and more broadly data and
		  human information
		  <i>research</i> is the institutions' second highest priority, along with teaching and service. For example, in response
		  to the unethical Public Health research in
		  <i>Tuskegee Syphilis experiements</i>, the University instution
		  <i>stepped in</i> to help design the 1978
		  <strong>Belmont Principles</strong>. Currently, the University Institutional Review Board incorporates this with the Nuremburg
		  Code (developed after WWII NAZI research), in handling data research.
		  </p>
		  <p>In recent days,
		  <i>private companies</i> claim expertise for regulating "Fake News", and you guessed it,
		  <strong>regulation of data privacy &amp; confidentiality.</strong><sup>3</sup> The ethical authority over data privacy norms are nowhere
		  else than the University campus, case in point Harvard... Let the governments govern and the enterprises enterprise,
		  and leave the
		  <i>thoughtful, ethical regulation of data collection and precaution </i> to the Ivory Tower. Corporate and Government
		  self-regulation is opaque enough!</p>
		  
		  
		  <p class="cite">1.
		  <a href="https://www.theguardian.com/technology/2018/mar/21/mark-zuckerberg-response-facebook-cambridge-analytica"
			target="_blank">https://www.theguardian.com/technology/2018/mar/21/mark-zuckerberg-response-facebook-cambridge-analytica</a>
		  </p>
		  <p class="cite">2.
		  <a href="https://www.edsurge.com/news/2016-10-26-pursuing-academic-freedom-and-data-privacy-is-a-balancing-act"
			target="_blank">https://www.edsurge.com/news/2016-10-26-pursuing-academic-freedom-and-data-privacy-is-a-balancing-act</a>
		  </p>
		  <p class="cite">3.
		  <a href="https://www.bloomberg.com/news/articles/2018-03-21/paul-ford-facebook-is-why-we-need-a-digital-protection-agency"
		  target="_blank">https://www.bloomberg.com/news/articles/2018-03-21/paul-ford-facebook-is-why-we-need-a-digital-protection-agency</a>
		  </p>
		  
		  </div>
		  
		  <div id="mar-18-03-19" class="  mar 18-03 -19">
		  
		  <hr />
		  <button>
		  <a href="#martop">Top</a>
		  </button>&nbsp;
		  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>
		  
		  <h5 class="  subdailytech">Sociology Tomorrow!</h5>
		  
		  <p class="  author">by Thomas Maestas, MA</p>
		  
		  <h6 class="  chapternumber">March 19, 2018</h6>
		  
		  <h6 class="dailytitle chapternumber">A New Politics of Power:
		  <br /> The Cryptographic Financial Escape Hatch
		  </h6>
		  <p>I had originally intended for a post on the very lamentable
		  <i>Blockbuster-ization</i> and eventual demise of Toys-"R"-Us, but Tech Affairs happen too quickly! Instead ...</p>
		  <p class="firstparagraph">Today, US inserted itself into a large, deep debate about crypto-legitimacy by imposing new sanctions on Venezuela.
		  In case you hadn't heard, here's a quick recap:</p>
		  <p class="quote">The administration’s announcement came a few hours after Mr. Trump signed an executive order barring the use of any
		  digital currency issued by the Maduro government since Jan. 9. Mr. Maduro announced last month that his country
		  had begun a presale of the Petro, backed by the nation’s vast petroleum reserves.
		  <br />
		  <br />The Venezuelan government called the launch a response to a financial crisis that has prompted a profound devaluation
		  of the national currency, the bolívar, and quadruple-digit inflation.
		  <sup>1</sup>
		  </p>
		  <p>
		  This turn of events, both Maduro et al.'s financial cleverness and Trump's action to de-legitimate the Petro crypto-currency,
		  are examples of the undefined, near-limitless political uses for Blockchain Tech, both offensively and defensively.
		  In fact, the ensuing events may be of great interest as we will witness a major first actual use-case of the decentralizing
		  aims of crypto-technology tool. A tool that softens the financial leverage wielded by centralized authorities, whether
		  governmental or private.
		  </p>
		  <p>I used the term "de-legitimate" above because there are two processes at work: First, crypto-currencies are
		  <i>in themselves</i> not legitimate. A
		  <strong>crypto-currency platform gains legitimacy through a series of both technical and financial trust-building stages</strong>.
		  So legitimacy is earned first privately, and some currency platforms continue publicly to Initial Coin Offering,
		  and so on--purely financial and technical legitimacy.
		  </p>
		  <p>And then, there is the another kind of legitimacy, which involves political leverage ... </p>
		  <p class="cite">1.
		  <a href="https://www.nytimes.com/2018/03/19/world/americas/trump-venezuela-sanctions-petro.html" target="_blank">https://www.nytimes.com/2018/03/19/world/americas/trump-venezuela-sanctions-petro.html</a>
		  </p>
		  
		  </div>
		  
		  <div id="mar-18-03-17" class="  mar 18-03 -17">
		  
		  <hr />
		  <button>
		  <a href="#martop">Top</a>
		  </button>&nbsp;
		  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>
		  
		  <h5 class="  subdailytech">Musing Blockchain</h5>
		  
		  <p class="  author">by Thomas Maestas, MA</p>
		  
		  <h6 class="  chapternumber">March 17-18 2018
		  <br /> Weekend
		  </h6>
		  
		  <h6 class="dailytitle chapternumber"> Energy Alternatives Signal the Power Shift to Come, Part II: A Ripple and an Iota of Sustainable Crypto-Currency
		  </h6>
		  <p class="firstparagraph">Iota and Ripple cryptocurrencies use different technology than traditional blockchain in order to achieve their distributed
		  ledgers. Traditionally, outside "miners" validate the block's
		  <i> transaction records</i> as it replicates to the next "block." For example, a transaction is validated 2 or three
		  times, and since three miners' validations all agree, one is kept and two are destroyed, in a nutshell; one example
		  of computations (
		  <strong>and hence coal</strong>) that cost too much time and energy.</p>
		  <p>Unlike this arrangement, Iota, Ripple, and Hedera use a directed-acyclic-graph (DAG) data structure (shaped like
		  a sideways genealogy tree) that relies on "consensus" from its nearest neighbor transaction nodes.
		  <sup>1</sup>
		  </p>
		  <p>Enough with the jargon! The bottom line is that Bitcoin's tech is not eco-sustainable,
		  <sup>2</sup> and so alternatives are already closing in on Bitcoin. Iota, the 8th largest cryptocurrency Iota delivers
		  open-source transparency, lightning speed, and yet is it cryptographically sound? Not according to some tech pundits:
		  </p>
		  <p class="quote">You might think that IOTA, a cryptocurrency worth over a billion dollars, and working with organizations like Microsoft,
		  University College London, Innogy, and Bosch, BNY Mellon, Cisco, and Foxconn (through the Trusted IOT Alliance)
		  would not have fairly obvious vulnerabilities, but unfortunately, that’s not the case. When we took a look at their
		  system, we found a serious vulnerability and textbook insecure code.
		  <br />
		  <br /> “In 2017, leaving your crypto algorithm vulnerable to differential cryptanalysis is a rookie mistake. It says that
		  no one of any calibre analyzed their system, and that the odds that their fix makes the system secure is low,” states
		  Bruce Schneier, renowned security technologist, about IOTA when we shared our attack.
		  <sup>3</sup>
		  </p>
		  <p>And so, with a 1.9 billion market cap, I sometimes have to reflect on the immensity and non-relational fact and figures
		  of our technological world! Security and other bugs are hard to avoid when an industry is moving too fast for thoroughly
		  tested betas; and each iteration involves a series of bug-patches, with short- and long-term priorities stretched
		  with new design &amp; function trade-offs.</p>
		  <p>
		  Full life-cycle software development, from napkin-idea to rolling specs, always follows these patterns yet not always with
		  so much money on the line! Here's a closer look at one critique of Iota:</p>
		  <p class="quote">
		  IOTA developers had written their own hash function, it was a huge red flag ... I think it’s important to reiterate that
		  the IOTA developers do not agree with our characterization of this as an issue of concern. Our report lays out more
		  details about why we are concerned.
		  <br />
		  <br /> There are other red flags — unlike every other program running on your laptop or phone, IOTA uses ternary instead
		  of binary. Since all computer hardware today uses binary, IOTA converts to ternary in software, which is less efficient
		  and more complex. This complexity prevents IOTA from benefiting from existing security analysis tools that are designed
		  to work with binary, and makes the code harder to read and understand.
		  <br />
		  <br /> The current IOTA tangle requires a trusted party (the coordinator) for security, suggesting that in its current
		  form it’s not ready to run as a truly permissionless, decentralized system.
		  <sup>3</sup>
		  </p><p>
		  Optimizing, not sacrificing, should be the name of the game as Tech closes in on Blockchain challenges of security, scalability,
		  and that evers-so-costly
		  <strong>Sustainability!</strong>
		  </p>
		  <p>1.
		  <a href="https://www.bloomberg.com/news/articles/2018-02-14/next-generation-crypto-ledgers-take-the-block-out-of-blockchain"
			target="_blank">https://www.bloomberg.com/news/articles/2018-02-14/next-generation-crypto-ledgers-take-the-block-out-of-blockchain</a>
		  </p>
		  <p>2.
		  <a href="
		  https://digiconomist.net/bitcoin-electricity-consumption-surpasses-singapore-portugal
		  " target="_blank"> https://digiconomist.net/bitcoin-electricity-consumption-surpasses-singapore-portugal </a>
		  </p>
		  <p>3.
		  <a href="
		  https://medium.com/@neha/cryptographic-vulnerabilities-in-iota-9a6a9ddc4367
		  " target="_blank"> https://medium.com/@neha/cryptographic-vulnerabilities-in-iota-9a6a9ddc4367</a>
		  </p>
		  
		  
		  </div>
		  
		  <div id="mar-18-03-16" class="  mar 18-03 -17">
		  
		  <hr />
		  <button>
		  <a href="#martop">Top</a>
		  </button>&nbsp;
		  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>
		  
		  <h5 class="  subdailytech">Musing Blockchain</h5>
		  
		  <p class="  author">by Thomas Maestas, MA</p>
		  
		  <h6 class="  chapternumber">March 16, 2018</h6>
		  
		  <h6 class="dailytitle chapternumber"> Energy Alternatives Signal the Power Shift to Come
		  </h6>
		  
		  <p class="firstparagraph">Sustainability for the environment means an accelerated transition to renewables. While other nations have undertaken
		  big steps toward wind and solar - even China's pollution declined in 2014 for the first time
		  <sup>1</sup>. EU is now 30% renewable--from 12% in 2000 to expected 50% renewable energy by 2030
		  <sup>2</sup>. Us, it appears, not so much...ouch.</p>
		  <p>What can we do then, in our lives, to make our own contribution. Well, besides less fossil fuels and red meat, we
		  can choose our cryptocurrencies more conscientiously. One NY town's recent actions echo my own concerns about the
		  enormous carbon footprint of "Proof-of-Work" blockchain mining.
		  </p>
		  <p class="quote">
		  The city of Plattsburgh has put a moratorium on cryptocurrency mining to preserve natural resources, the health of its residents
		  and the city’s “character and direction,” officials said after a public hearing Thursday. For 18 months, the 20,000-resident
		  city will not consider new applications for commercial cryptocurrency mining. Violators will face fines of up to
		  $1,000 for each day they defy the moratorium.
		  <sup>3</sup>
		  </p>
		  <p>So, me too - count me out, I can't help but do the same, and pronounce my own refrain from Bitcoin (this is more
		  spiritual since I don't own, nor mine). In contrast, I'll put Ethereum on hold since they are transitioning to a
		  zero carbon-footprint by year's end. </p>
		  <p>And, for the most environmentally friendly cryptocurrencies, I wholly support Ripple (3rd highest valued cryptocurrency)
		  and also clean
		  <i>Iota</i> (8th highest valued )
		  <sup>5</sup>. Ripple, unfortunately, is a private company with a less-accessible internal distributed ledger. And yet,
		  Hedera Hashgraph heralds the most optimistic news of all: A blindlingly fast Hashgraph structure, unbound from any
		  carbon footprint.
		  </p>
		  <p>1.
		  <a href="http://www.wri.org/blog/2017/01/china%E2%80%99s-decline-coal-consumption-drives-global-slowdown-emissions"
			target="_blank">http://www.wri.org/blog/2017/01/china%E2%80%99s-decline-coal-consumption-drives-global-slowdown-emissions</a>
		  </p>
		  <p>2.
		  <a href="https://qz.com/1193603/two-countries-are-the-reason-the-eu-is-hitting-its-ambitious-renewable-energy-targets/"
			target="_blank">https://qz.com/1193603/two-countries-are-the-reason-the-eu-is-hitting-its-ambitious-renewable-energy-targets/</a>
		  </p>
		  <p>3.
		  <a href="https://www.washingtonpost.com/business/economy/upstate-new-york-town-bans-bitcoin-mining/2018/03/16/bd6f669e-2947-11e8-bc72-077aa4dab9ef_story.html?utm_term=.6282ea8429d5"
			target="_blank">https://www.washingtonpost.com/business/economy/upstate-new-york-town-bans-bitcoin-mining</a>
		  </p>
		  <p>4.
		  <a href="https://www.bloomberg.com/news/articles/2018-02-14/next-generation-crypto-ledgers-take-the-block-out-of-blockchain"
			target="_blank">https://www.bloomberg.com/news/articles/2018-02-14/next-generation-crypto-ledgers-take-the-block-out-of-blockchain</a>
		  </p>
		  </div>
		  
		  <div id="mar-18-03-15" class="  mar 18-03 -15">
		  
		  <hr />
		  <button>
		  <a href="#martop">Top</a>
		  </button>&nbsp;
		  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>
		  
		  <h5 class="  subdailytech">Web Dev Affairs</h5>
		  
		  <p class="  author">by Thomas Maestas, MA</p>
		  
		  <h6 class="  chapternumber">March 15, 2018</h6>
		  
		  <h6 class="dailytitle chapternumber">I Love this Record Baby but I Can't See Straight Anymore:
		  <br />It's Gonna be Okay, Flip that Record and Just Dance!
		  </h6>
		  <p>-Lady Gaga</p>
		  <br />
		  <p class="firstparagraph">
		  <strong>Creators in the Digital Age</strong>, especially Musicians, have faced just a panoply of business model challenges,
		  notably since the 2000s'
		  <i>Napster Era</i>. And yet, this is the age-old-case of new technologies reshaping long-standing fields, especially
		  financial structure - the bottom line! All creative fields also have technological features on the horizon that
		  may, potentially move the playing field. First some recent background: </p>
		  <p class="quote">
		  While [Taylor Swift] is certainly making money in retail sales and digital downloads, both of those metrics are spiraling
		  downward as people migrate away from the concept of owning music at all. Nielsen recently released numbers indicating
		  substantial drops in both CD and digital-track sales, which are down almost $100 million
		  <i>year over year</i> from 2014; streaming music continues to grow, but the revenue it generates isn’t close to making
		  up the difference, yet.
		  <sup>1</sup>
		  </p>
		  <p>Most remember Taylor Swift's 2014 industry-shaking album withdraw in protest to Spotify's payment structure. The
		  next year Taylor took on Apple iTunes--to which Apple bended to Taylor's Way
		  <sup>2</sup>. These wins are amazing but not enough, if only for winning battles in a losing war. </p>
		  <p class="quote">Spotify is the future. Spotify is the enemy. Spotify doesn’t pay enough. Spotify is music’s best bet for revenue
		  growth. Since it arrived in the United States from Sweden in 2011, Spotify has been cast as both hero and villain
		  in the music industry’s continuing debate over streaming music. </p>
		  <p class="quote">
		  It has been hailed as a potential savior through a two-tiered “freemium” model that would gradually lure listeners away from
		  piracy. Yet Spotify’s royalty rates have also terrified many artists already worried that each new step in music’s
		  digital evolution further devalues their work.
		  <sup>3</sup>
		  </p>
		  <p>So the trend looks dire, and yet is it really? Where, just where are the
		  <strong>Tech Platforms </strong> leading us? Tech is leading us
		  <i>nowhere</i>, at least not to one
		  <strong>singular, centralized place</strong>; rather, decentralized tech--including but not limited to blockchain--is busy
		  rewriting the boundaries between creators and consumers. This Tuesday's Forbes article reported on new subscription-based
		  model by Patreon. Still classical Web 2.0, it's novelty appears so simple, almost intuitive in potentially new pathway:</p>
		  <p class="quote">"On Kickstarter and Indiegogo, creators essentially have to start over every time," says Danny Rimer, a partner at
		  Index Ventures who is a Patreon investor and board member. "It's the same reason software companies went from licensed
		  software to subscriptions: predictable revenue and better service for customers."
		  <sup>4</sup>
		  </p>
		  <p>
		  Apparently Patreon, along with last November's
		  <i>Drip</i> by KickStarter have made headway. Patreon paid out $150 million to its artists in 2017, and each are doubling
		  annually. Decentralizing again. Well, we say we can't
		  <i>go back to the way it was</i>, but Tech always seems to lead us back to the way it was!
		  </p>
		  <p>1.
		  <a href="https://www.nytimes.com/2016/01/25/magazine/touring-cant-save-musicians-in-the-age-of-spotify.html" target="_blank">https://www.nytimes.com/2016/01/25/magazine/touring-cant-save-musicians-in-the-age-of-spotify.html
		  </a>
		  </p>
		  <p>2.
		  <a href="http://www.businessinsider.com/taylor-swift-new-album-reputation-not-on-spotify-apple-music-streaming-2017-11"
			target="_blank">http://www.businessinsider.com/taylor-swift-new-album-reputation-not-on-spotify-apple-music-streaming-2017-11
		  </a>
		  </p>
		  <p>3.
		  <a href="https://www.nytimes.com/2014/11/12/business/media/taylor-swifts-stand-on-royalties-draws-a-rebuttal-from-spotify.html"
			target="_blank">https://www.nytimes.com/2014/11/12/business/media/taylor-swifts-stand-on-royalties-draws-a-rebuttal-from-spotify.html
		  </a>
		  </p>
		  
		  
		  <p>4.
		  <a href="https://www.forbes.com/sites/kathleenchaykowski/2018/02/13/digital-medici-how-this-musician-turned-entrepreneur-plans-to-save-creators-from-advertising/#6063ea771313"
			target="_blank">https://www.forbes.com/sites/kathleenchaykowski/2018/02/13/digital-medici-how-this-musician-turned-entrepreneur-plans-to-save-creators-from-advertising
		  </a>
		  </p>
		  </div>
		  
		  <div id="mar-18-03-14" class="  mar 18-03 -14">
		  
		  <hr />
		  <button>
		  <a href="#martop">Top</a>
		  </button>&nbsp;
		  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>
		  
		  <h5 class="  subdailytech">Sociology Tomorrow!</h5>
		  
		  <p class="  author">by Thomas Maestas, MA</p>
		  
		  <h6 class="  chapternumber">March 14, 2018</h6>
		  
		  <h6 class="dailytitle chapternumber">
		  <i>Tou
			<strong>Demou</strong> tes
			<strong> Krates</strong>
		  </i>:
		  <br />Strength of the People</h6>
		  
		  <p class="firstparagraph">Today's demonstrations and walk-outs, led by America's Youth and followed by many of the education staff, has aimed
		  directly at Gun-Control legislation. Yet, the message more powerfully articulated than ever by adolescent-turns-adult
		  students, takes aim at something further afield. </p>
		  <p>Students, remembering the February 14th massacre victims, take aim at the corruption stemming from the 2010 Supreme
		  Court "Person-hood" protection for Corporations, also known as the
		  <i>Citizens United</i> Decision. A dated, but poignant, article from National Public Radio explains:
		  </p>
		  <p class="quote">The Supreme Court extended that protection to corporations, and over time also extended some — but not all — of the
		  rights guaranteed to individuals in the Bill of Rights.
		  <sup>1</sup>
		  </p>
		  <p>
		  Yet, it appears deceptively harmless for Congressional Law-makers to protect corporations, in the form of
		  <strong>Gun Manufacturers' Lobbyists, </strong>
		  as equally as it protects humans. The origin or this ruling dates to a 70's Neo-Liberal, right-leaning legislation and Court
		  rulings that include a pivotal 1978
		  <i>First National Bank of Boston v. Belloti</i> decision allowing for corporations' ballot-initiative campaign contributions,
		  citing the First Amendment.
		  <sup>2</sup>
		  </p>
		  <p>
		  
		  The Result? The corporation, in "person" form, takes on Pseudo-Human qualities: immortal, beyond-measure capital, and programmatically
		  serving stock-holders' interests with cut-throat competition at all costs. No match against a sympathetic human,
		  yet the Corporation is given the same rights and privileges as the man in the street. Now, in the face of two decades'
		  dead humans--as young as
		  <i>Sandy Hook Elementary</i>, which were not protected by Legislation, due to commitments made to corporate lobbying.
		  </p>
		  <p>It appears increasingly difficult for Marco Rubio to accept money from gun lobbyists
		  <i>in exchange</i> for executing their legislation demands. As I mentioned in my
		  <a href="#18-02-14">February 14th post</a> on the topic, it is clear a generation is awakening: And, the Humans have begun to revolt
		  against the
		  <strong>Heavily-Armed Lobbying Machines!
		  </strong>
		  </p>
		  <p>1.
		  <a href="https://www.npr.org/2014/07/28/335288388/when-did-companies-become-people-excavating-the-legal-evolution"
			target="_blank">https://www.npr.org/2014/07/28/335288388/when-did-companies-become-people-excavating-the-legal-evolution</a>
		  </p>
		  <p>2.
		  <a href="http://www.ncsl.org/research/elections-and-campaigns/campaign-finance-and-the-supreme-court.aspx#dnn_ctr77443_HtmlModule_lblContent"
			target="_blank">http://www.ncsl.org/research/elections-and-campaigns/campaign-finance-and-the-supreme-court.aspx</a>
		  </p>
		  http://www.ncsl.org/research/elections-and-campaigns/campaign-finance-and-the-supreme-court.aspx dnn_ctr77443_HtmlModule_lblContent
		  </div> 
		  <div id="mar-18-03-13" class="mar 18-03 -13">
		  <hr />
		  <button>
		  <a href="#martop">Top</a>
		  </button>
		  <h4 class="title dailytech longtitle">OUR DAILY TECH:</h4>
		  
		  <h5 class="subdailytech">Musing Blockchain</h5>
		  
		  <p class="author">by Thomas Maestas, MA</p>
		  
		  <h6 class="chapternumber">March 13, 2018</h6>
		  
		  <h6 class="dailytitle chapternumber">The Sharing Economy Hand-in-Hand with the Market Economy:
		  <br /> Part III and Sustainability of Shared, Distributed Ledger Types</h6>
		  
		  <p class="firstparagraph">March 13th, 2018 marks the day that certain types of blockchain technologies, notably Bitcoin and Ethereum, face
		  an existential crisis: Today, a new distributed ledger technology has been announced, which departs from the traditional
		  "Proof-of-Work" (energy-intensive calculations) Blockchain technologies. This is critically important to zero carbon-footprint.
		  For example, Bitcoin calculations drain more energy, 50 TeraWatt/hrs per year--higher than Singapore's 49.8!</p>
		  <p>Next, the primary security flaw of consensus-based leadership like Ripple, Iota (as opposed to
		  <i>random-selection blockchain leadership</i> based on carbon-intensive calculations) is they are susceptible to Hacking:
		  Denial-of-Service Attacks are possible because the next leader Block can be anticipated and followed by a Bot),
		  so the blockchain cycle is attacked at every cycle. </p>
		  <p>The Heder Hashgraph unveiled today overcomes this problem by using a 39-node-leader hashgraph data structure. Interestingly,
		  this is based on the original Visa Credit Card design from the 1950's (then called AmericaBank) for authenticating
		  system. </p>
		  <p>
		  Next, The Heder Hashgraph overcomes the problem of "fairness" because blockchain transactions are
		  <i>
			<strong>not ordered in each cycle</strong>.</i> Bitcoin transactions are haphazardly lumped together in each block-cycle,
		  which is ~12 minutes. Which means that time-sensitive financial data queries will always lose! </p>
		  <p>
		  Swirld's unveiled their consensus-based
		  <strong>Hashgraph, a type of distributed ledger technology (DLT),</strong> last year. Today, it has now been announced to
		  deploy in late 2018 on the Hedera Hashgraph public network. This is tremendous news! Tremendous, since I explained
		  in my
		  <a href="#18-03-01">March 1st </a> blog post that older blockchain technologies incentivize miners' efforts by directly tying electrical-cost(
		  (in calculations) to the Bitcoin/hour profit margin. For this reason, the future horizon just considerably shortened
		  Bitcoin's runway for establishing anything beyond "early-adopter" status. </p>
		  <p>So, we'll see if the innovating crew with Vitalik Buterin's Ethereum can successfully alter the crypto algorithm
		  into it's planned carbon-free consensus-based, "proof-of-stake" form. For the moment, Bitcoin, Ethereum, and other
		  electricity-draining "proof-of-work" designs, have their
		  <strong>exchange value trapped inside their own Carbon Footprint</strong>.
		  <sup>4</sup> And so, because environmental sustainablity is foremost of concerns for future investment, survival may
		  depend on digging out of that Carbon Footprint much more quickly!</p>
		  
		  <p>1.
		  <a href="https://www.forbes.com/sites/jeffkauflin/2018/03/13/hedera-hashgraph-thinks-it-can-one-up-bitcoin-and-ethereum-with-faster-transactions/#175e5c79abcb">
			https://www.forbes.com/sites/jeffkauflin/2018/03/13/hedera-hashgraph-thinks-it-can-one-up-bitcoin-and-ethereum-with-faster-transactions/#175e5c79abcb
		  </a>
		  </p>
		  
		  <p>2.
		  <a href="https://www.coindesk.com/hedera-hashgraph-swirlds-no-fork-guarantee-cryptocurrency-touts-resistance-code-splits/"
			target="_blank">
			https://www.coindesk.com/hedera-hashgraph-swirlds-no-fork-guarantee-cryptocurrency-touts-resistance-code-splits/</a>
		  </p>
		  
		  <p>3.
		  <a href="https://venturebeat.com/2018/03/13/hedera-hashgraph-and-mz-unveil-next-generation-blockchain-alternative/"
			target="_blank">
			https://venturebeat.com/2018/03/13/hedera-hashgraph-and-mz-unveil-next-generation-blockchain-alternative/</a>
		  </p>
		  
		  
		  <p>4.
		  <a href="https://blog.ethereum.org/2016/02/09/cut-and-try-building-a-dream/" target="_blank">https://blog.ethereum.org/2016/02/09/cut-and-try-building-a-dream/</a>
		  </p>
		  </div>
		  
		  <div class="mar 18-03 -12" id="mar-18-03-12">
		  <hr />
		  <button>
		  <a href="#martop">Top</a>
		  </button>&nbsp;
		  <h4 class="title dailytech longtitle">OUR DAILY TECH:</h4>
		  
		  <h5 class="subdailytech">Sociology Tomorrow!</h5>
		  
		  <p class="author">by Thomas Maestas, MA</p>
		  
		  <h6 class="chapternumber">March 12, 2018</h6>
		  
		  <h6 class="dailytitle chapternumber">The Sharing Economy Hand-in-Hand with the Market Economy:
		  <br /> Part II and New Forms of Trust</h6>
		  <p class="firstparagraph">
		  Throughout the centralized-tech period of the
		  <i>mobile-powered </i> Web 2.0, most Sharing transactions take place on a centralized platform that simply facilitates
		  the peer-to-peer transactions. However, the trust is based on some third-party authority. For instance, Uber serves
		  as the centralalized, third-party authority between both consumers (whether resource-obtaining or resource-providing)
		  must place their trust. Similarly, centralized authorities like Paypal, etc. enable peer-to-peer collaboration.
		  Yet, the notion of trust remains unsolved: Both parties must place their faith in the third party. By definition,
		  this problem that undermines the
		  <i>Sharing Economy</i> is resolved by Blockchain technologies, through cryptography. Now, Decentralized Apps (DAPPS)
		  provide a truer sharing platform for value transactions.
		  </p>
		  <p>In short, neither peer,
		  <strong>neither consumer needs to be trusted, because both parties share a mutual trust in their shared ledger</strong>
		  (think of a thick book with an indexed log of each and every transaction, with unchangeable entries etched by cryptography.
		  In this fashion the forms of Exchange Value include:
		  <br /> 1. Value Funds &amp; Investments
		  <br /> 2. Immutable Insurance &amp; Risk Management
		  <br /> 3. Account for &amp; Audit Commodified Value 4. Authenticate &amp; Attest to Value
		  <br /> 5. Transfer, Store, Lend Value
		  <br />
		  </p>
		  </div>
		  
		  <div class="mar 18-03 -10" id="mar-18-03-10">
		  
		  <hr />
		  <button>
		  <a href="#martop">Top</a>
		  </button>&nbsp;
		  <h4 class="title dailytech longtitle">OUR DAILY TECH:</h4>
		  
		  <h5 class="subdailytech">Web Dev</h5>
		  
		  <p class="author">by Thomas Maestas, MA</p>
		  
		  <h6 class="chapternumber">March 10-11, 2018
		  <br /> Weekend
		  </h6>
		  
		  <h6 class="dailytitle chapternumber">The Sharing Economy Hand-in-Hand with the Market Economy:
		  <br /> Part I and the Race for Sustainability Solutions</h6>
		  
		  <p class="firstparagraph">Sharing can be a philosophy and even an ideology, but it is also
		  <strong> a concept sewn into the Technology of the Era</strong>. Sharing economy refers to both democratized peer-to-peer
		  marketplaces,
		  <i>and</i> collaborative, resource-circulating consumption systems where the consumer&#39;s role is provider or obtainer
		  of resources. By either sense, the
		  <i>Uberized</i> economy is made possible by the underlying platform of Decentralized Technologies. Mobile social media,
		  internet, and blockchain tech creates the conditions needed for a convenient, community-based transactions.</p>
		  
		  <p>Bitcoin and Ethereum crypto-contracts grab the headlines, however it is the very nature of blockchain&#39;s
		  <i>distributed, i.e. shared, </i>ledger that revolutionizes how humans interact, and how they exchange and share goods
		  and services. So, how might a transactional, zero-sum Market Economy merge with a Sharing Economy?</p>
		  
		  <p>In
		  <i>The Third Industrial Revolution, </i>Social and Economic theorist, Dr. Jeremy Rifkin, provides insight into how
		  the
		  <strong>Sharing Economy can grow alongside the traditional Market Economy</strong>.
		  <sup>1</sup> The theory argues three (3) breakthroughs are needed to create the conditions necessary for a new &quot;general
		  purpose technological platform,&quot; and thus an Industrial Revolution. They are management/commmunication of power,
		  sources of new power/energy, and the transportation of this power.</p>
		  
		  <p>The first condition: New forms of communication to
		  <i>manage</i> power, for example steam-powered printing press, trans-oceanic telegraph, then later telephone. The second
		  condition: New energy sources, for example steam-engine using coal and other fossil fuels. The third condition:
		  New methods to transport energy, i.e. the steam engine on rails, then later fossil fuel vehicles.</p>
		  
		  <p>So what&#39;s new about today? 5G Cellular technology coupled with decentralized, blockchain internet; Second, improving
		  solar &amp; wind power coupled with decentralized, bi-directional energy grid; and third, transporation by automatated,
		  driverless shipping for example. So, why is this important, even vital to adapt a new paradigm that fits the new
		  technology? exponential populstion growth and exponential climate changes are top of the list.</p>
		  
		  <p>Britain&#39;s innovations with steam &amp; coal characterized the first Industrial Revolution, and America&#39;s
		  innovations in telephones, oil-fueled vehicles, and centralized transportation grid, however the innovations in
		  the present era are much quicker than previous eras... which means we as a society can embrace more proactively
		  the New Paradigm needed to adapt.</p>
		  
		  <p>So, how can we change the way we
		  <i>think</i> and how we
		  <i>react</i> depends on our worldview, and how deeply entrenched. Thomas Kuhn&#39;s 2004 publication on
		  <strong>
			<i>The Structure of Scientific Revolution</i>
		  </strong>
		  <sup>3</sup> explains how society will drag its feet in the face of change, and only after decades of controversy will
		  a New Paradigm Shift emerge. In this occasion however, we as a society may not have the luxury of decades to adapt
		  to New Technologies, as the carbon hangover from the previous Industrial Era imperils the safe arrival of the next!</p>
		  
		  <p>&nbsp;</p>
		  
		  <p>1.
		  <a href="https://www.foet.org/books/the-third-industrial-revolution/" target="_blank">https://www.foet.org/books/the-third-industrial-revolution/</a>
		  </p>
		  
		  <p>2.
		  <a href="https://www.economist.com/node/21553017" target="_blank">https://www.economist.com/node/21553017</a>
		  </p>
		  
		  <p>3.
		  <a href="https://projektintegracija.pravo.hr/_download/repository/Kuhn_Structure_of_Scientific_Revolutions.pdf"
			target="_blank">3. Kuhn, Thomas, The Structure of Scientific Revolutions, </a>
		  </p>
		  </div>
		  
		  <div class="mar 18-03 -09" id="mar-18-03-09">
		  <hr />
		  <button>
		  <a href="#martop">Top</a>
		  </button>&nbsp;
		  <h5 class="title dailytech longtitle">OUR DAILY TECH:</h5>
		  
		  <h5 class="subdailytech">Web Dev Affairs</h5>
		  
		  <p class="author">by Thomas Maestas, MA</p>
		  
		  <h6 class="chapternumber">March 9th, 2018</h6>
		  
		  <h6 class="dailytitle chapternumber">&#39;Alexa, can you laugh?&#39;</h6>
		  
		  <p class="firstparagraph">Alexa has made headlines about reports of unexplained laughter responses
		  <sup id="0309-1">1</sup>. Information like this needs a
		  <i>
			<strong>fact-check</strong>
		  </i> &agrave; la Snopes.com.
		  <sup id="0309-2">2</sup> And, whether or not Alexa misheard, &quot;Alexa, laugh&quot;, or not, is less important than the
		  <i>socially-intrusive consequences</i> of simple app-development errors. The first issue is simply that programmer
		  <strong>logic </strong> and user-interface intuition should be as clear (and generalized) as possible. This is easier said
		  than done, for example the recent case of Hawaii&#39;s mistaken
		  <i>incoming-ballistic-missile warning system</i>.
		  <sup id="0309-3">3</sup> As it turned out, the dropdown-menu design placed the &quot;Send Test Warning&quot; next to &quot;Send Warning&quot;
		  in an unintuitive, fail-possible manner. Oops.</p>
		  
		  <p>While most focus on Alexa et al.&#39;s actions and abilites, in the name of caution, but rather the larger issue
		  falls on how much we allow ourselves to mentally depend on tech for things.</p>
		  
		  <p>1.
		  <a href="https://www.buzzfeed.com/venessawong/amazon-alexa-devices-are-laughing-creepy?utm_term=.um6P18a8a#.cgggP2j2j"
			target="_blank">https://www.buzzfeed.com/venessawong/amazon-alexa-devices-are-laughing-creepy?utm_term=.um6P18a8a#.cgggP2j2j</a>
		  </p>
		  
		  <p>2.
		  <a href="https://www.snopes.com/fact-check/is-amazons-alexa-emitting-unprompted-creepy-laughing/" target="_blank">https://www.snopes.com/fact-check/is-amazons-alexa-emitting-unprompted-creepy-laughing/</a>
		  </p>
		  
		  <p>3.
		  <a href="https://www.washingtonpost.com/news/morning-mix/wp/2018/01/16/that-was-no-wrong-button-in-hawaii-take-a-look/?utm_term=.a2aa65329002"
			target="_blank">https://www.washingtonpost.com/news/morning-mix/wp/2018/01/16/that-was-no-wrong-button-in-hawaii-take-a-look/?utm_term=.a2aa65329002</a>
		  </p>
		  </div>
		  
		  <div class="mar 18-03 -12" id="mar-18-03-08">
		  <hr />
		  <button>
		  <a href="#martop">Top</a>
		  </button>&nbsp;
		  <h5 class="title dailytech longtitle">OUR DAILY TECH:</h5>
		  
		  <h5 class="subdailytech">Sociology Tomorrow!</h5>
		  
		  <p class="author">by Thomas Maestas, MA</p>
		  
		  <h6 class="chapternumber">March 8, 2018</h6>
		  
		  <h6 class="dailytitle chapternumber">1.4 Million Reasons for More Women in Tech, Part II
		  <br />
		  <br /> * Continuation of Women in Tech Theme from
		  <a href="#18-02-23">Feb. 23rd Blog</a>
		  </h6>
		  
		  <p class="quote">This is the first time in human history that we have the ability to see enough about ourselves that we can hope to
		  actually build social systems that work qualitatively better than the systems we&#39;ve always had.</p>
		  
		  <p class="quote">--Author unknown</p>
		  
		  <p class="firstparagraph">My February 23rd Post on women in tech focused on the
		  <i>workforce demand</i> for more women in tech positions, however today I&#39;m writing on the
		  <strong>
			<i>social need</i> for more female insight within the tech workforce</strong> , given that programming will increasingly
		  shape our future institutions. This means that every institution, whether private hospitals, non-profit charity
		  foundations, or government bureaus, will effectively restructure (optimize) their own organizational structure in
		  an increasingly
		  <i>data-driven</i> paradigm. From a Sociology of Organizations perspective, the changes to come are breath-taking to
		  consider.</p>
		  
		  <p>So why women? Where could I start? Better stated, why is a quintessentially important job sector, a sector in desperate
		  need for insight, comprised primarily of men?
		  <sup id="one">1</sup> The facts are evident: ~15-20% of women comprising tech positions.
		  <sup id="two">2</sup> Numbers aside, I argue there is a quintessential societal need for more women in tech: This is because computing
		  and understanding data has changed since the data collection from Web 2.0 (mobile), becoming more networked and
		  relational.</p>
		  
		  <p>The challenge for society in this age is historic, and women must absolutely be included in the process of the age:
		  Please consider, that in the 1650&#39;s, the invention of the microscope opened a new world of data and
		  <i>information</i> about the bacteriological, microscopic surroundings--hitherto blind to all. Likewise, the telescope
		  has allowed us as a society to explore the outer universe and earth&#39;s position within it.</p>
		  
		  <p>Now, the inventions of machine-learning, computing coupled with Big Data analytics, allows us to explore (and manage)
		  a universe of knowledge--about
		  <i>ourselves</i>, human society--with unfathomably complex, unstructured relational data structures. Accessing the
		  data to computer-readable form is one thing, but meaning in data is inaccessible until the
		  <i>output</i> can be
		  <i>re-</i>programmed into meaningful, human-readable data, i.e. information. This latter stage of development is the
		  key challenge--for which success depends on representative female participation in Tech.</p>
		  
		  <p>Adding to the challenge of finding meaningful trends is the backdrop of noise from spurious variables. This is akin
		  to finding a needle in an increasingly complex and growing haystack.</p>
		  
		  <p class="quote">What&#39;s different now and has changed is it&#39;s no longer about taking this data, putting it into a computer
		  running a calculation and getting a balance sheet answer ...</p>
		  
		  <p class="quote">What&#39;s important now is what is the context of the data, what is it connected to, what effect is it having on
		  data around it... It&#39;s basically a network of the data, it&#39;s no longer sort of tabular columns, of rows
		  of data, it&#39;s
		  <i>interconnected patterns</i>.
		  <br /> --Tim Cook</p>
		  
		  <p>This quote means that as we move away from rule-based, mechanistic data analytics toward more complex, relational
		  and networked data, we need an equally complex paradigm to keep up. Excluding the female mind from this challenge
		  is not simply a clumsy, myopic mistake. Worse yet, so long as the Tech Industry remains gender lop-sided, Tech will
		  increasingly resemble another myopic beast, a cave-dweller named Cyclops.</p>
		  
		  <p>1.
		  <a href="https://www.huffingtonpost.com/2015/03/27/women-in-tech_n_6955940.html" target="_blank">https://www.huffingtonpost.com/2015/03/27/women-in-tech_n_6955940.html</a>
		  </p>
		  
		  <p>2.
		  <a href="https://fairygodboss.com/articles/women-in-tech-facts-figures-and-percentages" target="_blank">https://fairygodboss.com/articles/women-in-tech-facts-figures-and-percentages</a>
		  </p>
		  
		  <p>3.
		  <a href="https://www.aauw.org/research/why-so-few/" target="_blank">https://www.aauw.org/research/why-so-few/</a>
		  </p>
		  </div>
		  
		  <div class="mar 18-03 -12" id="mar-18-03-07">
		  <hr />
		  <button>
		  <a href="#martop">Top</a>
		  </button>&nbsp;
		  <h5 class="title dailytech longtitle">OUR DAILY TECH:</h5>
		  
		  <h5 class="subdailytech">Web Dev Affairs</h5>
		  
		  <p class="author">by Thomas Maestas, MA</p>
		  
		  <h6 class="chapternumber">March 7, 2018</h6>
		  
		  <h6 class="dailytitle chapternumber">About the April 23 Implementation of the FCC Net Neutrality Laws:
		  <br /> The Coming Battle of States&#39; versus Federal Rights Part II</h6>
		  
		  <p class="firstparagraph">Washington&#39;s assertion of States&#39; Rights yesterday may augur the first of many lawsuits over control over
		  bandwidth.</p>
		  </div>
		  
		  <div class="mar 18-03 -12" id="mar-18-03-06">
		  <hr />
		  <button>
		  <a href="#martop">Top</a>
		  </button>&nbsp;
		  <h5 class="title dailytech longtitle">OUR DAILY TECH:</h5>
		  
		  <h5 class="subdailytech">Web Dev Affairs</h5>
		  
		  <p class="author">by Thomas Maestas, MA</p>
		  
		  <h6 class="chapternumber">March 6, 2018</h6>
		  
		  <h6 class="dailytitle chapternumber">April 23 Implementation of the FCC Net Neutrality Laws:
		  <br /> The Coming Battle of States&#39; versus Federal Rights</h6>
		  
		  <p class="firstparagraph">Net Neutrality Rules, potentially one of the more important set of Individual Rights for us as citizens in the tech
		  age, will soon undergo the rule changes voted by the Federal Communications Commission (FCC) this past December.
		  In a nutshell, the Internet Service Providers (ISP&#39;s), e.g. Comcast, Cox, Verizon are granted the power--as
		  a Title I &quot;information service&quot;--to slow down traffic, make fast- &amp; slow-lanes. Of course this is
		  bad news for internet-users because even premium users may experience &quot;throttling&quot; if using the ISP&#39;s
		  preferred apps. The only stipulation holds that the ISP&#39;s rules are made public. However, 21 states are bringing
		  lawsuits to fight these changes, and the first assertion of State Law by Washington State today:</p>
		  
		  <p class="quote">The FCC is already embroiled in a variety of lawsuits related to its rollback of net neutrality rules, including
		  an effort from 21 state attorneys general to get a court to block the FCC&#39;s move.</p>
		  
		  <p class="quote">&quot;This is symbolic politics, because the states know it is illegal to do,&quot; Roslyn Layton, a visiting scholar
		  at the American Enterprise Institute, told NBC News. &quot;But they can put rules on the book and make it look like
		  they&#39;re doing something.&quot; The FCC is already embroiled in a variety of lawsuits related to its rollback
		  of net neutrality rules, including an effort from 21 state attorneys general to get a court to block the FCC&#39;s
		  move.
		  <sup>1</sup>
		  </p>
		  
		  <p>S The big question arises over
		  <i>who</i> has jurisdiction between the States&#39; and Federal authority; yet one thing is certain, the coming battle
		  for protecting citizens&#39; rights will take place over jurisdiction of Internet Bandwidth turf.</p>
		  
		  <p>
		  <a href="https://www.nbcnews.com/tech/tech-news/washington-state-passes-net-neutrality-law-states-push-back-against-n854086"
			target="_blank">https://www.nbcnews.com/tech/tech-news/washington-state-passes-net-neutrality-law-states-push-back-against-n854086</a>
		  </p>
		  
		  <p>&nbsp;</p>
		  </div>
		  
		  
		  <div class="mar 18-03 -12" id="mar-18-03-05">
		  <hr />
		  <button>
		  <a href="#martop">Top</a>
		  </button>&nbsp;
		  <h5 class="title dailytech longtitle">OUR DAILY TECH:</h5>
		  
		  <h5 class="subdailytech">Healthy Today!</h5>
		  
		  <p class="author">by Thomas Maestas, MA</p>
		  
		  <h6 class="chapternumber">March 5, 2018</h6>
		  
		  <h6 class="dailytitle chapternumber">A Return to the Question of Guns, Germs, and Steel: Part II and the Germs</h6>
		  
		  <p class="firstparagraph">Germs present a timely topic for today, given the especially virulent
		  <strong>Flu Virus strain</strong>. Many, like me, have wondered why our 1940&#39;s-era
		  <sup>1</sup> technology in Flu Vaccine fabrication wouldn&#39;t invite more innovative solutions. Without feigning any
		  medical expertise, I have to still ask about the progress made with the ever-mutating--i.e., drifting--Flu virus&#39;
		  surface protein &quot;head,&quot; called hemaglutinin. This strategy &quot;guesses right&quot; very effectively,
		  and provides an effective solution for most, in most years. Yet this winter has revealed that effectiveness statistics
		  are
		  <i>not always</i> in our favor.</p>
		  
		  <p class="quote">For many decades, researchers believed the flu vaccine offered solid protection if it was a good match to the circulating
		  strains; studies from the 1940s through the 1960s routinely showed an efficacy of 70% to 90%. But those studies
		  relied on a misleading methodology.</p>
		  
		  <p class="quote">Danuta Skowronski, an epidemiologist at the BC Centre for Disease Control in Vancouver, Canada, instead blames mutations
		  in the vaccine strain itself. The most common influenza vaccine contains an &quot;inactivated&quot; virus, which
		  manufacturers grow in chicken eggs. As Skowronski&#39;s team first reported in 2014, the virus can mutate while
		  it is growing in the eggs, resulting in a vaccine unable to block circulating strains.
		  <sup>1</sup>
		  </p>
		  
		  <p>Earlier, I casually mentioned &quot;guessing&quot;, yet with great respect, the science behind estimating the flu
		  virus between the time of R &amp; D, fabrication, and the flu
		  <i>season</i>. (This antigenic drift, not to be confused with
		  <i>Antigenic Shift</i> in which the Flu Virus makes an abrupt change.) I&#39;ll let the CDC abbreviate this:</p>
		  
		  <p class="quote">One way they change is called &ldquo;antigenic drift.&rdquo; These are small changes in the genes of influenza viruses
		  that happen continually over time as the virus replicates. These small genetic changes usually produce viruses that
		  are pretty closely related to one another, which can be illustrated by their location close together on a phylogenetic
		  tree. Viruses that are closely related to each other usually share the same antigenic properties and an immune system
		  exposed to an similar virus will usually recognize it and respond
		  <sup>2</sup>.</p>
		  
		  <p>So, ultimately, the strategy is to estimate the form, location, of that virus--what it will look like--at a particular
		  period each year. This implicates a strategy to estimate the trajectory, stage by stage, of this virus, i.e. a longitudinal
		  time-series morphology, each year. The article makes this point more precise:</p>
		  
		  <p class="quote">But these small genetic changes can accumulate over time and result in viruses that are antigenically different (further
		  away on the phylogenetic tree). When this happens, the body&rsquo;s immune system may not recognize those viruses.
		  <sup>2</sup>
		  </p>
		  
		  <p>Petri dishes aside, let&#39;s focus on the changing nature of the Flu Virus, which makes itself a
		  <i>research </i>challenge in itself because of an ever-mutating object of study. Yet, this ever-changing nature also
		  provides the very tool Statisticians need most for estimating: Big Data. The Law of Large Numbers means that plain
		  math can accurately plot, and in most cases predict with a moderate statistical significance, future events, sort
		  of.</p>
		  
		  <p>Sort of I say because too often we predict that two separate events are more likely to occur, conditional on each
		  other, then conditional upon other factors. This being
		  <i>correlation</i>, but the Statistician&#39;s Holy Grail is the other kind: Causality. Causality hinges on only thre3e
		  things: 1) Association, 2) Time Precedence, and 3) Ruling out any
		  <i> effect</i> of spurious variables. (Hang with me, I&#39;m still getting back to the subject of our annual predictions
		  about a few months&#39; worth of antigenic drift.)</p>
		  
		  <p>Therefore, Big data, and new advances in the statistical sciences, and the technology that increasingly defines our
		  sciences, may soon refine and supercharge research into the first and third of the three points of causality. The
		  first of these, the associations, along the phylogenetic tree, are merely a network at its base, the science of
		  which gains computational strength each year. Rare as it is in Academia, in this case Might makes Right!</p>
		  
		  <p>
		  The third tenet of causality, after association and time direction, is ruling out the effect of other factors when separating
		  <i>cause</i> and consequence. Advances in managing big data, and statistical analysis of it, means gaining a better
		  handle on the multiple effects of
		  <sup>spurious </sup>factors, hence analysis optimized by new, network-graph data structure technology. The Law of Large
		  Numbers
		  <sup>3</sup>, i.e. the sheer number of mutations and other factors, coupled with new
		  <strong>technology</strong>, will better inform the morphology of the
		  <i>path</i> of the virus, along the phylogenetic tree itself. Who knows where a cure may come from, perhaps a bio-statistician
		  out there, churning the numbers, may be the one to stumble upon a better Flu Vaccine!
		  
		  </p>
		  <p>1.
		  <a href="http://www.sciencemag.org/news/2017/09/why-flu-vaccines-so-often-fail" target="_blank"> http://www.sciencemag.org/news/2017/09/why-flu-vaccines-so-often-fail </a>
		  </p>
		  
		  <p>2.
		  <a href="https://qz.com/1143420/the-2017-2018-flu-vaccine-is-less-effective-than-usual" target="_blank"> https://qz.com/1143420/the-2017-2018-flu-vaccine-is-less-effective-than-usual </a>
		  </p>
		  
		  <p>3.
		  <a href="https://www.cdc.gov/flu/about/viruses/change.htm" target="_blank"> https://www.cdc.gov/flu/about/viruses/change.htm </a>
		  </p>
		  
		  <p class="quote">&nbsp;</p>
		  </div>
		  
		  <div class="mar 18-03 -12" id="mar-18-03-03">
		  <hr />
		  <button>
		  <a href="#martop">Top</a>
		  </button>&nbsp;
		  <h5 class="title dailytech longtitle">OUR DAILY TECH:</h5>
		  
		  <h5 class="subdailytech">Sociology Tomorrow!</h5>
		  
		  <p class="author">by Thomas Maestas, MA</p>
		  
		  <h6 class="chapternumber">March 3-4, 2018
		  <br /> Weekend
		  </h6>
		  
		  <h6 class="dailytitle chapternumber">A Return to the Question of Guns, Germs, and Steel</h6>
		  
		  <p class="firstparagraph">Back in 1997, a Pulitzer-Prize winning theory--based on Dr. Jared Diamond&#39;s
		  <i>Guns, Germs, and Steel: The Fate of Human Societies</i> --provided the recipe book for the success of societies.
		  Not without controversy, the theory posits that geographic and environmental preconditions, once met, provide tech
		  &amp; resources trading opportunities, within a network of other nation-states also vying for technogical innovation.</p>
		  
		  <p>A nation&#39;s Technology, in turn, opens the means necessary to expansive, stable, independent sovereignty that
		  lasts and thrives. Equally so, the nation&#39;s friends, especially those making the best-friends list, share and
		  receive a secondary, &quot;residual&quot; technological bump over the time-course of the network&#39;s future trading,
		  i.e. network transactions. So, if our best friends Canada and Mexico are less keen, then there is network reverberation!</p>
		  
		  <p>Given the advent of a real, lasting Trade-War, I would think that a network theorist wouldn&#39;t be betting on one
		  particular node within this network. I say this because a disproportionately asymmetrical flow of technology and
		  resources, while simultaneously raising prices on most staple goods, may spell trouble for the Every-Day person.
		  So far, Nation-State: 0, People: 0 ... So, who wins with a Trade War? Alas, let&#39;s hope not the resurrection
		  of the Neo-Multi-National Corporations, born from NAFTA deals, coincidentally, from the late 1990&#39;s. Bah humbug!</p>
		  
		  <p>&nbsp;</p>
		  
		  <p>1.
		  <a href="http://www.jareddiamond.org/Jared_Diamond/Guns,_Germs,_and_Steel.html" target="_blank">Guns, Germs, and Steel. &quot;Steel: The Fates of Human Societies.&quot; Diamond J (1997).</a>
		  </p>
		  </div>
		  
		  <div class="mar 18-03 -12" id="mar-18-03-02">
		  <hr />
		  <button>
		  <a href="#martop">Top</a>
		  </button>&nbsp;
		  <h5 class="title dailytech longtitle">OUR DAILY TECH:</h5>
		  
		  <h5 class="subdailytech">Web Dev Affairs</h5>
		  
		  <p class="author">by Thomas Maestas, MA</p>
		  
		  <h6 class="chapternumber">March 2, 2018</h6>
		  
		  <h6 class="chapternumber dailytitle">Widening Circles of Mobile-App Security Risks</h6>
		  
		  <p class="firstparagraph">Security, security, another day another platform risk, or risks from your device, or risks from transactions, Today&#39;s
		  headline buried beneath a techy jargon provides a glimpse of the rising threat of web-application-based hackery:
		  Cryptojacking.
		  <i>Coindesk</i> reports, &quot; Opera browser introduces cryptocurrency miner protection for smartphones ... &quot;</p>
		  
		  <p class="quote">Cryptocurrency miners can overload smartphones&#39; CPUs, forcing 100 percent usage and potentially causing a phone
		  to overheat. And the damage can sometimes be permanent. According to a ZDNet article, one trojan generated so much
		  heat in a phone, its battery became swollen, permanently damaging the phone. While excessive ads were one reason
		  for the heat generation, the main cause was that the phone&#39;s CPU was hijacked to mine for Monero.
		  <sup>1</sup>
		  </p>
		  
		  <p>The larger issue here is that the lines between trusted mobile-app authorities, i.e., certified by Play Store or
		  Apple&#39;s is increasingly irrelevent. This is because an increasing number of app-users are ditching device-downloaded
		  apps, preferring for browser applications--hence, a much more appetizing market for the newest generation of blackhat
		  hackers, online thieves, peeping-toms, and other ill-wishers. There are a few driving factors for this issue--one
		  of which is the onset of Decentralized Applications (DAPPs), which use the
		  <i>browser</i> to interface between the Every-Day blockchain client/merchant/programmer and the actual byte-code of
		  the blockchain (via WEB).</p>
		  
		  <p>More importantly, the larger issue is that we live in an age in which the exclusive, native browser language since
		  1995, i.e. JavaScript. Security issues with browser-based apps were very low, because JavaScript never left the
		  browser, ever. Until 2009, Data, Servers were the domain of PHP, JAVA, Python, etc. or some other language for the
		  highly sensitive, dirty work of dipping into all that data sitting ontop of centralized servers around the world.
		  PHP wasn&#39;t easy, so power and responsibility usually followed with all the extra effort and expertise.</p>
		  
		  <p>2015 augured in the Node.js server-accessing (can create, read, update, and delete date) new-born capabilities of
		  JavaScript</p>
		  
		  
		  <p>1.
		  <a href="
		  https://www.coindesk.com/opera-browser-introduces-cryptocurrency-miner-protection-for-smartphones/
		  " target="_blank"> https://www.coindesk.com/opera-browser-introduces-cryptocurrency-miner-protection-for-smartphones/ </a>
		  </p>
		  </div>
		  
		  <div class="mar 18-03 -12" id="mar-18-03-01">
		  <hr />
		  <button>
		  <a href="#martop">Top</a>
		  </button>&nbsp;
		  <h5 class="title dailytech longtitle">OUR DAILY TECH:</h5>
		  
		  <h5 class="subdailytech">Musing Blockchain</h5>
		  
		  <p class="author">by Thomas Maestas, MA</p>
		  
		  <h6 class="chapternumber">March 1, 2018</h6>
		  
		  <h6 class="chapternumber dailytitle">Blockchain Sustainability Issues and The Double-Edged Sword</h6>
		  
		  <p class="firstparagraph">I couldn&#39;t help but revisit the
		  <strong>Environmental Sustainability</strong> problem I addressed in my February 28th post. This problem, experienced by
		  the top two crypto-currencies Bitcoin and Ethereum, is that the
		  <i>monetary</i> value of the currency is matched to the
		  <i>computing difficulty</i>--measured either by how much the computer is sweating, or by electricity KiloWatt Hours
		  per year.
		  <sup>1</sup> Digiconomist succinctly writes:</p>
		  
		  <p class="quote">The continuous block mining cycle incentivizes people all over the world to mine Bitcoin. As mining can provide a
		  solid stream of revenue, people are very willing to run power-hungry machines to get a piece of it. Over the years
		  this has caused the total energy consumption of the Bitcoin network to grow to epic proportions, as the price of
		  the currency reached new highs.
		  <sup>2</sup>
		  </p>
		  
		  <p>And, so the issue I&#39;m addressing is a side-effect of the deepening incentivization for miners to invest more
		  equipment, and in turn, more electricity. The article goes on to report Bitcoin&#39;s surpassing 50 TeraWatt-Hours-per-year
		  usage has surpassed that of Portugal and Singapore, which are 49.5 TWh per year, and 49.8 TWh per year, respectively.
		  In other words, the usage by the Bitcoin miner&#39;s cost (in electricity) compared with the miner&#39;s gain (in
		  Bitcoins accrued by incentivized mining) drives up and incentives a deeper Carbon Footprint.</p>
		  
		  
		  <p class="quote">Fueled by a meteoric rise in the Bitcoin price over the past few months, the power usage of the Bitcoin network has
		  been increasing at a feverish pace. Just a little over three months ago, at the start of November 2017, the Bitcoin
		  Energy Consumption Index was estimating the total electricity consumption of the Bitcoin network to be half of the
		  current amount. On the first day of November, the estimated consumption was equal to 24.3 TWh per year.
		  <sup>1</sup>
		  </p>
		  
		  <p>
		  Carbon Footprint, measured in this way, equates as a double-edged sword: The miner&#39;s electricity costs account for approximately
		  65% of the profit (Bitcoin units&#39; value, measured when mined). So the
		  <i>economic </i>usage means the cheapest available fuel is part of the business model--and it would lead to the cost
		  of the cheapest source of energy: Dirty Coal. At the end of the day, if the
		  <i>currency&#39;s </i>rising value means that more computationally-intensive mining is more and more profitable, then
		  perhaps the other edge looks preferred!
		  </p>
		  
		  <p>1.
		  <a href="
		  https://digiconomist.net/bitcoin-electricity-consumption-surpasses-singapore-portugal
		  " target="_blank"> https://digiconomist.net/bitcoin-electricity-consumption-surpasses-singapore-portugal </a>
		  </p>
		  
		  <p>2.
		  <a href="
		  https://digiconomist.net/bitcoin-energy-consumption
		  " target="_blank"> https://digiconomist.net/bitcoin-energy-consumption </a>
		  </p>
		  
		  </div>
		  
		  <hr /><a href="#martop">
		  <button id="end">TOP</button>
		  </a>
		  <p> &copy; 2018 All Rights Reserved. &nbsp; |
	
		  <a style="color:yellow;text-decoration:none;" href="http://www.thomasmaestas.net">thomasmaestas.net &nbsp; |</a>
		  <a style="color:yellow;text-decoration:none;" href="mailto:thomas@ourdailytech.com"> thomas@ourdailytech.com &nbsp; |</a>
		
		
		  <a title="Contact Information: thomasmaestas.net" href="http://www.thomasmaestas.net/profile.html#contactme"> Contact Information</a>
		</p>  
				  `;
	  } else {
		secretParagraphMAR.style.display = 'none';
	  }
	}
	
	
	function updateSecretParagraphAPR() {
	  if (showSecretAPR) {
		secretParagraphAPR.style.display = 'block';
		secretParagraphAPR.style.fontFamily = 'Roboto';
		secretParagraphAPR.style.opacity = '1';
		secretParagraphAPR.style.color = 'darkslategray';
		secretParagraphAPR.innerHTML = `  
				  <div id="aprtop"></div>
	 
				  <div id="apr-18-04-30" class="                avr 18-03 -24"> 
				  <hr />  
				  <a href="#aprtop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech">Web Dev Affairs</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>   
				  <h6    class="  chapternumber">April 30, 2018<br /> </h6>    
				  <h6    class="dailytitle chapternumber">Data Privacy and Permissions in the Twitter-verse<br />Part II: A Defense of Data Privacy Moderation
				  <br /> </h6>   
				  <p class="firstparagraph">Fitbit and Wearables' Contribution to Health in Society is clear<sup>1</sup>, yet much of the credit is due to increased social, activity-based networks.  And, new features and benefits depend on relaxed data privacy. Given my <a href="#d-18-04-11">April 11th post</a> on the upcoming data privacy changes <i>in response to both Cambridge Analytica scandal <strong>and</strong> E.U.'s long-planned Data Privacy regulations.</i></p>
					
				  <p>So, now is the worst time to clamp down on app permissions, <i>especially as Smart Watches begin to finally make in-roads</i> socially and hardware-wise.  Fitbit's acquirement of Pebble Watch exemplifies the  recent technological hard-ware leap-frogging.  All in all, we can't truly have a socially-connected society without flexible app permissions, so let's hope for fair and flexible data regulations ...  
				  </p>
				  
				  <p class="side">(Side Note: Fitbit's Fashion Wearables' trade-offs betweeen the lighter-weight models versus functional touch-screen. This blogpost bows in reverence to the Apple Watch,<sup>1</sup> whose Series 3 hardly has competitors. I personally reommend the Fitbit Ionic: After three weeks, I'll say the touch accuracy is right on, the graphics are really good, and finally a completely customizable "dashboard" with that stats you want. It's draw-backs are minor, every once in a while the watch enters a "sleep" mode leading to a few-second delay for the screen to power up.)</p>
				  <p class="   cite">1. <a href="https://techcrunch.com/2018/02/13/fitbit-buys-twine-health-in-bid-to-become-a-more-serious-health-care-tool/" target="_blank">https://techcrunch.com/2018/02/13/fitbit-buys-twine-health-in-bid-to-become-a-more-serious-health-care-tool/</a></p>
				  
				  <p class="cite"><a href="https://www.apple.com/apple-watch-series-3/" target="_blank">https://www.apple.com/apple-watch-series-3/</a></p> 
				  </div>
				   
				  
				  
				  <div id="apr-18-04-28" class="                 avr 18-03 -24"> 
				  <hr />  
				  <a href="#aprtop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech">Web Dev Affairs</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>   
				  <h6    class="  chapternumber">April 28-29, 2018<br />
				  Weekend</h6>    
				  <h6    class="dailytitle chapternumber">Data Privacy and Permissions in the Twitter-verse<br />Part I: Conforming to E.U.'s Regulations 
				  <br />
				   </h6>    
					 <p class="firstparagraph" >All over, the new <i>Terms &amp; Conditions in Fine(r) Print</i> are alerting social media users to new compliance to ... new laws? I wrote in my <a href="#d-18-04-16">April 16th post</a> about the upcoming E.U. General Data Privacy Regulations, to which most of social media is unabashedly following. The climate doesn't hurt, but how will our social-media experiences be watered down?  </p>
				  <p>Let's see what Twitter is telling us:<?p><p class="quote">
				  
				  As part of our ongoing commitment to transparency, and in preparation for new data protection laws that take effect next month, we’re updating our Terms of Service and Privacy Policy to empower you to make the best decisions about the information that you share with us. <br />
				  <br />These updates will take effect on May 25, 2018. By using our services on or after that date, you’ll be agreeing to these revisions. You should read the documents in full, but the key updates in our Privacy Policy include:
				  <br /><br />
				  
				  
					 More focus on the controls we offer you over your personal data;
					 <br /><br />
					 More focus on how Twitter shares your public data broadly and instantly, including through our developer tools;
					 <br /><br />
					 More transparency and control over how we share your data with business partners; and
					 <br /><br />
					 More clarity about how we share your data to prevent harm, comply with law, serve the public interest, and keep Twitter safe and welcoming for everyone
					 </p>
				   <p>sounds like the least transparent of transparency documents.</p>   
				  <p class="cite">1.<a href="https://help.twitter.com/en/rules-and-policies/update-privacy-policy" target="_blank">https://help.twitter.com/en/rules-and-policies/update-privacy-policy</a></p> 
				  <p class="cite">2.<a href="https://www.bloomberg.com/news/articles/2018-04-16/facebook-s-zuckerberg-leans-in-to-meet-with-eu-digital-chief" target="_blank">https://www.bloomberg.com/news/articles/2018-04-16/facebook-s-zuckerberg-leans-in-to-meet-with-eu-digital-chief
				  </a> </p> 
				  </div>
				  
				  
				  
				  <div id="apr-18-04-27" class="                avr 18-03 -24"> 
				  <hr />  
				  <a href="#aprtop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech">Web Dev Affairs</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>   
				  <h6    class="  chapternumber">April 27, 2018<br /> </h6>    
				  <h6    class="dailytitle chapternumber">This Time Baby I'll be Bullet-Proof: Innovation for a 5G World
				  <br />
				  --La Roux</h6>   
				  <p class="firstparagraph">T-Mobile's potential acquirement of Sprint--for all of its monopoly overtones--may be a very good thing: We, as a society, are at the doorstep of 5G technology, which will fundamentally change every aspect of life. T-Mobile has always been the little engine that could, but has become a powerhouse since last summer with their 8 billion dollar purchase of low bandwidth, which is specifically <i>best for the ubiquity needed for the 5g Revolution</i><sup>2</sup>.  Although Sprint was always in last, 4th place among major carriers, their network infrastructure <i> and Bandwidth Rights</i> can help T-Mobile catch up with AT&amp;T and Verizon's 5G roll-outs.</p>  
				  <p class="cite">1. <a href="http://www.businessinsider.com/5g-speed-network-lte-2018-1/" target="_blank">http://www.businessinsider.com/5g-speed-network-lte-2018-1</a></p>
				  <p class="cite">2. <a href="https://www.theverge.com/2017/4/13/15291496/tmobile-fcc-incentive-auction-results-8-billion-airwaves-lte" target="_blank">https://www.theverge.com/2017/4/13/15291496/tmobile-fcc-incentive-auction-results-8-billion-airwaves-lte</a></p>
				  </div>
				  
				  
				  
				  
				  
				  
				  
				  <div id="apr-18-04-26" class="              avr 18-03 -24"> 
				  <hr />  
				  <a href="#aprtop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech">Musing Blockchain</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>   
				  <h6    class="  chapternumber">April 26, 2018<br /></h6>    
				  <h6    class="dailytitle chapternumber"> Romaine Lettuce and the Blockchain:<br />
				  Part II. Transparent Accuracy of Data
				  </h6>   
				  <p class="firstparagraph">Sometimes the safest place to be is no place. So, the beauty of the distributed ledgers is that data is no longer in one place, and is rather in no place at all. Where is it? Spread across each node of the blockchain, and any one change in the data updates each node. Equally, the transaction is secured by a cryptographic hash, which is a unique private key.</p>
				  <p>So, what better way to conceptualize it than read it, here's one of mine on the Ethereum network:</p>
				  <p class="quote">
				  status 	0x1 Transaction mined and execution succeed      <span class="green">  <--status   crypto-contract</span><br /><br />
				  from 	0xca35b7d9TOMTOMef540ade6068dfe2f44e8fa733c         <span class="green"> <--this is my address.</span><br /><br />     
				  to 	browser/Tomsfile.sol:tmContract.tmm() 0x692a70d2e424a56d2c6ctomtomd1a86395877b3a <br /><br />
				  gas 	3000000 gas         <br /><br />
				  transaction cost 	32060 gas         <span class="green"> <--pay more, faster transaction validation</span><br /><br /> 
				  execution cost 	10788 gas          <span class="green"> <--contract validation isn't free ...</span><br /><br />
				  hash 	0x4daeec5d9db8055c95c2e4eae074b9944e57b6465tomtom239fb601896525587d5fe<br /><br />
				  input 	0x92277933<br /><br />
				  decoded input 	{}<br /><br />
				  decoded output 	{}<br /><br />
				  logs 	[]<br /><br />
				  value 	0 wei<br /><br />
				  </p>
				  <p>We've all seen the Cisco and IBM blockchain supply-chain ads, but how important can it be? In my <a href="#d-18-02-20">Feb. 20 post</a>, I mention the revolutionary, calibrated <i>freedom and privacy of data</i>, owned and stored with the <i>owner of the data</i>--what a concept! 
				  </p>
				  <p class="quote">
				  Jewelry tracing is becoming increasingly important for business, as the younger customer is "far more skeptical, does more research," said Mark Hanna, chief marketing officer at Richline. "We feel this is an absolute must right now."<br /><br />
				  TrustChain has just completed its first proof-of-concept test, in which gold went from a mine in South Dakota to a refinery in Utah, to a fabricator in Massachusetts that converted the gold into casting nuggets and grains. Those then went to a manufacturer in India that made engagement rings and set diamonds in them. The rings went to a distribution facility and then to Helzberg. UL, which helps companies ensure responsible purchases, monitored the transactions throughout the process. 
				  <p>Some people call it the <i>Trust Chain</i>, but it's also very much a Transparency Chain, too!   </p>
				  
				  
				  <p class="cite">3. <a href="https://www.bloomberg.com/amp/news/articles/2018-04-26/ibm-s-blockchain-tech-to-track-jewels-from-mine-to-retail-stores" target="_blank">https://www.bloomberg.com/amp/news/articles/2018-04-26/ibm-s-blockchain-tech-to-track-jewels-from-mine-to-retail-stores</a></p>
				  
				  
				  </div>
				  
				  
				  
				  <div id="apr-18-04-25" class="             avr 18-03 -24"> 
				  <hr />  
				  <a href="#aprtop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech">Musing Blockchain</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>  
				  <h6    class="  chapternumber">April 25, 2018<br /></h6>    
				  <h6    class="dailytitle chapternumber"> Romaine Lettuce and the Blockchain:<br />
				  Part I. Instant Access to Data  
				  </h6>   
				  <p class="firstparagraph">E. Coli in the Lettuce supply <sup>1</sup> would make any rabbit apprehensive, but finding the source quickly? Downright disheartening.   However, the ever-evolving potential of blockchain technology presents its solution. The blockchain would provide the complete ledger of a vegetable's journey, across all phases and jurisdictions of the journey. Further, all information can be instantly available from any place (actually no location at all), rather than coordinating information from multiple data sources:
				  </p>
				  <p class="quote">The FDA has identified one farm as the source of the whole-head romaine lettuce that sickened several people at a correctional facility in Alaska. However, the agency has not determined where in the supply chain the contamination occurred. The agency is examining all possibilities, including that contamination may have occurred at any point along the growing, harvesting, packaging, and distribution chain before reaching the Alaska correctional facility where it was served.<sup>2</sup>
				  </p> 
				  <p>The beauty of blockchain technology is more than just the crypto-cash or even the new crypto-contracts cropping up in every sector. The distribution of knowledge to all parties, cryptographically sealed and logged from its origin. As it happens, old Watson from IBM fame is taking a crack at it:</p>  
				  
				  <p class="quote"> IBM has also been actively helping form a slew of blockchain-focused companies and industry initiatives around various supply chains. For example, it’s working with companies like retailer Walmart Inc. to trace food products, and earlier this year helped start an effort to track international cargo.<sup>3</sup>
				  </p>
				  <p>The Diamond industry has succeeded already in implementing the blockchain tech to guarantee against blood diamonds.<sup>4</sup> 
				  <p class="cite">1. <a href="https://www.seattletimes.com/seattle-news/health/wa-state-health-officials-5-people-sick-from-romaine-lettuce-e-coli-outbreak/" target="_blank">https://www.seattletimes.com/seattle-news/health/wa-state-health-officials-5-people-sick-from-romaine-lettuce-e-coli-outbreak/</a></p>
				  
				  <p class="cite">2. <a href="https://www.cdc.gov/ecoli/2018/o157h7-04-18/index.html" target="_blank">https://www.cdc.gov/ecoli/2018/o157h7-04-18/index.html</a></p>
				  
				  <p class="cite">3. <a href="https://www.bloomberg.com/amp/news/articles/2018-04-26/ibm-s-blockchain-tech-to-track-jewels-from-mine-to-retail-stores" target="_blank">https://www.bloomberg.com/amp/news/articles/2018-04-26/ibm-s-blockchain-tech-to-track-jewels-from-mine-to-retail-stores</a></p> 
				  </div>
				  
				  <div id="apr-18-04-24" class="              avr 18-03 -24"> <hr />  
				  <a href="#aprtop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech">Sociology Tomorrow!</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>  
				  <h6    class="  chapternumber">April 24, 2018<br />  </h6>    
				  <h6    class="dailytitle chapternumber"> Westworld
				  </h6>   
				  <p><small>No Spoilers ...</small></p>
				  <p class="firstparagraph">Westworld's second season premiered this week to cult-like fanfare.<sup>1</sup> Much of the HBO's storyline follows usual near-future AI potential, but brings up moral issues about what separates humankind from the rest of the animal kingdom. The premise of the show, and the current state of A.I., is instinctual learning and behavior of A.I.--i.e. imitating animal-behavior, but not human. </p>
				  <p>I had the good luck of spending the Fall of 2016 in the Silicon Valley of A.I. technology, which is Montr&eacute;al, Qu&eacute;bec (For example, UdeM was awarded $100 million in research money from Facebook). Though I was there for a Sociology PhD, I still got to get involved like any technology groupie would...  The rock-star out there is Universit&eacute de Montr&eacute;al's Dr. Yoshua Bengio,<sup>3</sup> who explains the consciousness elements of A.I, and how those compare with our own representations:
				  </p>
				  <p class="quote">
				  With supervised learning, humans provide the high-level concepts that the computer learns, which can be tedious and limits the ability of computers to discover things by themselves. Unsupervised learning, or what we call reinforcement learning, is when the learner is not merely passively observing the world, or how humans do things, but interacts with the environment and gets feedback. Humans are good at this. Combining unsupervised deep learning and reinforcement learning is one of the things that I am working on.<sup>2</sup>
				  </p> 
				  <p>So, here we see how Yoshua Bengio  explains that <i>building of meaning, symbolic representation as the key impediment</i>. To get around this, representations are <i>factorialized</i>, which is a clean way of saying multiple levels/dimensions of classification trees:</p>
				  <p class="quote">For more than a decade, my research has focused on the notion of learning better representations, which is the heart of deep learning, in particular, representations that have a property called disentangled. Disentangled separates the different concepts and different explanations - we call them factors - that explain the data, that explain what the agent sees around it, and that explain how the agent patrols the world. Disentangled captures some of the causality that explains what we are seeing and what the computer is seeing.<sup>2</sup>
				  </p>
				  <p>
				  I think it's exciting subject matter, and perhaps many would be less apprehensive if they thought of A.I. as achieving the behavior and  <i>predictable mind of pets</i>.  Pets and service pets can be a reassuring thought--even for A.I. pessimists like Elon Musk. Pets... Who doesn't imagine a shaggy Saint Bernard, with a first-aid kit and a flask arriving to the rescue on a snowy Alpine mountain slope? I can imagine a mechanical Saint Bernard, and with that in mind I would love to visit Westworld--albeit not without a white hat ... 
				  <p class="cite">1. <a href="https://www.hbo.com/westworld" target="_blank" >https://www.hbo.com/westworld</a>
				  </p>
				  
				  <p class="cite">2. <a href="http://www.iro.umontreal.ca/~bengioy/yoshua_en/index.html" target="_blank" >http://www.iro.umontreal.ca/~bengioy/yoshua_en/index.html</a>
				  </p>
				  
				  <p class="cite">3. <a href="https://www.forbes.com/sites/peterhigh/2017/11/06/why-montreal-has-emerged-as-an-artificial-intelligence-powerhouse/#7435a66123bd" target="_blank" >https://www.forbes.com/sites/peterhigh/2017/11/06/why-montreal-has-emerged-as-an-artificial-intelligence-powerhouse/#7435a66123bd</a>
				  </p>
				  
				  </div>
				  
				  
				  <div id="apr-18-04-23" class=" avr 18-03 -24"> 
				  <hr />  
				  <a href="#aprtop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech">Web Dev Affairs</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>  
				  <h6    class="  chapternumber">April 23, 2018<br />  </h6>  
				  <h6    class="dailytitle chapternumber">
					The Bright New Horizon for Tech Jobs
				  </h6>   
				  <p class="firstparagraph">The<i> burgeoning Tech Job Market</i> has been one of my favorite blog topics. Two months ago, my <a href="#d-18-02-23">Feb. 23rd blogpost</a> and again on <a href="#d-18-03-08">March 8th</a> I mentioned 1.4 million new tech jobs, 20% growth year-over-year. And so, yours truly has decided to enter into this market after a post-graduate period of contracting and free-lance work. Let's face it, there's no substitute for the stability and the fixed schedule, plus the coffee-machine conversations are never short of endearing! </p>
				  
				  
				  <p>So far on day 2 (Friday, the 21st was my ceremonial first day of "putting myself out there"). I've thought to start slow, while I gauge the territory, but Indeed and Linkdin are always safe bets to begin with. All in all, my general take is that this new job front, with hundreds of thousands of jobs month-over-month is for everyone. Most positions offer 9-12 weeeks training -- who ever said changing careers had to be shouldered on our own? HR is there! </p>
				  <p>As I am a night-blogger, therefore my new position--where and whichever it will be, won't interfere with my blogging--after all, I have truly enjoyed watching my readership grow, month-by-month ... so, thank you, dear tech readers. As such, perhaps along the way I can lend a view from the job-front, and any new trends I observe.</p>
				  <p>Examples aren't hard to find. I've noticed that since the last time I've checked out the job market, the pre-assessment tests are a bit more cognitive than previous years, which is good for strong test-takers--especially those that love to calculate the "arrival times of two separate trains leaving the same station at two different rates of speed ....". 50 questions in 15 minutes makes for a nice adrenaline rush--on par with a short run!  </p>
				  </div>
				  
				  <div id="apr-18-04-21" class="            avr 18-03 -24"> 
				  <hr />  
				  <a href="#aprtop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech">Sociology Tomorrow!</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>  
				  <h6    class="  chapternumber">April 21-22, 2018<br />
				  Weekend  </h6>   
				  
				  <h6    class="dailytitle chapternumber">
					Earth needs Technology as much as Tech needs the Earth
				  </h6>   
				  <p class="firstparagraph">Palladium, micrograms of Gold and Silver, and of course, the yttrium, the lanthanum, without forgetting good old terbium, then a dusting of neodymium, a dash of gadolinium and and finally a sprinkle of praseodymium. The ingredients for a typical iphone are not a luxury, but a <i>sine qua non</i> necessity, while the irreplaceable, increasingly difficult-to-mine metal supply <i>reminds us we do have a Mother to heed to</i>.<sup>1</sup>  
				  </p>
				  <p>Tech's relationship with the Earth is very symbiotic, in that Earth's problems are increasingly dependent on Tech's promise for scalable, innovative solutions beyond Humankind's reach. So, much like the clean-energy infrastructure will depend on fossil fuels to be built, tech hardware will depend on more difficult mining. But to what end? With growing national and corporate competitiveness on a more crowded, more connected globe, the race is on to achieve sustainability with both.   </p><p>
				  But the story isn't about Tech here on Earth Day - the story is the Earth's, and why the Earth's Superman, Technology, will come down from the sky to save the day ...
				  </p>
				  <img class="zoom" src="./dist/img/metal.jpg" width="350px" />  <br />
				  <p class="cite">2. <a href="http://www.bbc.com/future/story/20161017-your-old-phone-is-full-of-precious-metals" target="blank">http://www.bbc.com/future/story/20161017-your-old-phone-is-full-of-precious-metals</a>
				  </p>
				  
				  </div>
				  
				  
				  
				  <div id="apr-18-04-20" class="         caption-pre   avr 18-03 -24"> 
				  <hr />  
				  <a href="#aprtop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech">Musing Blockchain</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>  
				  <h6    class="  chapternumber">April 20, 2018<br />  </h6>   
				  
				  <h6    class="dailytitle chapternumber">
					Computing Arts and Innovation, Part II:
					<br />Constraints of Distributed Ledger Technology
				  </h6>   
				  <p class="firstparagraph">Speed versus scalability. Security versus user-experience. Stability versus complexity. Ethereum, along with other blockchain developers, inhabit a virtual reality, a reality in which application uses and perils are not fully conceivable. Traditional app-developers, long habituated to the centralized server and popular usage--not to mention any regulation--to know the lines in the sand, which constrain a developer. The decentralized app (DAPP) developers have no such luxury, except to abide by a certain golden rule; a single rule that sustains crypto-tech's very existence: The Rule of Trust, without which blockchain tech has nothing to offer. 
				  </p>
				  
				  <p>The very premise of designing distributed ledger platforms hinges on placing a platform's cryptographic, algorthmic design at the center, the link between every user. This trust, <i>built on mathematical proofs,</i> ensures peer-to-peer transactions in which  <i>neither party needs to trust the counter-party, nor any third-party.</i>We trust in the cryptography that our transaction will be fulfilled: In Math We Trust. </p> <br />
				  
				  </div>
				  
				  
				  <div id="apr-18-04-19" class="           avr 18-03 -24"> 
				  <hr />  
				  <a href="#aprtop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech web">Web Dev Affairs</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>  
				  <h6    class="  chapternumber">April 19, 2018<br />  </h6>   
				  <h6    class="dailytitle chapternumber">
					Computing Arts and Innovation, Part I:
					<br />Constraints of App Development
				  </h6>  
				   
				  <p class="quote">“I think great artists and great engineers are similar, in that they both have a desire to express themselves. In fact some of the best people working on the original Mac were poets and musicians on the side.” <sup>1</sup><br /> – Steve Jobs</p><br />
				  <p class="firstparagraph">Words, Sentences, Paragraphs. Variables, Functions, Modules.  With so many languages used for different purposes by different organizations, syntax is more than 4-space indents, variable name-spaces, and other formalities. Today, the variety of coding languages and scripts can appear more complicated than is/+*- the case: After all, all computer <i>languages boil down to the same primary tasks: for &amp; while loops, if-then statements, variable declarations, scope considerations, etc ...</i>     
				  </p>
				  <p>So what am I getting at? Coding innovation is an art form that surpasses science and knowledge. For example,   coding practices improve with clarity, simplicity, modularity, and so on... but is there an authoritative <i>school of thought</i> on this art? Well, in the Python world, all eyes turn to the Zen of Python, and some say other languages should emulate its philosophy, so let's hear it:</p>
				  <p class="quote">
				  <strong>The Zen of Python</strong><br /><br />
				  
				  Beautiful is better than ugly.<br /><br />
				  
				  Explicit is better than implicit.<br /> <br />
				  
				  Simple is better than complex.<br /> <br />
				  
				  Complex is better than complicated.<br /> <br />
				  
				  Flat is better than nested.<br /> <br />
				  
				  Sparse is better than dense.<br /> <br />
				  
				  Readability counts.<br /> <br />
				  
				  Special cases aren't special enough to break the rules.<br /><br />
				  
				  Although practicality beats purity.<br /><br />
				  
				  Errors should never pass silently.<br /><br />
				  
				  Unless explicitly silenced.<br /><br />
				  
				  In the face of ambiguity, refuse the temptation to guess.<br /><br />
				  
				  There should be one-- and preferably only one --obvious way to do it.<br /><br />
				  
				  Although that way may not be obvious at first unless you're Dutch.<br /><br />
				  
				  Now is better than never.<br />
				  <br />
				  Although never is often better than *right* now.<br /><br />
				  
				  If the implementation is hard to explain, it's a bad idea.<br /><br />
				  
				  If the implementation is easy to explain, it may be a good idea.<br /><br />
				  
				  Namespaces are one honking great idea -- let's do more of those! <sup>2</sup><br />
				  
				  <br />
				  --Pythoneer Tim Peters
				  </p>
				  <p>I get it, good coding is more than intuitive art, it's walking the high road without regard for shortcuts. And I can see that <i>in uncharted waters, intuition has to be constrained by sound reason.</i> And who hasn't been burned by artful exploration, fancy coding, and far-fetched architectures? So where does the balance lie? Again we must turn to Steve Jobs on the "intersection of the humanities and science,": </p>
				  <p class="quote">There are a lot of people innovating, and that's not the main distinction of my career. The reason Apple resonates with people is that there's a deep current of humanity in our innovation. I think great artists and great engineers are simi.ar in that they both have a desire to express themselves. In fact some of the best people working on the original Mac were poets and musicans on the side. In the seventies computers became a way for people to express their creativity. Great artists like Leonardo da Vinci and Michelangelo were also great art science. Michelangelo knew a lot about how to quarry stone, not just how to be a sculptor." <sup>1</sup><br />--Steve Jobs
				  <p class="continue">I could not imagine a computing world were it not for the personalization that Apple introduced to the world, to us all. After all, I recall I was first transfixed in 1984, there I was a seven-year-old staring into the bright green letters   of my   Apple IIe ... </p>
				  <p>So, in this era of the algorithmic wild-west and impending regulations on data privacy, inter-app permissions, coupled with data breaches every week, how might regulations avoid stifling innovation? Steve Jobs didn't have rules as much as Mark Zuckerberg didn't have any rules. So, it's a relief that Zuckerberg, with intimate knowledge of innovation, can set his teams to work with Congress going forward, especially as Facebook conforms to the E.U.'s <i>General Data Privacy Regulations (GDPR) implementation this May.</i> I for one hope that freedom for creative innovation will stay alive, even in the face of   growing bureaucracy in the web.   
				  <p class="cite">1. <a href="https://books.google.com/books?id=cf_2PBPP-rEC&printsec=frontcover" target="blank">Isaacson, Walter. Steve jobs. JC Lattès, 2011.</a>
				  </p>
				  <p class="cite">2. <a href="https://www.python.org/dev/peps/pep-0020/" target="blank">https://www.python.org/dev/peps/pep-0020/</a>
				  </p>
				  </div>
				  
				  
				  <div id="apr-18-04-18" class="           avr 18-03 -24"> 
				  <hr />  
				  <a href="#aprtop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech bc">Musing Blockchain</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>  
				  <h6    class="  chapternumber">April 18, 2018<br />  </h6>   
				  <h6    class="dailytitle chapternumber">Blockchain Types and Trade-offs
				  </h6>  
				  
				  <p class="firstparagraph">Bitcoin's rise to prominence, the mystery of Satoshi Nakamoto's identity--i.e., author of <a href="dist/docs/bitcoinWhitePaper.pdf" target="_blank"> the original Bitcoin White Paper</a>, and the platform's reliability (outside of value fluctuations) all add to the mystique of the crypto-currency.  Yet,     new advances and types, i.e. "groupings" of blockchain technology are not necessarily "replacing" their predecessors, but rather filling different blockchain needs; Needs that include speed of transactions, truly public distributed ledgers, safety from forking and DDOS attacks.  Since 2008,   groups of competing platforms follow a timeline, but should not be thought of as a cyclical evolution but rather growing tree branches that form "groups".  Bitcoin, Litecoin are first generation, while Ethereum and Ripple are 2nd generation with crypto-contract capability, and finally Iota and Swirlds' Hedera Hashgraph represent   3rd generation <i>directed-acyclic-graphs (DAG), whose transaction speed actually  increases</i> with number of nodes.
				  </p>
				  <p>Each of these groupings shouldn't be seen as making the previous design obselete: They   serve different purposes. Bitcoin can never serve micro-transactions and the micro-economy because it can only handle 6 transactions per second (TPS), while Ethereum can handle 12 or so. However, micro-transaction industries require TPS in the hundreds of thousands! Only the 3rd gen  crypto-currency architecture   achieves TPS <i>ad infinitum</i> because it's scalability increases with size. The catch? DAG's are necessarily private entities, rather than the original two generations that are by nature public, yet can be privatized. 3rd generation DAGs are the opposite: They are by default private, and cannot truly be distributed without management. Further, <i>Swirlds Hashgraph has patented their source code, which contradicts many principles of blockchain technology</i>, beginning with core tenets  of the original crypto-currency white paper, published in October 2008. For history
				  's sake, here's a quick view of the Bitcoin paper's abstract:</p>
				  <p class="quote"><strong>Abstract.</strong> A purely peer-to-peer version of electronic cash would allow online payments to be sent directly from one party to another without going through a financial institution. Digital signatures provide part of the solution, but the main benefits are lost if a trusted third party is still required to prevent double-spending. We propose a solution to the double-spending problem using a peer-to-peer network. The network timestamps transactions by hashing them into an ongoing chain of hash-based proof-of-work, forming a record that cannot be changed without redoing the proof-of-work, forming a record that cannot be changed without redoing the proof-of-work. The longest chain not only serves as proof of the sequence of events witnessed, but proof that it came from the largest pool of CPU power. As long as a majority of CPU power is controlled byi nodes that are not cooperating to attack the network, they'll generate the longest chain and outpace attackers. The network itself requires minimal structure. Messages are broadcast on a best effort basis, and nodes can leave and rejoin the network at will, accepting the longest proof-of-work chain as proof of what happened while they were gone.<sup>1</sup></p>
				  
				  <p>Irrespective of crypto-currency or crypto-contract, there seems to be a different kind of jump from 2nd generation to 3rd generation blockchain, rather than a progression. Research needed to fork into a different direction is because of the need for instantaneous, ordered transactions, which can never be provided by a blockchain design which "syncs" every 5 to 10 minutes. </p>
				  <p> So, what is this 3rd generation design? Instead of a singular block encapsulated in linked cryptographic, historical ledger blocks, hashgraph uses a "tangle" of one-way (directed-acyclic) network connections. This means that speed increases with the number of nodes, overcoming the Bitcoin micro-transaction problem. <i>In sum, near-instantaneous updates for financial, betting, gaming and social-media data needs are solved by the  third-generation DAG</i>, while longer-term and truly distributed blockchain needs will always be the terrain of first and second generation blockchain technology. So, given that Swirlds' Hedera Hashgraph will be unveiling their platform next month,   blockchain critics and enthusiasts can and should read between the lines, er, I mean-- read  between the nodes ...</p><br />
				  <p class="cite">0.  Topic addressed in <a href="#d-18-04-02">April 2nd blogpost</a></p>
				  <p class="cite">1.<a href="https://bitcoin.org/bitcoin.pdf" target="_blank">https://bitcoin.org/bitcoin.pdf
				  </a> </p>
				  <p class="cite">2.<a href="http://www.the-blockchain.com/2018/03/20/hedera-plans-speedier-safer-more-democratic-blockchain-alternative-hashgraph/" target="_blank">http://www.the-blockchain.com/2018/03/20/hedera-plans-speedier-safer-more-democratic-blockchain-alternative-hashgraph/
				  </a> </p>
				  <p class="cite">3. <a href="https://s3.amazonaws.com/hedera-hashgraph/hh-whitepaper-v1.0-180313.pdf" target="_blank">https://s3.amazonaws.com/hedera-hashgraph/hh-whitepaper-v1.0-180313.pdf</a> </p>
				  </div>
				  
				  
				  <div id="apr-18-04-17" class="           avr 18-03 -24"> 
				  <hr />  
				  <a href="#aprtop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech web">Web Dev Affairs</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>  
				  <h6    class="  chapternumber">April 17, 2018<br />  </h6>   
				  <h6    class="dailytitle chapternumber">Dictionaries and the Joys of Abstraction
				  </h6>  
				  <p class="firstparagraph">Dictionaries and libraries place the programmer into a once-in-a-lifetime opportunity to ride the lightning of the open-source community. Volunteers and corporate sponsors take the credit for the enormous effort making a  near limitless selection of functions, dictionaries and modules for languages such as  JavaScript and Python programming.<sup>1</sup> Today, a programmer can   put together JavaScript Components and Modules with less thought about syntactical logic, and more consideration for the problem at hand. 
				  </p>  
				  <p class="quote">Each significant piece of functionality in a program should be implemented in just one place in the source code. Where similar functions are carried out by distinct pieces of code, it is generally beneficial to combine them into one by abstracting out the varying parts.</br ></br >
				  --Benjamin C. Pierce</p>
				  <p>There are a few hundred thousand packages in the JavaScript <i> Node.js package ecosystem</i>, with billions of downloads per month. This unprecedented global collaboration, sharing open-source code into the community, means a more humanized, higher-level programming tasks-- a boon for the many coding-converts joining the tech economy. Such optimism means that problem-solving is fast and flexible, especially in the world of Stack Overflow--another phenomenon of global collaboration.
				  </p>
				  <p class="quote">[Abstraction] tries to factor out details from a common pattern so that programmers can work close to the level of human thought, leaving out details which matter in practice, but are immaterial to the problem being solved.</p>
				  
				  <p class="quote">The effective exploitation of the powers of <i>abstraction</i> must be regarded as one of the most vital activities of a   programmer ...<sup>2</sup> <br /><br />
				  --Edsger W. Dijkstra</p>
				  <p>These words mean programmers can do what they do best, as much as   what the client-user does best, too: think and problem-solve like a human, rather than a robot. </p>
				  <p class="cite">1.<a href="https://nodesource.com/blog/npm-is-massive/" target="_blank">https://nodesource.com/blog/npm-is-massive/
				  </a> </p>
				  
				  <p class="cite">2.<a href="http://www.cs.utexas.edu/~EWD/" target="_blank">http://www.cs.utexas.edu/~EWD/
				  </a> </p>  
				  </div>
				  
				  
				  <div id="apr-18-04-16" class="           avr 18-03 -24"> 
				  <hr />  
				  <a href="#aprtop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech web">Web Dev Affairs</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>  
				  <h6    class="  chapternumber">April 16, 2018<br />  </h6>   
				  <h6    class="dailytitle chapternumber">Zuckerberg's "Invitation" to the European Union Kindly Declined:<br />
				  How the 28-nation European Union's Privacy Regulations affect Facebook, and eventually us
				  </h6>  
				  <p class="firstparagraph">E.U.'s Parliament has   invited Zuckerberg to speak with member-states in Brussels to discuss both the upcoming <i>General Data Protection Regulation (GDPR)</i> new rules, along with the 2.7 Europeans, whose data also was sold to Cambridge Analytica.<sup>1</sup> Not exactly an invitation to the Ball...
				  </p>
				  <p class="quote">The Brussels-based commission said [European Commission Vice-President] Ansip would also meet with Google Chief Executive Officer Sundar Pichai, Twitter General Counsel Sean Edgett and Netflix General Counsel David Hyman in individual meetings to talk about data protection, online privacy, illegal content, disinformation campaigns, digital copyright and artificial intelligence.<sup>2</sup></p> 
				  <p>These are more than talking points, as they are already codified within the GDPR and to implemented next month--compliance with European law will be a mad dash for developers.</p>
				  <p> This predicament illuminates a smaller world, along with increasing complications of globalization, thanks to tech--for better or worse. Ultimately, Facebook, Google, and other tech giants will need to overhaul their permissioning code to abide by European law, but after last week's Congressional appearence, it's hard not to wonder if pan-industry data privacy adjustments will lead to a new <i>de facto regulation</i>, based on tech culture instead of politicians and legislators ...  
				  </p>
				  <p class="cite">1.<a href="https://www.washingtonexaminer.com/policy/technology/eu-steps-up-pressure-on-mark-zuckerberg-to-testify-about-facebook-privacy" target="_blank">https://www.washingtonexaminer.com/policy/technology/eu-steps-up-pressure-on-mark-zuckerberg-to-testify-about-facebook-privacy
				  </a> </p> 
				  <p class="cite">2.<a href="https://www.bloomberg.com/news/articles/2018-04-16/facebook-s-zuckerberg-leans-in-to-meet-with-eu-digital-chief" target="_blank">https://www.bloomberg.com/news/articles/2018-04-16/facebook-s-zuckerberg-leans-in-to-meet-with-eu-digital-chief
				  </a> </p> 
				  </div>
				  
				  <div id="apr-18-04-14" class="           avr 18-03 -24"> 
				  <hr />  
				  <a href="#aprtop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech soc">Sociology Tomorrow!</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>  
				  <h6    class="  chapternumber">April 14-15, 2018<br /> 
				  Weekend</h6>   
				  <h6    class="dailytitle chapternumber">Clash of the Brick &amp; Mortars against Online Stores
				  </h6>  
				  <p class="firstparagraph">This week, the Supreme Court   revisits its 1992 decision not requiring state sales taxes for online purchases.<sup>1</sup> Although big-box stores like Amazon, Walmart, etc. <i>do</i> pay state taxes among the 45 states requiring it, small- and medium-sized retailers do not need to collect sales taxes in any state where they do not have physical presence, also known as "nexus." But, beginning this Tuesday, the free ride may come to an  end; this includes small retailers that comprise half of Amazon's 3rd-party online sales.
				  </p>
				  <p class="quote">  
				  
				  A reversal could mean that all online retailers must collect sales tax everywhere. It's an issue that brick-and-mortar retailers insist will provide a level playing field with online competitors, and help to provide state and local governments with the tax revenue they deserve.<sup>2</sup></p>
				  <p> Livelihoods hang in the balance, so whatever the gavel settles on, let's hope for the best! The Blockbuster-ization of so many brick-and-mortars seems to claim a new victim every month--recently Toys 'R Us  meeting its demise.<sup>3</sup> So, with as many that have disappeared, big and small-, its a curiosity if maybe Tuesday breathes life into the boarded store-fronts across America. I think others share my view that shopping is more than shiny packaging at the doorstep: it's much more the ceremony and gala in the store - a  real shared moment with strangers, acquaintances and loved ones that makes for better packaging, a package embellished with a story.   
				  </p>
				  <p class="cite">1.<a href="https://www.forbes.com/sites/janetwburns/2018/04/15/supreme-court-decision-could-bring-sales-tax-to-more-online-shopping/#2a0ea38f3daf" target="_blank">https://www.forbes.com/sites/janetwburns/2018/04/15/supreme-court-decision-could-bring-sales-tax-to-more-online-shopping/#2a0ea38f3daf
				  </a> </p>
				  <p class="cite">2.<a href="http://money.cnn.com/2018/04/15/technology/online-purchases-sales-taxes-supreme-court/index.html" target="_blank">http://money.cnn.com/2018/04/15/technology/online-purchases-sales-taxes-supreme-court/index.html
				  </a> </p>
				  <p class="cite">3.<a href="https://www.washingtonpost.com/news/business/wp/2018/04/13/this-billionaire-toy-executive-has-a-last-ditch-mission-to-save-toys-r-us-before-its-too-late/?noredirect=on&utm_term=.b3201ad77891" target="_blank">https://www.washingtonpost.com/news/business/wp/2018/04/13/this-billionaire-toy-executive-has-a-last-ditch-mission-to-save-toys-r-us-before-its-too-late/?noredirect=on&utm_term=.b3201ad77891
				  </a> </p> 
				  </div>
				  
				  
				  <div id="apr-18-04-13" class="           avr 18-03 -24"> 
				  <hr /> 
				  <a href="#aprtop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4> 
				  
				  <h5 class="  subdailytech bc">Musing Blockchain</h5> 
				  
				  <p class="  author">by Thomas Maestas, MA</p> 
				  
				  <h6    class="  chapternumber">April 13, 2018<br />
				  
				  
				  
				  </h6>  
				  
				  <h6    class="dailytitle chapternumber"> 
				  Bitcoins &amp; Browsers: A Glance at Bitcoin Distributed Mining  
				  </h6> 
				  
				  <p class="firstparagraph">For all the clamor about Bitcoin's carbon footprint, who doesn't love the sound of money?  And, for all the pitfalls of Iota and the ever-evolving Ethereum (and ever-present threat of forking), Bitcoin stands true among the crypto-currency platforms. Keeping it Simple,   the very limited, non-crypto-contract may just be Bitcoin's virtue. In a rocky world, <i>a plain, no-frills crypto-currency with stability</i> is incomparable to crypto-contract powers, that are not fully stable, like Ethereum and Iota.  </p>
				  <p>So, it's living the dream, but must it be so cost-intensive? Maybe, Maybe not, but where does the future lie for all that hardware? Where does the browser fit into this? First, what's going on under the hood: Note this article is older, but accurate in explanation--except for references to Bitcoin's value! </p>  
				  
				  <p class="quote">New bitcoins are created roughly every 10 minutes in batches of 25 coins, with each coin worth around $730 at current rates. [A typical home-] computer ... is racing thousands of others to unlock and claim the next batch.</p>
				  <p class="quote">
				  Let’s start with what it’s not doing.  
				  Your computer is not blasting through the cavernous depths of the internet in search of digital ore that can be fashioned into bitcoin bullion. There is no ore, and bitcoin mining doesn’t involve extracting or smelting anything. It’s called mining only because the people who do it are the ones who get new bitcoins, and because bitcoin is a finite resource liberated in small amounts over time, like gold, or anything else that is mined. (The size of each batch of coins drops by half roughly every four years, and around 2140, it will be cut to zero, capping the total number of bitcoins in circulation at 21 million.) But the analogy ends there.
				  </p><p class="quote">
				  What bitcoin miners actually do could be better described as competitive bookkeeping. Miners build and maintain a gigantic public ledger containing a record of every bitcoin transaction in history. Every time somebody wants to send bitcoins to somebody else, the transfer has to be validated by miners: They check the ledger to make sure the sender isn’t transferring money she doesn’t have. If the transfer checks out, miners add it to the ledger. Finally, to protect that ledger from getting hacked, miners seal it behind layers and layers of computational work—too much for a would-be fraudster to possibly complete.<sup>1</sup>
				  </p>
				  
				  <p>So all of this hard work <i>can be distributed</i> across browsers, which improves its energy-expensive plight. I wouldn't recommend running the demo in the article link below as it may overheat your device--it had my fan running double-time. But the internals are using JavaScript code for the math. Here's a look under the hood, and it's nice to see the role of <i>JavaScript graphics library, called D3JS, (Data Driven Documents)</i> playing a central role. So, below you see the browser accepting the SHA256 Hash along with the Bitcoin Owner's Address, and the JavaScript in the browser passes off calculations to the C++ running the JavaScript V8 engine on your computer. </p>
				  <img src="./dist/img/miningBlockchainD3.PNG" class="zoom" width="450px" />
				  <p>And so, what does it mean to mine Bitcoins across browsers in a distributed fashion? It is similar to the same concept as Ethereum's direction (or at least idealized by its architect, Vitalik Buterin), in running the Ethereum Virtual Machine blockchain across all the browsers that download its GETH software. Nonetheless, here's a succinct explanation of the browser's role,again from Quartz: </p>
				  <p class="quote">Mining’s ultimate purpose is to prevent people from double-spending bitcoins. But it also solves another problem. It distributes new bitcoins in a relatively fair way—only those people who dedicate some effort to making bitcoin work get to enjoy the coins as they are created.
				  But because mining is a competitive enterprise, miners have come up with ways to gain an edge. One obvious way is by pooling resources.<br /><br />
				  
				  
				  Your machine, right now, is actually working as part of a bitcoin mining collective that shares out the computational load. Your computer is not trying to solve the block, at least not immediately. It is chipping away at a cryptographic problem, using the input at the top of the screen and combining it with a nonce [run-time, generated random number calculated only once, then discarded], then taking the hash to try to find a solution. Solving that problem is a lot easier than solving the block itself, but doing so gets the pool closer to finding a winning nonce for the block. And the pool pays its members in bitcoins for every one of these easier problems they solve.</p>
				  <p>In practice, distributed mining pays off quite well   for the owners of that address. My blogposts on <a href="# <a href="#d-18-02-28">February 26th  </a> and <a href="#d-18-02-28">Feb. 28th about blockchain sustainability</a> paint a less rosy picture of tying the currency value to the cost of energy, but multiple solutions and fixes exist to distribute the energy load to laptops on clean renewables, the mining cooperative way ... after all, who ever said money had to be so expensive? </a> 
				  <p class="cite">1.<a href="https://qz.com/154877/by-reading-this-page-you-are-mining-bitcoins/" target="_blank">https://qz.com/154877/by-reading-this-page-you-are-mining-bitcoins/
				  </a> (The article link is harmless, but wouldn't recommend running it if low on batteries--it doubled the fan speed)</p>  	
				  
				  </div> 
				  
				  
				  
				  <div id="apr-18-04-12" class="           avr 18-03 -24">
					<hr />
					 
					<a href="#aprtop"><button>Top</button></a>
					 &nbsp;
					<h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4> 
					<h5 class="  subdailytech web">Web Dev Affairs</h5> 
					<p class="  author">by Thomas Maestas, MA</p> 
					<h6    class="  chapternumber">April 12, 2018<br />
				  
					</h6> 
				  <h6    class="dailytitle chapternumber">Algorithms and A.I.<br />Scalability &amp; Costs   of Data Privacy Policies
				  </h6> 
					<p class="firstparagraph">  Data privacy regulation's challenge begins with five million apps between Apple and Android stores. Countless vulnerabilities, not to mention different standards and languages across the app world. <i>Like all Tech problems,</i>scalability requires Tech problem-solving--</i>in this case implying artificial intelligence.  About A.I., Zuckerberg remarks:</p>  
					<p class="quote"> There are some really nuanced questions, though, about how to regulate [data] which I think are extremely interesting intellectually. So the biggest one that I’ve been thinking about is this question of: To what extent should companies have a responsibility to use AI tools to kind of self-regulate content?<sup>1</sup>
					</p>
					<p>However such musing goes, the European Union's May 14th implementation takes a <i>direct stand against the concept of algorithm use with data</i>, which begs the A.I. question again. </p>
					<p class="quote">The European law gives individuals the right not to be subject to completely automated  decisions which significantly affect them. These decisions could include credit algorithms that use an individual’s data to decide whether a bank should grant him or her a loan.  
						Privacy International said the clause on automated decisions could allow consumers to challenge Facebook practices like political advertising, which can be sent to users based on algorithms, because the ads are meant to sway users’ votes.<sup>2</sup></p>
					<p>I think the E.U. data policy model is intelligent - who would have thought to re-humanize our personal data   by taking it away from algorithms, without our permission. I like that, after all, who likes to be unknowingly judged? Least of all by a robot!
				  
					</p>
						<p class="cite">1.<a href="https://www.wired.com/story/mark-zuckerberg-talks-to-wired-about-facebooks-privacy-problem" target="_blank">https://www.wired.com/story/mark-zuckerberg-talks-to-wired-about-facebooks-privacy-problem
					</a></p>  	
					<p class="cite">3. <a href="https://www.nytimes.com/2018/04/08/technology/a-tough-task-for-facebook-european-type-privacy-for-all.html?ribbon-ad-idx=2&rref=technology&module=Ribbon&version=context&region=Header&action=click&contentCollection=Technology&pgtype=article" target="_blank">https://www.nytimes.com/2018/04/08/technology/a-tough-task-for-facebook-european-type-privacy-for-all.html?ribbon-ad-idx=2&rref=technology&module=Ribbon&version=context&region=Header&action=click&contentCollection=Technology&pgtype=article
					</a> </p>  
				  </div>
				  
				  
				  
				  <div id="apr-18-04-11" class="         avr 18-03 -24">
				  <hr />
				   
				  <a href="#aprtop"><button>Top</button></a>
				   &nbsp;
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4> 
				  <h5 class="  subdailytech web">Web Dev Affairs</h5> 
				  <p class="  author">by Thomas Maestas, MA</p> 
				  <h6    class="  chapternumber">April 11, 2018<br />
				  
				  </h6> 
				  <h6    class="dailytitle chapternumber">When a Pickpocket is Pickpocketed:<br />Part III. The Path toward Sound Data Privacy Policy
				  </h6> 
				  <p class="firstparagraph">Day two of Congressional hearings over Facebook's Data Privacy and Protections  were better articulated than the first day. Important dialogue surrounded primarily   two data privacy topics: First, financial transparency surrounding ads and political ads based on the <i>Honest Ads Act</i>, for which Zuckerberg pledged support<sup>1</sup>. 
				  </p>
				  <p>Second, and   more far-reaching, discussion of the <i>Browser Act</i> also was raised by several House members. While responding to the Act's sponsor, Marsha Blackburn of Tennessee, Zuckerberg expressed interest in working together. This bill is not well known, but aims to set prudent, consistent guidelines of privacy in the hands of the consumer. </p>
				  <p class="quote"> [Blackburn's] new bill targets the full spectrum of the internet, including web giants like Amazon and Google. In Blackburn’s words, it moves the government “to a posture where we have one regulator, one set of rules [and] everybody knows who’s in charge,” she told Recode.<sup>3</sup></p>
				  <p>So, however the power struggle goes, a <i>shared technology lexicon</i> clarifies that shades of meaning make enormous difference, depending on "what" an entity is--whether a technology is a Platform as a Service  versus media outlet or strictly merchant-based. Hopefully, <i>Tech will lead the way</i> without ceding authority in the process: </p>
				  <p class="quote">
					But the Tennessee lawmaker’s effort hasn’t won any allies among privacy-conscious consumer groups, like the American Civil Liberties Union, which doubt Blackburn’s methods. And her bill has already prompted a whole new round of fierce lobbying by tech and telecom giants, which don’t see the need for any new regulation at all.
					</p> 
				  <p class="quote">
				  “I think that, in concept, the idea that there should be stronger privacy standards for edge providers and internet service providers is right,” said Neema Singh Guliani, the legislative counsel at the ACLU.</p>
				  <p class="quote">
				  But Blackburn, she added, should have gone about it differently. “The way to do it was not ... [through] gutting the FCC’s rules; the way to do it was actively working on a replacement.”<sup>3</sup>
				  </p>
				  <p>The bill is similar to the European data privacy model, <i>E.U. General Data Protection Regulation(GDPR)</i>, which serves as point of reference.<sup>2</sup> On May 14,   Europeans will   be implementing a pan-internet--edge and ISP--data protections, which include e-mail, Facebook and other apps, equally as for Comcast and Verizon, and industry-wide privacy defaults; Further, opt-in for privacy is more meaningful separate, and  not relegated to the main Terms and Conditions.<sup>3</sup></p>
				  <p>Policy regulation in other industries--exemplified by medical <i>HIPAA</i>, financial <i>Fair Credit   Reporting Act</i>--reveals the noticeable absence of similar policy in Tech. Tech's regulation is however necessarily far more complex, involving at minimum trade-offs between app-to-app data portability and new boundaries for different sources and forms of data. Clearly, the browser-based, high-security HTTPS Encryption I mentioned in my <a href="#d-18-04-06">April 6 three-part series on Progressive Web Apps </a>will undoubtedly be used for quick, inexpensive data privacy compliance, <i>a real boon for JavaScript developers</i>--as if there wasn't enough work already!
				  </p>
				  
				  
				  
				  <p class="cite">2. <a href="https://www.eugdpr.org" target="_blank">https://www.eugdpr.org
				  </a></p>  
				  
						  <p class="cite">3. <a href="https://www.recode.net/2017/5/24/15685870/new-republican-privacy-bill-tech-telecom-lobbying-fcc-congress" target="_blank">https://www.recode.net/2017/5/24/15685870/new-republican-privacy-bill-tech-telecom-lobbying-fcc-congress
						  </a></p>  
					  <p class="cite">3. <a href="https://www.nytimes.com/2018/04/08/technology/a-tough-task-for-facebook-european-type-privacy-for-all.html?ribbon-ad-idx=2&rref=technology&module=Ribbon&version=context&region=Header&action=click&contentCollection=Technology&pgtype=article" target="_blank">https://www.nytimes.com/2018/04/08/technology/a-tough-task-for-facebook-european-type-privacy-for-all.html?ribbon-ad-idx=2&rref=technology&module=Ribbon&version=context&region=Header&action=click&contentCollection=Technology&pgtype=article
					  </a> </p>  
				  <p class="cite">4. <a href="https://www.reuters.com/article/us-facebook-privacy-zuckerberg/zuckerberg-resists-effort-by-u-s-senators-to-commit-him-to-regulation-idUSKBN1HH1CU" target="_blank">https://www.reuters.com/article/us-facebook-privacy-zuckerberg/zuckerberg-resists-effort-by-u-s-senators-to-commit-him-to-regulation-idUSKBN1HH1CU
				  </a></p>  
				  
				  </div> 
				  
				  
				  
				  <div id="apr-18-04-10" class="      avr 18-03 -24">
				  <hr />
				  
				  <a href="#aprtop"> <button>Top</button> </a>
				  &nbsp;
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4> 
				  <h5 class="  subdailytech soc">Sociology Tomorrow!</h5> 
				  <p class="  author">by Thomas Maestas, MA</p> 
				  <h6    class="  chapternumber">April 10, 2018<br /> 
				  </h6> 
				  <h6    class="dailytitle chapternumber">When a Pickpocket is Pickpocketed:<br />  Part II:  "Semantic Polymorphism", i.e., Double Talk about  Data 
				  </h6> 
				  <p class="firstparagraph">Mark Zuckerberg daftly played word-tennis with   Senators in the first day of Congressional Hearings on Facebook Data Privacy issues. Although, in this case, <i>there were two, at times three, tennis balls at play!</i> What I mean is that "Data" and "Personal Data" vaccilated in meaning:  At times, Senators' questions referred to, 1.) personally identifiable data with intimate personal details, full name, location data (sensitive-data); 2.) Other times questions referred to <i>derivative data, i.e. data wrangled, refined, merged with different datasets</i> (composite-data); and,  3.) sometimes the questions meant the harmless, identity-encrypted "ad-data"(anonymized-data); but, usually, Zuckerberg responded to a question about one of these three meanings of "personal data", by responding with a non-abstract fourth: 4.) "Senator, the data, the 'likes' and pictures you share with Facebook, they are your property," Zuckerberg would answer. Well, thank goodness! </p>
				  <p> My blogpost talks about the shades of meaning: We all know the light-hearted awkwardness when a conversation splits into two separate threads because each party unknowingly follows differing meanings from the same word, or idea.  Austin Powers would have more fun with it, but the Sociologists typically call it  a <i>Semantic Predicament</i>.<sup>1</sup></p> 
				  <p>In fairness, Mark Zuckerberg volunteered as he himself was not subpoenaed, and therefore this preliminary, public discourse was critical for creating shared meaning and language about a complex topic. By volunteering to engage conversation with Senators, Zuckerberg interrupts the <i>game of telephone</i>; and, Senators engage with their constituents, and lo, America saves two years' of misunderstandings for clear data-protection action now. Bravo, Mark! Zuckerberg is perhaps one of the braver CEOs in American history--Now, he has earned his place right next to Andrew Carnegie--and very similar lives, too. And now, with defined boundaries, <i>Tech has a better roadmap</i> for ethical policy and sensible regulation. So let the data debates begin--but this time,with only one   ball at play! </p>
				  
				  <p class="quote"> 
				  </p>
				  
				  <p class="cite">1. <a href="https://onlinelibrary.wiley.com/doi/full/10.1111/j.1467-9558.2008.00324.x" target="_blank">Abend, G. (2008). The meaning of ‘theory’. Sociological Theory, 26(2), 173-199.
				  </a> <br /><a href="https://pdfs.semanticscholar.org/6df2/9e19cb02b684ee387192dfa4b1d284b88143.pdf" target="_blank">PDF  </a>
				  </p>  
				  <p class="cite">2. <a href="https://www.wired.com/story/mark-zuckerberg-talks-to-wired-about-facebooks-privacy-problem" target="_blank">https://www.wired.com/story/mark-zuckerberg-talks-to-wired-about-facebooks-privacy-problem
				  </a>	</p> 
				  
				  </div> 
				  
				  
				  <div id="apr-18-04-09" class="       avr 18-03 -24">
				  <hr />
				   
				  <a href="#aprtop"> <button>Top</button> </a>
				   &nbsp;
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4> 
				  <h5 class="  subdailytech soc">Sociology Tomorrow!</h5> 
				  <p class="  author">by Thomas Maestas, MA</p> 
				  <h6    class="  chapternumber">April 9, 2018<br />
					 
					</h6> 
				  <h6    class="dailytitle chapternumber">When a Pickpocket is Pickpocketed:<br />Part I: Facebook Data Generation and the Deepests Desires of Psychometricians, <i>Without Anonymization</i>   
				  </h6>
				  
				  <p class="firstparagraph">Psychometrics, along with today's biometrics and econometrics, form the 3 primary domains of statistical research. These three fields approach research differently. Psychometricians are less causally oriented, as their tool, "factor analysis"--<i>analyse factorielle</i>--reduces complex data to dimple, categorical forms in order to reconcile <i>quantitative data</i> with intuitive categories.<sup>1.</sup> And this research is great for expanding knowledge about society. But to what end? Who's to say, after all society is both the subject <i>and</i> object of this research. Social scientists are used to these mental gymnastics, yet are bound by a certain ethos of research: <strong>Anonymization, i.e. encrypting or removing personally identifiable information from datasets</strong>. This is the Social Scientists' <i>Oath</i>--a line of decency. </p>
				  <p>Tomorrow, Tuesday at noon, the world will tune in to hear Mark Zuckerberg's testimony before the U.S. Congress, all to hear about Facebook &amp; company's line of decency. However indecent any revelations may be, I'm not that entirely threatened by the revelations. Maybe I won't admit I'm   prone to Social Media influence, because I chart my course. Here's more from the esteemed Abbott: </p> 
				  
				  <p class="quote">“We have ended up believing that social reality is determined in the main by certain general forces, and that these generalities are then specified by combinations of forces, and further limited by various aspects of “individuality,” which in this sense is best understood as idiosyncratic higher order interaction.”<sup>1</sup> </p>
				  <p>And so, while academic research focuses on the "general forces" to better understand how groups work together, the <strong>bad thing that Zuckerberg did</strong> is not following in the same spirit of generality.<sup>2</sup> They chose to collect and disseminate our "likes" as much as our locations, and ... wait for the ominous music ... the <i><strong>non-FB connected mobile contacts of the Facebook clients' personal cell-phones</strong></i>--flipping through someone's personal desk drawer is definitely pushing the rules of privacy. I addressed this issue in my <a href="#d-18-03-20">March 20th blog post</a> on Facebook's ethics versus the long-standing data-handling ethics from Academia. Regarding tomorrow's revelations, let's remember to give the guy benefit of the doubt, even if they were handily swindled, while they were swindling us.<sup>3</sup>
				  </p>
				  
				  <p class="cite">1. <a href="http://journals.sagepub.com/doi/abs/10.1177/0049124198027002002" target="_blank">Abbott, A. 1998. “ The Causal Devolution.” Sociological Methods &amp; Research.
				  
				  </a></p>
				  <p class="cite">2. <a href="https://www.nytimes.com/2018/04/08/us/facebook-users-data-harvested-cambridge-analytica.html" target="_blank">https://www.nytimes.com/2018/04/08/us/facebook-users-data-harvested-cambridge-analytica.html
				  </a></p>
				  <p class="cite">3. <a href="https://www.wired.com/story/did-cambridge-analytica-access-your-facebook-data/" target="_blank">https://www.wired.com/story/did-cambridge-analytica-access-your-facebook-data/
				  </a></p>
				  
				  
				  
				  </div> 
				  
				  <div id="apr-18-04-07" class="      avr 18-03 -24">
				  <hr />
				  <a href="#aprtop"> 
					<button>Top</button> </a>
				  &nbsp;
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4> 
				  <h5 class="  subdailytech web">Web Dev Affairs</h5> 
				  <p class="  author">by Thomas Maestas, MA</p> 
				  <h6    class="  chapternumber">April 7-8, 2018<br />
				  Weekend
				  </h6> 
				  <h6    class="dailytitle chapternumber">
				  On the	Inevitable Demise of   Native Mobile Apps in favor of Progressive Web Apps<br />Part III: The Nuts &amp; Bolts of the App Replacement Process</h6>
				  
				  <p class="firstparagraph">Revolutions come and revolutions go, but the <i>2nd app revolution</i> is already underway, albeit quietly.<sup>1</sup> Most media sources refer to a "Native App - Progressive Web App Debate" with emphasis on what the native app can already do--<i>so if it's not broke, don't fix it</i>. However, implications change as the conversation turns to the Hyper Text Transfer Protocol (HTTP) Chrome V-8 JavaScript Engine<sup>2</sup>--you know, the web-app on <i>steroids</i>! </p>
				  <p>So what kind of steroids you ask? Let us say that the power of the modern browser lies in the open-source JavaScript engine, first C++ variation <i>originally </i>introduced in 2008 by Google's Chromium project. Open-source<i>-who?</i> (close your eyes next paragraph for the jargon-wary!) </p>
				  <p class="quote">A JavaScript engine is a program or an interpreter which executes JavaScript code. A JavaScript engine can be implemented as a standard interpreter, or just-in-time compiler that compiles JavaScript to bytecode in some form.<sup>2</sup></p>
				  <p>In plain english, this means that the browser speaks directly to machine code, and this is a big deal. Happily 'roided, the browser now accomodates tasks that the "App" was invented for: <i>To direct service work</i>--image and data loading, caching, storage, offline data, icons, notifica       tions, etc. </p>
				  <p>Now, through a "Manifest" file provided to the device from the browser, all of those same tasks are accomplished through a series of handshakes, and voil&aacute;: the mobile device doesn't see the difference between a native app and, well ... a <i>progressive app!</i></p>
				  <p>They say History repeats itself. In our digital lifetime, we have seen <i>record sales</i> surpass digital downloads again (due to streaming); we have seen the originally-decentralized internet return, or at least begin the journey, back to decentralization! And now, we have the once-lowly browser return with a vengeance and strength to replace native apps, with encrypted security, instant loading, and <i>better</i> off-line caching! Do you have an app for that?</p>
				  
				  <p class="cite">1. <a href="https://www.forbes.com/sites/forbestechcouncil/2018/03/09/why-progressive-web-apps-will-replace-native-mobile-apps/#3f39b4fa2112" target="_blank">https://www.forbes.com/sites/forbestechcouncil/2018/03/09/why-progressive-web-apps-will-replace-native-mobile-apps/#3f39b4fa2112</a></p>
				  
				  <p class="cite">2. <a href="https://blog.sessionstack.com/how-javascript-works-inside-the-v8-engine-5-tips-on-how-to-write-optimized-code-ac089e62b12e" target="_blank">https://blog.sessionstack.com/how-javascript-works-inside-the-v8-engine-5-tips-on-how-to-write-optimized-code-ac089e62b12e</a></p>
				  
				  </div> 
				  
				  
				  
				  <div id="apr-18-04-06" class="      avr 18-03 -24">
				  <hr />
				   
				  <a href="#aprtop"><button>Top</button></a>
				   &nbsp;
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4> 
				  <h5 class="  subdailytech web">Web Dev Affairs</h5> 
				  <p class="  author">by Thomas Maestas, MA</p> 
				  <h6    class="  chapternumber">April 6, 2018<br />
					</h6> 
				  <h6    class="dailytitle chapternumber">
					On the	Inevitable Demise of   Native Mobile Apps in favor of Progressive Web Apps<br />Part II: New Powers of the Modern   Browser</h6>
				  
					<p class="firstparagraph">Today's Web Browsers, &agrave; la Firefox, Chrome, Opera, etc., are <i>unabashedly on steroids</i>. And, well they deserve to be--they were here first! More importantly, the browser's native language--JavaScript--has been granted full power of the entire web's backend, i.e. servers, data, todos. This means that the browser achieves instant loading, <i>fully progressive, device-responsive,</i> full <i>HTTPS</i>-encryption security, and coherent cross-browser compatibility. So that your favorite   apps look and interact the same between the array of browser choices. The Washington Post has been lauded for helping pioneer the technology. Most notably, their progressive web app loads in .9 of a second, while their native mobile app requires 2.9 seconds.<sup>3</sup> Not exactly a photo finish!</p>
				  
					<p class="cite">1. <a href="https://www.techrepublic.com/article/how-progressive-web-apps-promise-to-upend-native-mobile-apps/" target="_blank">https://www.techrepublic.com/article/how-progressive-web-apps-promise-to-upend-native-mobile-apps/</a></p>
				  
					<p class="cite">2. <a href="https://www.fastcompany.com/3063420/how-google-and-others-are-plotting-the-revenge-of-the-web-app"target="_blank">https://www.fastcompany.com/3063420/how-google-and-others-are-plotting-the-revenge-of-the-web-app</a></p>  
				  
					<p class="cite">3. <a href="https://www.webbyawards.com/winners/2017/mobile-sites-apps/features-categories/technical-achievement/progressive-web-app-by-the-washington-post/" target="_blank">https://www.webbyawards.com/winners/2017/mobile-sites-apps/features-categories/technical-achievement/progressive-web-app-by-the-washington-post/</a></p>
				  
					
					<p class="cite">4. <a href="https://www.gartner.com/smarterwithgartner/top-trends-in-the-gartner-hype-cycle-for-emerging-technologies-2017/" target="_blank">https://www.gartner.com/smarterwithgartner/top-trends-in-the-gartner-hype-cycle-for-emerging-technologies-2017/</a></p>
				  </div> 
				  
				  
				  <div id="apr-18-04-05" class="      avr 18-03 -24">
				  <hr />
				  
				  <a href="#aprtop"><button>Top</button></a>
				  &nbsp;
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4> 
				  <h5 class="  subdailytech web">Web Dev Affairs</h5> 									
				  <p class="  author">by Thomas Maestas, MA</p>									
				  <h6    class="  chapternumber">April 5, 2018<br />
				  </h6> 
				  <h6    class="dailytitle chapternumber">
					On the	Inevitable Demise of   Native Mobile Apps in favor of Progressive Web Apps<br />Part I:   Mobile Devices Outwit and Outgrow the "Old-School" App</h6>
					<p  ><small>Note on app definitions in this post: Anything downloaded, whether iOS or Android is <i>native mobile app</i>, while progressive web apps are strictly behind the HTTPS protocol, i.e. browser-based.</small></p>
				  <p class="firstparagraph">Mobile Devices are ever delightful, yet a pesky 2 to 3-second delay often accompanies our everyday tasks using device-native apps. For the impatient, this delay is not tolerable, and even the patient have their urgent moments (or have better things to do).    So, whether we're Verizon, T-Mobile, or pre-pay phones like Sprint's Boost, our experiences are the same: 3-second delays abound--much to our impatience!  </p>
				  <p >Instant Loading </p>
				  <p >In contrast, many of our daily web-based tasks are instant, i.e. a second or less. I feel instant loading should be <i>a right</i>, not an occasional convenience. what does this potential mean? This means an app's service workers can load nearly immediately and reliably. This means  non-choppy  animations, smooth scrolling, no matter the network connection you're using, no matter the device!  </p>
				  <p  >Device-Neutral User Interface</p>
				  
				  <p  >After a long-day's work using desktop and mobile apps, why should an evening transition to tablet or laptop change our experience? Further, these variations differ between apps--of which there are alot:  2.2 million apps in the iTunes collection and 3 million Android apps, as of 2017<sup>2</sup>. of iOS apps &amp; 3 million. 	 My Fitbit experience is illustrative. First, I admit I have a terrible addiction to statistics, especially bio-statistics. And, Fitbit is my enabler.   However, my post-run tablet Fitbit app experience is different and more limited from the HTTPS-browser experience. App features, options, views, date-ranges vary between devices.  </p>
				  
				  <p  >Security </p>
				  <p  >HTTPS-level <i>browser</i> security vs. iTunes &amp; Play Store native app security is akin to a vault door versus building door. I'm sorry, but there's a lot of difference! 
				  <p  class="dailytech">In Progress  </p>
				  
				  <p class="cite">1. <a href="https://www.wired.com/2010/08/ff-webrip/" target="_blank">https://www.wired.com/2010/08/ff-webrip/</a>Re: The Web is Dead. Long Live the Internet</p>
				  <p class="cite">2. <a href="http://www.businessofapps.com/data/app-statistics/" target="_blank">http://www.businessofapps.com/data/app-statistics/</a> </p>
				  http://www.businessofapps.com/data/app-statistics/
				  
				  <p class="cite">2. <a href="https://www.techrepublic.com/article/how-progressive-web-apps-promise-to-upend-native-mobile-apps/" target="_blank">https://www.techrepublic.com/article/how-progressive-web-apps-promise-to-upend-native-mobile-apps/</a></p>
				  
				  
				  
				  <p class="cite">3. <a href="https://www.wired.com/2016/04/wait-web-isnt-really-dead-google-made-sure/" target="_blank">https://www.wired.com/2016/04/wait-web-isnt-really-dead-google-made-sure/</a></p>
				  
				  
				  </div> 
				  
				  
				  
				  <div id="apr-18-04-02" class="     avr 18-03 -24">
				  <hr />
				  
				  <a href="#aprtop"><button>Top</button></a>
				  &nbsp;
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>
				  
				  <h5 class="  subdailytech bc">Musing BLOCKCHAIN</h5>
				  
				  <p class="  author">by Thomas Maestas, MA</p>
				  
				  <h6   class="  chapternumber">April 2, 2018<br />
				  </h6> 
				  <h6   class="dailytitle chapternumber">Heraclite's Delight: Technology Change is the Constant, Human Behavior is Variable:<br />The April 2nd Announced Hedera Hashgraph X Launch Event  </h6>
				  <p class="firstparagraph">Next May 9th, the greatest known threat to traditional blockchain technology will be formally introduced, <i>along with its source code</i>, into our technological world. Hedera Hashgraph represents a blockchain alternative that caters to time-sensitive transactions, and order fairness. Currently, one transaction with Bitcoin takes about 12 minutes to validate. Ethereum is only a couple minutes, but in a world of micro-transactions and micro-second transactions, speed counts.</p><p>Next, Hedera's technology uses a consensus algorithm, which depends on  node neighbors' "voting" elections. This means that the design is impervious to "forking"--when a part of the blockchain splits and no long syncs with the main blockchain.  More importantly, Hedera's consensus design is   built on Asynchronous Byzantine Fault Tolerance (aBFT), so is then impervious to threats of <i>Distributed Denial of Service (DDS) attacks. </i></p>
				  <p>So, lightning speed for validating crypto-transactions. Guaranteed security from hard- or soft-forking of the blockchain, and DDS-like attacks. Fairness in transaction order. Come May 9th, we'll see just how Hedera's codebase and cryptocurrency will accomplish these benchmarks, and if so, Heraclitean river stops in time! If not, yet another cryptographic mirage!</p>
				  <p class="cite">1. <a href="https://www.hederahashgraph.com" target="_blank">	https://www.hederahashgraph.com</a> </p>
				  <p class="cite">1. <a href="https://medium.com/hashgraph/eat-pray-hashgraph-56b9613ed46f" target="_blank">https://medium.com/hashgraph/eat-pray-hashgraph-56b9613ed46f</a> </p>
				  
				  </div> 
				  
				  <hr /><a href="#aprtop">
				  <button id="end"> April TOP</button>
				  </a>
				  <p> &copy; 2018 All Rights Reserved. &nbsp; |
	
				  <a style="color:yellow;text-decoration:none;" href="http://www.thomasmaestas.net">thomasmaestas.net &nbsp; |</a>
				  <a style="color:yellow;text-decoration:none;" href="mailto:thomas@ourdailytech.com"> thomas@ourdailytech.com &nbsp; |</a>
				
				
				  <a title="Contact Information: thomasmaestas.net" href="http://www.thomasmaestas.net/profile.html#contactme"> Contact Information</a>
				</p>  
	`;
	  } else {
		secretParagraphAPR.style.display = 'none';
	  }
	}
	
	function updateSecretParagraphMAY() {
	  if (showSecretMAY) {
		secretParagraphMAY.style.display = 'block';
		secretParagraphMAY.style.fontFamily = 'Roboto';
		secretParagraphMAY.style.opacity = '1';
		secretParagraphMAY.style.color = 'darkslategray';
		secretParagraphMAY.innerHTML =  `<div id="maytop"></div>
	 
				  <div id="may-18-05-15" class="                avr 18-03 -24"> 
				  <hr />  
				  <a href="#maytop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech">Musing Blockchain</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>   
				  <h6    class="  chapternumber">May 15, 2018<br /> </h6>    
				  <h6    class="dailytitle chapternumber">Betting on the Mobile Blockchain <br />Part II:  Betting on the Hedera Hashgraph Distributed Ledger</h6>   
				  <p class="firstparagraph">Winning and losing millions via a telephone is very James Bond-esque, but the (re)newed legalisation of sports betting merely mimics national models already in long-time use in Europe and elsewhere.<sup>1</sup> In the U.S., mobile carriers and makers will be asked of a lot more when money is on the line ... which implicitly brings up blockchain solutions. Here's one example:
				  </p>
				  <p class="quote"> WinFlow, a sports betting platform that uses ledger technology to offer transparent betting and products, has decided to run its platform, a decentralized application on the Hedera Hashgraph Network.
				  
				  WinFlow has been created with the intentions of solving three main industry related problems, which are the lack of accountability and transparency, meaningful rewards programs or compensation to losing players and product innovation.<sup>2</sup>
				  </p>
				  <p>
				   So where are we on Mobile solutions now that the stakes have been exponentially raised...Security, Authentication, Instantaneous Speed?  No need to look, the tech doesn't exist!</p>
				  <p class="quote">“There is currently no active, fully-functional sportsbook using distributed ledger or blockchain technology, let alone any operator in the sports betting industry at large that redistributes almost all of their profits right back to the players. <sup> 2 </sup> </p>
				  <p>What a coincidence that this month, Hedera's Hashgraph <i>public</i> ledger was released, the European Union rewrote their internet data policies in General Data Privacy Regulation (GDPR covered in more depth in <a href="#d-18-04-19">April 19th</a> and <a href="#d-18-04-16"> 16th posts</a>. However the occurrence of all three events will definitely trigger some technological hot-swapping! From the same example,
				  </p>
				  <p class="quote">
				  the [WinFlow] project, which is squarely focused on Europe due to the Federal ban on sports betting in the US, will raise money through private placements while it continues to work on developing the betting platform.<br /><br /> 
				  WinFlow, which claims to have a unique profit sharing model, said breakthroughs in technology and new benefits for players, including unprecedented rewards, security, and transparency, will allow it to disrupt the incumbents in a multi-billion dollar market.
				  </p>
				  <p>So, the needs for mobile sports betting all depend on speed, for which the newly unveiled Hedera hashgraph specializes <sup>2 </sup> (covered <a href="#may-18-05-02">May 2-5 four-part series</a>). Looks good from afar, let's see now that anyone can kick the tires of that thing called DAG!
				  </p>
				  <p class="cite">1. <a href="https://www.theguardian.com/business/nils-pratley-on-finance/2018/may/14/uk-bookies-beware-us-will-look-after-its-own-in-betting-revolution" target="_blank">https://www.theguardian.com/business/nils-pratley-on-finance/2018/may/14/uk-bookies-beware-us-will-look-after-its-own-in-betting-revolution</a></p>
				   <p class="cite">2. <a href="https://bitcoinexchangeguide.com/hedera-hashgraph-dlt-will-power-winflow-profit-sharing-sportsbook/" target="_blank"> https://bitcoinexchangeguide.com/hedera-hashgraph-dlt-will-power-winflow-profit-sharing-sportsbook/</a></p>
				   
				  <p class="cite">3. <a href="https://www.forbes.com/sites/jeffkauflin/2018/03/13/hedera-hashgraph-thinks-it-can-one-up-bitcoin-and-ethereum-with-faster-transactions/#63d0806cabcb" target="_blank">https://www.forbes.com/sites/jeffkauflin/2018/03/13/hedera-hashgraph-thinks-it-can-one-up-bitcoin-and-ethereum-with-faster-transactions/#63d0806cabcb</a></p>
				  <p class="cite">4. <a href="https://bitsonline.com/mance-harmon-hedera-hashgraph/" target="_blank">https://bitsonline.com/mance-harmon-hedera-hashgraph/</a></p>
				  </div>
				   
				  
				  
				  <div id="may-18-05-14" class="                 avr 18-03 -24"> 
				  <hr />  
				  <a href="#maytop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech">Sociology Tomorrow!</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>   
				  <h6    class="  chapternumber">May 14, 2018<br />
				  Weekend</h6>    
				  <h6    class="dailytitle chapternumber">Betting on Mobile Blockchain<br /> Part I: The Floodgates of Money have Opened!
				   </h6>    <p class="firstparagraph">Justice Samuel A. Alito Jr. outlined the Supreme Court's Majority Opinion on overturning the federal prohibition on sports betting this week.<sup>1</sup> The primary <i>justification was an unconsitutional Federal authority over States' rights</i>, in overturning the 1992 Professional and Amateur Sports Protection Act.  
				   </p>
				   <p class="quote">The Supreme Court struck down a 1992 federal law on Monday that effectively banned commercial sports betting in most states, opening the door to legalizing the estimated $150 billion in illegal wagers on professional and amateur sports that Americans make every year.<br /><br />
				   The decision seems certain to result in profound changes to the nation’s relationship with sports wagering. Bettors will no longer be forced into the black market to use offshore wagering operations or illicit bookies.<i> Placing bets will be done on mobile devices, </i> fueled and endorsed by the lawmakers and sports officials who opposed it for so long. <sup>2</sup> 
				   </p>
				   
				   <p>And now, <i>the Vegas Strip</i> is but a mere icon's hop away from Candy Crush! Uh oh ....</p><p class="cite">1. <a href="https://www.nytimes.com/2018/05/14/us/politics/supreme-court-sports-betting-new-jersey.html" target="_blank">https://www.nytimes.com/2018/05/14/us/politics/supreme-court-sports-betting-new-jersey.html</a></p>
				  </div>
				  
				  
				  
				  <div id="may-18-05-12" class="                avr 18-03 -24"> 
				  <hr />  
				  <a href="#maytop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech">Web Dev Affairs</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>   
				  <h6    class="  chapternumber">May 12-13, 2018<br />Weekend </h6>    
				  <h6    class="dailytitle chapternumber">The Wedding of JavaScript and WebAssembly: <br />Part III: The Nuts and Bolts of the Relationship</h6>   <p class="firstparagraph">Jargon is curiously ugly at first sight, but only with time does technical beauty reveal itself. I decided to make my first recipe with WebAssembly and JavaScript, (with yes, a third called <i>Emscripten</i> and no, my eyes aren't rolling) ... this waaas amazing, Wow! So I thought to write about the nuts and bolts of it all. </p>
				  <p>So,   what exactly <i> is </i> WebAssembly, specifically?? It's this:<span style="color:purple"> (And, for the jargon-wary, skip this paragraph </span> :-)</p>
				  <p class="cite">
				  $ emcc -s WASM=1 -o fib.js fib.c </p><p class="green">
				  <i>emcc</i> executes the <i>Emscripten</i> compiler<br />
				  <i>-s</i> ensures that Emscripten outputs WebAssembly<br />
				  <i>-o fib.js</i> names the output as fib.js<br />
				  <i>fib.c</i> And, finally this is the input file's name!<br />
				  <p>
				  This first part? It's like staring into a solar eclipse (I confess I glanced at one recently (but didn't we all, secretly?)) ... <br />
				  Anyway, this is a simple, classic example using Fibonacci sequence<sup>2</sup> for familiarity. Here's the input:<br />
				  </p>
				  <pre>
				  fib.c:
				  #include <emscripten.h>
				  
				  EMSCRIPTEN_KEEPALIVE
				  int fib(int n) {
					int i, , a = 0, b = 1;
					for  (i = 0; i < n; i++) {
					  t = a + b;
					  a = b;
					  b = t;
					}
					return b;
				  }</pre> 
				  <p>
				  So, given the integer absence in JavaScript mentioned in the <a href="#18-05-10">May 10th post</a>, The Fibonacci integer sequence example illustrates the   relationship between WebAssembly and Javascript. Unlike JavaScript's lack of integers, WebAssembly's math kit is nothing short of luxury! 
				  </p>  
								<p>So what happened back there is that <i>Emscripten outputs <strong>two </strong>files, one JavaScript (fib.js) and one WebAssembly (fib.wasm)</i>.. Simple enough, and that's why massive, intractable application programs like AutoCAD can now be easily deployed on any platform, fast and high-function on our mobile phones. True it is, <i>after first glance, all  this jargon's inner beauty shines, a real harbinger of great apps to come!</i></p>
				  <p class="cite">1. <a href="https://medium.com/mozilla-tech/why-webassembly-is-a-game-changer-for-the-web-and-a-source-of-pride-for-mozilla-and-firefox-dda80e4c43cb" target="_blank"> https://medium.com/mozilla-tech/why-webassembly-is-a-game-changer-for-the-web-and-a-source-of-pride-for-mozilla-and-firefox-dda80e4c43cb</a></p>
	<p class="cite">2. <a href="https://webassembly.org" target="_blank">https://webassembly.org</a></p>
	<p class="cite quote green ">2. Note on example Fibonacci Sequence: (Wikipaedia Definition):
	<br />
	In mathematics, an integer sequence is a sequence (i.e., an ordered list) of integers. 
	An integer sequence may be specified explicitly by giving a formula for its nth term, or implicitly by giving a relationship between its terms. For example, the sequence 0, 1, 1, 2, 3, 5, 8, 13, … <i>(the Fibonacci sequence) is formed by starting with 0 and 1 and then adding any two consecutive terms to obtain the next one: an implicit description.</i>  The sequence 0, 3, 8, 15, … is formed according to the formula n2 − 1 for the nth term: an explicit definition.</p> 
				  </div>
				  
				  
				  
				  
				  
				  
				  
				  <div id="may-18-05-11" class="              avr 18-03 -24"> 
				  <hr />  
				  <a href="#maytop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech">Sociology Tomorrow!</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>   
				  <h6    class="  chapternumber">May 11, 2018</h6>    
				  <h6    class="dailytitle chapternumber">The Wedding of JavaScript and WebAssembly: <br />Part II: How Secure and Safe is this New Mobile World?
				  </h6>   
				  <p class="firstparagraph">WebAssembly,  about a year old, provides a new level of performance to mobile apps and the browser generally, but is it safe? It's actually safer than traditional plug-ins for browsers. Here's a quick recap from yesterday's post on WebAssembly:</p>
	<p class="quote">WebAssembly is one of the biggest advances to the Web Platform over the past decade.
	
	This new standard will enable amazing video games and high-performance web apps for things like computer-aided design, video and image editing, and scientific visualization. Over time, many existing productivity apps (e.g. email, social networks, word processing) and JavaScript frameworks will likely use WebAssembly to significantly reduce load times while simultaneously improving performance while running. Unlike other approaches that have required plug-ins to achieve near-native performance in the browser, WebAssembly runs entirely within the Web Platform. This means that developers can integrate WebAssembly libraries for CPU-intensive calculations (e.g. compression, face detection, physics) into existing web apps that use JavaScript for less intensive work.<sup>1</sup>
	</p><p>
	Browsers, <i>despite HTTPS encryption, are growing in security weaknesses</i> with more territory, responsibilities, and new API relationships. However, along with WebAssembly's solutions for CPU-intensive browser operations (like AutoCAD example in the previous post), WebAssembly also offers unique security solutions:  
	</p>
	<p class="quote">WebAssembly describes a memory-safe, sandboxed execution environment that may even be implemented inside existing JavaScript virtual machines. When embedded in the web, WebAssembly will enforce the same-origin and permissions security policies of the browser.<sup>2.</sup></p>
	<p>
	 This architecture   signifies eventual compatibility with the existing Block Chain apps like MetaMask that use a browser plug-in to set up an API between, for example, the Ethereum blockchain and Web access. So, with WebAssembly's great potential with JavaScript, is it a safer, more secure on-line world? No, but <i>there are safer corners </i> ... and certainly a safer niche for drawing space!</p>
				  
	 <p class="cite">1. <a href="https://medium.com/mozilla-tech/why-webassembly-is-a-game-changer-for-the-web-and-a-source-of-pride-for-mozilla-and-firefox-dda80e4c43cb" target="_blank"> https://medium.com/mozilla-tech/why-webassembly-is-a-game-changer-for-the-web-and-a-source-of-pride-for-mozilla-and-firefox-dda80e4c43cb</a></p>
	 <p class="cite">2. <a href="https://webassembly.org" target="_blank">https://webassembly.org</a></p>
				  
				  
				  </div>
				  
				  
				  
				  <div id="may-18-05-10" class="             avr 18-03 -24"> 
				  <hr />  
				  <a href="#maytop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech">Web Dev Affairs</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>  
				  <h6    class="  chapternumber">May 10, 2018<br /></h6>    
				  <h6    class="dailytitle chapternumber">The Wedding of JavaScript and WebAssembly: <br />Part I: The Opening of a New Mobile App World
				  </h6>   
				  <p class="firstparagraph">AutoCAD, the first name in 3-D engineering, has stepped into a new world in the past month. Recent, unprecedented mobile app advances allow more CPU-intensive laptop applications to hop to the phone with equal interactivity and near-equal functionality. Thanks to third-party languages, JavaScript, the browser's language, is broadening in powers: And this is nothing short of exhilarating with just enough of a touch of danger.
				  </p><p>AutoCAD's recent advances in their mobile platform exemplifies this trend.<sup>1</sup> AutoCAD, the ancient, foundational, ultra-powerful, ever-modernizing programming codebase--celebrates 35 years old, and predates the web! AutoCAD by AutoDesk has historically had difficulty implementing its codebase into mobile platforms. So, their app presence suffered because it had been highly watered down, and suddenly competing with thousands of other 3-D engineering apps...Until now. </p><p>
				  
				  <p class="quote">Yesterday [March 2, 2018] was a big day for the AutoCAD product. A multi-year engineering project – started in the AutoCAD team way back when I was part of it – culminated in its first deliverables getting into the hands (or, in this case, browsers) of customers.  The AutoCAD team has been working on a project codenamed “Fabric” for the last several years. It's has been a huge amount of work – something I’ll hopefully get into in a future blog post – but it’s finally bearing tangible fruit.  In broad strokes the work was to take the core of AutoCAD and make it cross-platform. </p><p class="quote">You might consider the Big Split – work that was done ostensibly to build AutoCAD for Mac but resulted in a Core Engine that became the mechanism through which developers could run custom code in the cloud via AutoCAD I/O (now part of Forge’s Design Automation API) – to be the first phase of this effort. At the very least Fabric stood on the shoulders of the Big Split.<sup>2.</sup></p><p>
				  
				  In short, AutoDesk's latest browser-based AutoCAD Web App and Mobile App have suddenly advanced a quantum step. For example, the mobile app provides nearly all of the full features (not including 3-D rendering), like swapping .DWG files from cloud services using a full mobile interface.  </p>
				  <p>
				  Not just for AutoCAD, but all apps improve, because <i>third-party languages like WebAssembly can "broker" the API conversation between browser and the operating system's machine code for certain tasks</i>.<sup>3</sup> Exceptionally interesting, now WebAssembly performs real-time C++ transpiling allowing any browser to communicate in near-to direct machine-code for certain tasks. 
				  WebAssembly (Wasm) is a "binary instruction format for a stack-based virtual machine ... designed as a portable target for compilation of high-level languages like C/C++/Rust, enabling deployment on the web for client and server applications."<sup>3</sup> In other words, <i>WebAssembly is the middle-person translating between JavaScript's V8 Engine and a device's Operating System</i>. Here's  a clearer explanation using the AutoCAD example:</p>
				  <p class="quote">[AutoCAD's] Fabric has done away with #ifdefs, forcing any platform-specific code into a PAL (Platform Abstraction Layer) per targeted platform. And Fabric is able to target more than just Windows and OS X. Some of the main targets were the established mobile platforms (more on that down the line), but one major effort was to target the web platform with the AutoCAD codebase.
				  Yes, you read that right… yesterday’s update to AutoCAD Web now runs the same core code as standard AutoCAD, but in a browser. A major part of AutoCAD’s C++ codebase gets run through Emscripten (at least that’s my understanding – I’ll correct any details I get wrong) to be transpiled into WebAssembly. 
				  <p>
				  <p>So, it looks like our <i>wild, untamed language, JavaScript, has matured to the big-leagues </i> by teaming up with WebAssembly ... After all, JavaScript, among all the languages, was born without a mind for math... literally. It's core math library conducts all operations in 64-bit floating point, in the absence of integers! So, this entails occasional anomalies: For example, .1 + .2 does not equal .3! (Try it with the JavaScript calculator below ... ) And so, great things await this partnership between WebAssembly and JavaScript, but every marriage is different... one partner may always need help cooking, and another may always need help with the math, but that's what Marriage is for!</p> 
				  <p class="cite">1. <a href="https://www.autodesk.com/products/autocad/features" target="_blank"> https://www.autodesk.com/products/autocad/features</a></p>
	<p class="cite">2. <a href="http://through-the-interface.typepad.com/through_the_interface/2018/03/the-future-of-autocad.html" target="_blank"> http://through-the-interface.typepad.com/through_the_interface/2018/03/the-future-of-autocad.html</a></p>
	<p class="cite">3. <a href="https://webassembly.org">https://webassembly.org</a></p>
				  </div>
				  
				  <div id="'may-18-05-09" class="              avr 18-03 -24"> <hr />  
				  <a href="#maytop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech">Musing Blockchain</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>  
				  <h6    class="  chapternumber">May 9, 2018<br />  </h6>    
				  <h6    class="dailytitle chapternumber">Google I/O 2018, Part III:<br /> The Browser\'s Achilles Heel Exposed
				  </h6>   
				  <p class="firstparagraph">For all the fanfare of in-browser apps, i.e. Progressive Web Apps, the picture isn't as rosy as appears. After all, we are still talking about the browser window, right? Many of the <i>browser-based</i> apps depend on plugin extensions. This is sort of the Achilles Heel recently exposed while, "over two months, seven [Chrome] extensions stole credentials and installed currency miners."<sup>1</sup> The article cites 100,000 computers that may have lost passwords, and other private data--ouch!
				  </p>
				  <p class="quote">
				  The scam was active since at least March with seven malicious extensions known so far, researchers with security firm Radware reported Thursday. Google's security team removed five of the extensions on its own and removed two more after Radware reported them. In all, the malicious add-ons infected more than 100,000 users, at least one inside a "well-protected network" of an unnamed global manufacturing firm, Radware said.
				  </p>
				  <p>As we see the app-in-the-browser taking on more operational, networking, functional roles (the work previously reserved to native Apple/Google/Microsoft app stores), unknown, unconceived threats are increasingly possible. That's another reason why Tech is always an edge-of-your-seat spectacle!
				</p>
				<p class="cite">1. <a href="https://arstechnica.com/information-technology/2018/05/malicious-chrome-extensions-infect-more-than-100000-users-again/">https://arstechnica.com/information-technology/2018/05/malicious-chrome-extensions-infect-more-than-100000-users-again/</a></p>
				<p class="cite">1. <a href="https://blog.radware.com/security/2018/05/nigelthorn-malware-abuses-chrome-extensions/">https://blog.radware.com/security/2018/05/nigelthorn-malware-abuses-chrome-extensions/</a></p>
				  
				  </div>
				  
				  
				  <div id="may-18-05-08" class=" avr 18-03 -24"> 
				  <hr />  
				  <a href="#maytop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech">Web Dev Affairs</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>  
				  <h6    class="  chapternumber">May 8, 2018<br />  </h6>  
				  <h6    class="dailytitle chapternumber">
				  Google I/O 2018, Part II:<br />   Progressive Web Apps (PWAs) Quietly Taking Over the Mobile App World
				  </h6>   
				  <p class="firstparagraph">Google I/0's 2018 revelations also included a focus on the <i>Progressive Web App (PWA)</i>. My <a href="#d-18-04-11">April 11th</a> and <a href="#d-18-04-05">April 5th</a> posts introduce a new approach to traditional mobile apps, using new JavaScript techniques including a "manifest" and "service workers" files that instruct the mobile phone what to cache and other specs. Google has pushed use of these PWAs since 2015 with Google Chrome's efforts to steer app development toward device-neutral, ultra-fast, and encryption advantages of the Hyper Text Transfer Protocol (HTTP), i.e. the browser. </p>
				  <p class="quote">
				  On the first day of Google I/O 2018 event, Tal Oppenheimer, Chief Product Manager (Chrome) at Google, shared that websites like EconomicTimes.com, Instagram and Starbucks are seeing "incredible results" in user retention and time spent, while using Progressive Web Apps (PWAs) technology.
				<br />
				PWAs are websites that take advantage of modern web platform Application Programming Interfaces (APIs) to build experiences like working offline, sending push notifications and getting added directly to .. 
				  </p>
				  <p>Web apps use the browser for viewing and security, while the app's "manifest" uses <i>service workers</i> to manage data, networking, caching optimized for off-line ability and other actions that were formally reserved for "Native" apps downloaded from Apple or  Google Play stores. So what the flip? It does mean better speed and utility, features and appearance optimized to device, whether mobile, laptop or tablet, all without sacrificing the personalized, off-line features of "native" app store apps? ... it's the best of both worlds! </p>
				  <p class="cite"><a href="https://www.cnet.com/news/5-best-things-from-google-io-2018/" target="_blank" >https://www.cnet.com/news/5-best-things-from-google-io-2018/</a></p>
				  <p class="cite"><a href="economictimes.indiatimes.com/articleshow/64089365.cms?utm_source=contentofinterest&utm_medium=text&utm_campaign=cppst" target="_blank" >economictimes.indiatimes.com/articleshow/64089365.cms?utm_source=contentofinterest&utm_medium=text&utm_campaign=cppst</a></p>
				  </div>
				  
				  <div id="may-18-05-07" class="            avr 18-03 -24"> 
				  <hr />  
				  <a href="#maytop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech">Web Dev Affairs</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>  
				  <h6    class="  chapternumber">May 7, 2018<br />
				 </h6>   
				  
				  <h6    class="dailytitle chapternumber">
				  Google I/O 2018,  Part I:<br />  Google Duplex, Do We Really Want to be as Lazy as Possible?
				  </h6>   
				  <p class="firstparagraph">O.K. Google, I'll pass on the lemonade, and ... why don't you take the afternoon off, I'm going to be independent for a while, "again". Alas, we are getting some interesting, if not slightly weird, features from this week's Google I/O 2018 Developer Conference.<sup>1</sup>  So, wonderful news! I'm so tired from picking up my phone to order my take-out, now my Google Assistant can just do all that hard work for me!
				  </p><p>This week's revelations from Google's I/0 2018 offer A.I.-focused new hardware features, yet A.I. stole the show. The better integration of Google's assistant <i>with contacts and calling</i> is eyebrow-raising:</p>
				  <p class="quote">The demo is part of what Google calls an "experiment" it plans to launch this summer. With Duplex, a "small" number of people will be able to book restaurant reservations and hair appointments and to check holiday hours, stuff you'd normally do over the phone. All of that back and forth happens on the back end -- between Google Assistant and, say, the restaurant. You won't even hear the conversation taking place. It'll come from an unspecified phone number, not your own number.<sup>1</sup></p>
				  <p>The feature raises the question of advantage over Siri and Alexa... Although access to the Google-minutiae of our personal information (data thankfully we are now more empowered to download and even delete) begs the question of individuals' machines that talk directly to the restaurant's voice-activated receptionist (perhaps a french accent?) machine. I'm all for efficiency and better organization, but I'd hardly imagine being too busy to place a call myself! 
				  </p>
				  <p>
				  also just mean different assistants for different parts of our day!</p>
				  <p class="cite">1. <a href="https://www.cnet.com/features/google-assistant-duplex-at-io-could-become-the-most-lifelike-ai-voice-assistant-yet/" target="_blank">https://www.cnet.com/features/google-assistant-duplex-at-io-could-become-the-most-lifelike-ai-voice-assistant-yet/ </a></p>
				 <p class="cite">2. <a href="https://www.techradar.com/news/google-io-2018" target="_blank">https://www.techradar.com/news/google-io-2018</a></p>
				  
				  </div>
				  
				  
				  
				  <div id="may-18-05-05" class="         caption-pre   avr 18-03 -24"> 
				  <hr />  
				  <a href="#maytop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech">Musing Blockchain</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>  
				  <h6    class="  chapternumber">May 5-6, 2018<br />Weekend</h6>   
				  
				  <h6    class="dailytitle chapternumber">3rd Generation Blockchain: How Fast can the Blockchain Operate? Part IV: Potential Solutions for Blockchain Stability
				  </h6>   <p class="firstparagraph">Challenges to the Hashgraph range from mathematical properties of acyclic graphs (think of the 7 Bridges of Koenigsburg, the riddle of crossing town while crossing each bridge exactly once) to the social implications of how to "distribute" data and <i>who actually holds onto the keys at the end of the day.  </i>
				  </p>
				  <p class="quote">While GridAgents™ and in general multi-agent systems (MAS) offered strong models for representing complex and dynamic real-world environments, we were missing something very important that is becoming available today with blockchain and distributed ledger technologies. The missing links include (1) consensus, (2) immutability and (3) ability to operate in trustless environments. Dr. Maxim Orlovsky states:
				
				  “Blockchain will give to Multi-Agent AI — the same thing that written language gave to humans — Means of Cognitive Evolution”
				  
				  Maxim also states that what blockchain brings to multi-agent systems is consensus algorithms for interpreting facts in a trustless multi-agent system. Consensus allows for nodes in the system to be in unanimous agreement on the state of things. Additionally, blockchain creates a permanent memory (immutability) making the vision of multi-agent systems much more complete. I call the addition of blockchain/DLTs to multi-agents system, AI 3.0. This AI 3.0 combines the benefits of over 30 years of research on AI, machine learning, and multi-agent systems with blockchain and DLT technology to finally enable the emerging industry 4.0 where billions of devices will be connected to the internet and will need to coordinate in real-time at the edge of the network.<sup>3</sup> </p>
				  <p class="cite">1.  <a href="      https://science.house.gov/legislation/hearings/subcommittee-oversight-and-subcommittee-research-and-technology-hearing-0" target="_blank">   https://science.house.gov/legislation/hearings/subcommittee-oversight-and-subcommittee-research-and-technology-hearing-0</a></p>  
				  <p class="cite">2.  <a href="    https://venturebeat.com/2018/03/13/hedera-hashgraph-and-mz-unveil-next-generation-blockchain-alternative/" target="_blank">    https://venturebeat.com/2018/03/13/hedera-hashgraph-and-mz-unveil-next-generation-blockchain-alternative/</a></p>  
				 <p class="cite">3.  <a href=" https://medium.com/hashgraph/ai-3-0-why-hashgraph-and-how-it-will-revolutionize-blockchain-and-ai-86a6ef715c9f" target="_blank">https://medium.com/hashgraph/ai-3-0-why-hashgraph-and-how-it-will-revolutionize-blockchain-and-ai-86a6ef715c9f</a></p>
				  </div>
				  
				  
				  <div id="may-18-05-04" class="           avr 18-03 -24"> 
				  <hr />  
				  <a href="#maytop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech web">Musing Blockchain</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>  
				  <h6    class="  chapternumber">May 4, 2018</h6>   
				  <h6    class="dailytitle chapternumber">3rd Generation Blockchain: How Fast can the Blockchain Operate? Part III: : The Challenges for the Directed Acyclic Graph (DAG) with Ripple and  Iota Coin
				  </h6>  <p class="firstparagraph">Blockchain challenges, like any field, start with social acceptance on one end, and technical acceptance on the other. The latter is a little more important, but the former usually runs the show because <i>it, financially speaking, <strong> is</strong> the show</i>. I mentioned the curve
				  </p>
				  <p class="quote">First, blockchain benefits from incumbency and familiarity. Why risk replacing it with a less well-tested technology whose vulnerabilities haven’t all been identified? Also, while it can retain as much transactional data as needed, hashgraph typically doesn’t contain as much transactional history as the Bitcoin blockchain does. For many applications, hashgraph would only keep track of users’ latest positive wallet balances.
				
				  Second, the DAG system doesn’t involve the computation-heavy “proof of work” effort to verify transactions that some blockchains, such as Bitcoin blockchain, require. Having several miners ratify and vote to accept a transaction lends blockchain what some say is a greater degree of security that the ledger contains a single version of the truth than under DAG-based systems. 
				  <br />
				  <br />
				  IOTA, the best-known DAG, is already the No. 10 largest cryptocurrency, with $6.6 billion in market capitalization, according to CoinMarketCap. 
				  
				  “Even first-year computer science students here at MIT laugh at the code when they see it,” Tadge Dryja, a research scientist at MIT who is working to scale the Bitcoin network, said in an email. 
				  
				  The hack MIT came up with “can’t happen in practice,” Serguei Popov, one of the founders of IOTA, said in a phone interview.
				  
				  
				Hashgraph uses DAG differently: It uses it to record different aspects of transactions than IOTA, and has different security characteristics, according to hashgraph developers.
				<sup>1</sup>
				</p>
				<p class="cite">1. CoinDesk Source URL being researched. <a href="#" target="_blank">__</a></p>
				  </div>
				  
				  
				  <div id="may-18-05-03" class="           avr 18-03 -24"> 
				  <hr />  
				  <a href="#maytop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech bc">Musing Blockchain</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>  
				  <h6    class="  chapternumber">May 3, 2018</h6>   
				  <h6    class="dailytitle chapternumber">3rd Generation Blockchain: How fast can the blockchain operate? Part II: : Speed Needs of   Supply Chain Management
				  </h6>  
				  <p class="firstparagraph">The lessons learned from last week's Romaine Lettuce Crisis has brought the <i>supply chain management</i> topic to the nation's dinner-table conversations. 
	  (Quick recap in my <a href="#d-18-04-25">April 25th post</a>). The big issue is uninterrupted, comprehensive and permissioned data access to those ... mystery Romaine lettuce heads. What could hashgraph tech offer? Everything from real-time temperature sensors and ID's to cross-institution, cross-border accuracy from source to supply targets. And, next week Congress will also be talking about it:  
	  </p>
	  <p class="quote">
	  Lawmakers in the U.S. Congress are set to hold a hearing on blockchain tech's use in global supply chains next week.
	
	Two subcommittees of the U.S. House Committee on Science, Space and Technology - for Research and Technology, and Oversight - will meet on May 8, a newly published notice reveals. The hearing is entitled "Leveraging Blockchain Technology to Improve Supply Chain Management and Combat Counterfeit Goods."<sup>1</sup>
	</p>
	<p>Here, the Science, Space, & Technology Committee <sup>2</sup> of Congress will be meeting This Tuesday, May 8th, hearing from Witnesses from Maersk (head of global trade digitization), UPS (global customs brokerage staff), and of course the good ol' Dept. of Homeland Security, and doubtless an international<sup>3</sup> platoon of lawyers! </p>
	<p class="cite">1. <a href="https://www.coindesk.com/us-lawmakers-hear-case-blockchain-supply-chain/" target="_blank">https://www.coindesk.com/us-lawmakers-hear-case-blockchain-supply-chain/</a></p>
	<p class="cite">2. <a href="https://science.house.gov/legislation/hearings/subcommittee-oversight-and-subcommittee-research-and-technology-hearing-0" target="_blank">https://science.house.gov/legislation/hearings/subcommittee-oversight-and-subcommittee-research-and-technology-hearing-0</a></p> 
	 <p class="cite">3. <a href="https://www.mckinsey.com/industries/financial-services/our-insights/global-payments-2017-amid-rapid-change-an-upward-trajectory">https://www.mckinsey.com/industries/financial-services/our-insights/global-payments-2017-amid-rapid-change-an-upward-trajectory</a></p>
				  </div>
				  
				  
				  <div id="may-18-05-02" class="           avr 18-03 -24"> 
				  <hr />  
				  <a href="#maytop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech web">Musing Blockchain</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>  
				  <h6    class="  chapternumber">May 2, 2018</h6>   
				  <h6    class="dailytitle chapternumber">3rd Generation Blockchain: How fast can the blockchain operate? nPart I: Speed needs of the Financial Sector
				  </h6>  
				  <p class="firstparagraph">The most polished, cryptographically stable leader of  <i>third generation</i> blockchain technology is formally released this month, and anticipation is anything but calm. (Some background posts help contextualize this 2-part series on Hashgraph  technology and potential for capturing per-micro-second, real-time financial needs of the globalizing economy: <a href="#d-18-04-18"> April 18</a> and <a href="#d-18-04-02">April 2</a>.) The formal release is on May 9th, but this May 1st press release caught my attention as we see a glimpse of this technology on a public* ledger: 
				  </p>
				  <p class="quote"> CULedger and Hedera today announced a partnership whereby CULedger will use Hedera's hashgraph platform and public ledger to build a system for cross-border payments. CULedger has already been using the private ledger version of hashgraph, offered by Swirlds, for general purpose, permissioned ledger use.<sup>1</sup> </p>
				  <p>The big news is Hedera's "public" blockchain ledger service that moves closer to popular usage with it's unique <i>directed acyclic graphs</i>, whose speed increases with scale.  Until recently, Blockchain tech has been hamstrung in the domain of micro-transactions, so now that the barrier has been crossed, how many sectors of life will be enhanced? All. But not yet. Once 5G technology (100 times faster, 100 times the capacity of 4G) is rolled out, then we hit the big leagues.</p> 
				  <p class="quote">A group of U.S. credit unions looking to pool resources considered the Bitcoin and Ethereum blockchains to track their business, but wound up selecting something else entirely: hashgraph.</p>
				  <p class="quote">Currently, cross-border payments are painful for all parties involved," said Rick Cranston, COO of CULedger. "They take time, they're expensive, and there is limited visibility into the transaction. Hashgraph is fast and it provides visibility between the two parties at a significantly lower cost. It also eliminates concerns regarding fraud and default, since transactions are recorded immutably on the public ledger, and manual processes, since transactions are automated via smart contracts.<sup>1</sup></p>
				  <p> ...to be continued...</p> 
				  <p class="cite"><a href="https://www.prnewswire.com/news-releases/culedger-selects-hedera-hashgraph-to-build-global-ledger-for-cross-border-payments-300639874.html" target="_blank">https://www.prnewswire.com/news-releases/culedger-selects-hedera-hashgraph-to-build-global-ledger-for-cross-border-payments-300639874.html</a></p>
	<p class="cite"><a href="https://venturebeat.com/2018/03/13/hedera-hashgraph-and-mz-unveil-next-generation-blockchain-alternative/" target="_blank">https://venturebeat.com/2018/03/13/hedera-hashgraph-and-mz-unveil-next-generation-blockchain-alternative/</a></p>
	
	<p class="cite"><a href="https://medium.com/hashgraph/ai-3-0-why-hashgraph-and-how-it-will-revolutionize-blockchain-and-ai-86a6ef715c9f" target="_blank">https://medium.com/hashgraph/ai-3-0-why-hashgraph-and-how-it-will-revolutionize-blockchain-and-ai-86a6ef715c9f</a></p>
				  </div>
				  
				  
				  <div id="may-18-05-01" class="           avr 18-03 -24"> 
				  <hr />  
				  <a href="#maytop"><button>Top</button></a> 
				   &nbsp; 
				  <h4 class="  title dailytech longtitle">OUR DAILY TECH:</h4>  
				  <h5 class="  subdailytech web">Web Dev Affairs</h5>  
				  <p class="  author">by Thomas Maestas, MA</p>  
				  <h6    class="  chapternumber">May 1, 2018</h6>   
				  <h6    class="dailytitle chapternumber">Technology: The Coincidental and Unintended Bane of Exercise
				  </h6>  
				  <p class="firstparagraph">May. Spring. Exercise. All wonderful things, reacquainting with Nature--if we can and <i>if we let <strong>Tech</strong> let ourselves outside</i>: Let's face it, screens  don't mix well with the sun! <</p>
				  <p>Recently  though,Tech made a real comeback in the Mother Nature department, thanks to the 2016 Pok&eacute;mon rage that drew crowds out in droves and into the streets and haphazard places over countless miles walked.  Technology, at long last assumes a new role:<i> an ever dedicated activity coach</i> According to <i>Behavioralist psychology</i>, the actions frame the state of mind, so it only makes perfect sense to set our tech devices to where we want to go!</p>
				  <p>But <i>some</i> of the benefits of exercise ...
				  </p>
				  <p class="quote"> 
				   Neurotrophins, endogenous proteins that support brain plasticity likely mediate the beneficial effects of exercise on the brain. In clinical studies, exercise increases brain volume in areas implicated in executive processing, improves cognition in children with cerebral palsy and enhances phonemic skill in school children with reading difficulty. Studies examining the intensity of exercise required to optimize neurotrophins suggest that moderation is important. Sustained increases in neurotrophin levels occur with prolonged low intensity exercise, while higher intensity exercise, in a rat model of brain injury, elevates the stress hormone, corticosterone.<sup>1</sup> 
				   </p> <p>
				   ... more on this later ...</p>
				   <p class="cite"><a href="https://www.tandfonline.com/doi/abs/10.1080/17518420801997007" target="_blank">https://www.tandfonline.com/doi/abs/10.1080/17518420801997007</a></p> 
				  </div>
				  <p> &copy; 2018 All Rights Reserved. &nbsp; |
	
				  <a style="color:yellow;text-decoration:none;" href="http://www.thomasmaestas.net">thomasmaestas.net &nbsp; |</a>
				  <a style="color:yellow;text-decoration:none;" href="mailto:thomas@ourdailytech.com"> thomas@ourdailytech.com &nbsp; |</a>
				
				
				  <a title="Contact Information: thomasmaestas.net" href="http://www.thomasmaestas.net/profile.html#contactme"> Contact Information</a>
				</p>  
				`;
	  } else {
		secretParagraphMAY.style.display = 'none';
	  }
	}
	
	console.log('blogger-june');
	function updateSecretParagraphJUNE() {
	  if (showSecretJUNE) {
		secretParagraphJUNE.style.display = 'block';
		secretParagraphJUNE.style.fontFamily = 'Roboto';
		secretParagraphJUNE.style.opacity = '1';
		secretParagraphJUNE.style.color = 'darkslategray';
	   
		
	
	 
	blogpost14 = 
	`
	<p class="quote"><i>
	All people going to the International Space Station must do so through Kazakhstan today. Since the space shuttle retired in 2011, there's no other ship capable of carrying people up there besides Soyuz, the Russian workhorse of many decades. NASA purchases seats for its astronauts; each mission is worth tens of millions of dollars. But the situation is going to change soon. 
	Two companies — Boeing and SpaceX — are developing commercial crew vehicles to carry astronauts to the ISS. They should start flying crews in the next year or two...</i><sup>1</sup>
	</p>
	<p class="firstparagraph">If there is ever a global stage marked by camaderie besides the World Cup, space would have to take a strong 2nd place--ISS collaboration breaks all bounds! But what's really going on with that place anyway? Past 2024--apparently not much, but that's because the moon is going on ...</p>
	<p class="quote">The latest [Congressional Budget Office's] request has no money for the space station past then[2024]. That's so that NASA can focus its resources on the Deep Space Gateway, a lunar space station that plays a part in the administration's request to send astronauts to the moon again before going on to Mars.
	<br /><br />
	The Europeans have expressed some interest in the Deep Space Gateway, but as for [Russian] Roscosmos, their direction is unclear. The [Russian] agency could join NASA on another space station, go on its own, or ally itself with newer space powers (such as China) for other work.<sup>1</sup>
	</p>
	<p>Besides the moon, I wouldn't be opposed to a year-and-a-half long trip to Mars--so long as I had plenty of reading material, and a round-trip ticket!
	`;
	blogcite14 = 
	`
	<p class="footnotes">1. <a href="https://www.space.com/41038-roscosmos-russian-space-strategy-commercial-crew.html"   target="_blank">https://www.space.com/41038-roscosmos-russian-space-strategy-commercial-crew.html</a>
	</p>   
	`;
	blogpost13 = 
	`
	<p class="firstparagraph">If there was ever a thing called "Continuing Education," that thing has become a learning, thinking mandate in the modern professional world. Learning to work side-by-side with our A.I. "automation workmates" has become a somewhat paradoxical burden whereby the more we learn, the more we get to shovel our work onto our <i>Ever-Cheerful automators</i>, and this is the least onerous burden I have ever had to bear...</i> It's called the <i>Abolition of boring tasks!</i> </p>
	<p>Many writers have touched on the freedom that digital automation affords us: The repetitive, mundane (i.e. mindless) tasks that once occupied days and weeks of our time can now be evaporated away in hours when we just ask for help from our digital automotons--but we first have to ask! </p>
	<p>And so, the work is no longer the work we do: <i>Our work is learning new digitally automated short-cuts, hacks, and clever work-arounds to better shovel the work off to our automotons</i>. But we can only be so clever, and so we have to learn to be more clever: hence the latest rage from colleges and universities with programs offering 'perpetual learning.' The Washington Post reports,</p>
	<p class="quote">
	
	In the future of work, robots are supposed to wipe out tons of jobs, create a bunch of new ones or deliver some combination of both. Economists predict any of these scenarios will force the average worker to do practically the same thing throughout their careers: keep learning and learning and learning.
	<br /><br />
	Some colleges in the United States are already preparing for this age of perpetual education, including the University of Michigan’s Ross School of Business. The Ann Arbor school launched a scholarship program that pays for graduates to take classes there forever, and the number of students is slowly growing.<sup>1</sup></p>
	<p>
	<p>But what really is the time-scale on this big transformation? Most things operate like they always have, and honestly, maybe we can be a little more picky about what, how, and <strong>why  we "optimize" the things we do. But that kind of old-fashioned Ludditism is not the age we live in. Today, everything has to change to stay compatible!  A more telling detail from the New York Times:</p>
	<p class="quote">And we’ve digitized only about 20 percent of the economy, meaning there’s tremendous technological climate change yet ahead. These climate changes are reshaping the ecosystem of work — wiping out huge numbers of middle-skilled jobs — and this is reshaping the ecosystem of learning, making lifelong learning the new baseline for advancement.<sup>2</sup></p>
	<p>20%? Really? So, it sounds like our productivity is <i>inversely proportional to work <strong>we</strong> do</i>, but rather the work--boring, mundane work--that we can effectively hand off to our automon partners--whatever the sector.  
	
	`;
	blogcite13 = 
	`
	
	<p class="footnotes">1. <a href="https://www.nytimes.com/2018/06/26/opinion/political-parties-climate.html"   target="_blank">https://www.nytimes.com/2018/06/26/opinion/political-parties-climate.html</a>
	</p> 
	<p class="footnotes">2. <a href="https://www.washingtonpost.com/news/wonk/wp/2018/06/06/in-the-future-college-never-really-ends/?noredirect=on&utm_term=.4d7810952eb7"   target="_blank">https://www.washingtonpost.com/news/wonk/wp/2018/06/06/in-the-future-college-never-really-ends/?noredirect=on&utm_term=.4d7810952eb7</a>
	</p>  
	
	`;
	 
	blogpost12 = 
	`
	<p class="firstparagraph">Obnoxious misuse of A.I.Tech is a rare thing because developers are among the smartest and most humane among all professions, if I my humbly claim.  But <i>Tech consumers are not necessarily bound by such thoughtful solidarity.</i> The following exemplifies the darker side of A.I. tech...                                          </p>
	<p class="quote">Cogito is one of several companies developing analytics tools that give agents feedback about how conversations with customers are going. Its software measures in real time the tone of an agent’s voice, their speech rate, and how much each person is talking, according to Dr. Place. “We measure the conversational dance,” he says.
	
	That dance is sometimes out of sync, such as when an agent speaks too quickly or too much, cuts a customer off, has extended periods of silence or sounds tired.
	<br /><br />
	When the software detects these mistakes, a notification pops up on a window on an agent’s screen to coax them to change their strategy. The alerts are useful not just for the agents, but also for their supervisors, Cogito says.<sup>1</sup></p>
	<p>For all the fanfare of A.I. and Learning algorithms, let's hope that those who wield such power will not yield to obnoxious misuse. Famed Sociologist Max Weber wrote on the over-rationalizing tendencies of bureaucratic devotion to mass production. He calls it the iron shell, and the ... </p>
	<p class="quote">"more complex idea that Weber himself sought to evoke with the "shell as hard as steel": a reconstitution of the human subject under bureaucratic capitalism in which "steel" becomes emblematic of modernity ... Further, whereas a cage confines human agents, but leaves their powers otherwise intact, a "shell" suggests ... a new kind of being.</i>" <sup>2</sup></p>
	<p>This 19th century sociologist Dr. Weber lived in simpler times, pre-dating the 1910's  industry-wide adoption of "Tayloristic" calculations in factory settings for optimized and maximum efficiency--all invented by a Factory Supervisor named Frederick Taylor, armed with a pencil and a heavy-duty clipboard!
	</p><p>
	Now imagine starting a new job with a feisty robot, as one proud supervisor proclaims: <i>"One of her 14 agents said the software noticed he wasn’t speaking with enough energy, so it prompted him with a message to pep up plus a coffee-cup icon, she says." </i><sup>1</sup>
	</i> The horror, the horror.</p>
	</p>
	`;
	blogcite12 = `
	
	
	<p class="footnotes">1. <a href="https://www.wsj.com/articles/call-center-agents-get-a-human-touch-1528984801?mod=foesummaries"   target="_blank">https://www.wsj.com/articles/call-center-agents-get-a-human-touch-1528984801?mod=foesummaries</a>
	</p> 
	<p class="footnotes">2. <a href="https://www.jstor.org/stable/2678029?seq=1#page_scan_tab_contents"   target="_blank">https://www.jstor.org/stable/2678029?seq=1#page_scan_tab_contents</a>
	</p> 
	`;
	blogpost11 = 
	`
	<p class="firstparagraph">As if Apple needed any more money--now Samsung will be writing a half-billion dollar check to right the wrongs of patent infringement and "slavish" copying.<sup>1</sup> Well, history certainly repeats itself as it was IBM that played the relentless copy-cat of Apple's technological leadership way-back-when. 
	</p>
	
	<p class="quote">Apple Inc and Samsung Electronics Co Ltd on Wednesday settled a seven-year patent dispute over Apple’s allegations that Samsung violated its patents by “slavishly” copying the design of the iPhone.<br /><br />In May, a U.S. jury awarded Apple $539 million, after Samsung had previously paid Apple $399 million to compensate for patent infringement. Samsung would need to make an additional payment to Apple of nearly $140 million if the verdict was upheld.<sup>1</sup>
	</p><p class="paragraph">Isn't it true that Apple is made by and wholly devoted to the Creatives from every sector? And thus the Creator will inevitably create followers ... I guess in retrospect my various Samsung phones and products have been "inspired" by Apple...so close, yet so far away--another case of the six-degrees of connections to a celebrity! 
	</p>
	<p>My love affair with Apple products is still riding the pink cloud--less than a year now. I have the good luck to use a Macbook Pro that feels, types, and views like a sports car. You can rev the engine by running some heavy-duty map imaging from data calculations--<i>talk about the MacBook's grace and power, when lo, your root is sitting right on top of a Linux Shell. These words come from a 25-year serf to Microsft's ownership.</i> The feel of a 1967 Corvette with very little between you and 350 Horse Power. I honestly haven't experienced this high quality since the first time I listened to Radiohead on my friend's new I-pod in 2007.  
	</p>
	<p>An Ode to Apple products: Apple! You are our Creative Leadership and your Apple Watch is beyond our realm--a postcard from another world. Apple, you alone bear the high standard of quality tech products--because you, Apple, do occupy the highest, and wealthiest, seat among the Tech Giants!
	</p>
	`;
	
	blogcite11 = `
	<p class="footnotes">1. <a href="https://www.reuters.com/article/us-apple-samsung-elec/apple-samsung-settle-u-s-patent-dispute-idUSKBN1JN2S4"   target="_blank">https://www.reuters.com/article/us-apple-samsung-elec/apple-samsung-settle-u-s-patent-dispute-idUSKBN1JN2S4</a>
	</p> 
	
	`;
	blogpost10 = `
	<p class="firstparagraph">5G Technology, ever so close to life-changing implementation, conjures up fantastic musing over how our everyday products will interact in real-time with our personalized data-cloud. Certainly IoT (Internet of Things) products will be carrying a whole lot of machine-to-machine to machine communication. From the IoT edge (encircling a router, for instance) to communicate sensors to mid-range "listeners".</p>
	<p>So, although Sprint-T-Mobile Oneness spells monopoly, the scale of work that needs to be done to convert everything to 5G <i>means we Need a great tech innovator like T-Mobile's John Legere to push with fervor the right ways to deliver 5G connectivity to every American, anywhere.</i> My<a href="#18-04-27"> April 27 post</a> talks more on their affair, but the reality is that Sprint doesn't contribute value to American innovation; that claimed, <i>Sprint's bandwidth rights and spare parts really <strong>will truly</strong>  add value</i> to American Tech!</p>
	`;
	blogcite10 = `<p class="footnotes">1. <a href="https://www.reuters.com/article/us-sprint-corp-m-a-t-mobile-us/sprint-t-mobile-defend-proposed-tie-up-before-u-s-senate-panel-idUSKBN1JN33A"   target="_blank">https://www.reuters.com/article/us-sprint-corp-m-a-t-mobile-us/sprint-t-mobile-defend-proposed-tie-up-before-u-s-senate-panel-idUSKBN1JN33A/a>
	</p> 
	`;
	
	blogpost9 =`
	<p  class="firstparagraph">
	Why the GPU rather than CPU for speed? 90% of deep learning algorithms use distributed, parallel problem-calculations. So, who needs a steering wheel racing on the Bonneville Salt Flats? Certain kinds of algorithms do, though, such as recursive, tree-traversing kinds. But I'm just a tourist.
	</p> 
	
	<p class="quote"><i>
	[Alex Khrizhevsky] says he recalls reading some paper about matrix multiplication algorithms on the GPU (I don’t know the specific one), and basically the idea he had at the time was just to re-implement the original Lenet architecture[1], but use the GPU to train a network (of unprecedented size in 2012) really fast.
	</i><sup> 1</sup></p>
	
	<p>Evolution of these new AI's, and AI's designing AIs, require voracious amounts of training data to implement and improve learning designs.  So where would AI research stand if not for the ultra-fast and efficient modern-day Graphical Processing Unit? Better asked, what inspired Krizhevski's novel, paradigm-shattering design?  Clearly <i>the Need for Speed!</i> </p>
	 
	  `;
	blogcite9 = 
	`
	<p class="footnotes">1. <a href="https://www.quora.com/How-did-Alex-Krizhevsky-come-up-with-the-idea-of-AlexNet-How-does-the-designer-think"   target="_blank">https://www.quora.com/How-did-Alex-Krizhevsky-come-up-with-the-idea-of-AlexNet-How-does-the-designer-think</a>
	</p>
	
	 
	`;
	  blogpost8 = 
	  `  <p class="quote"><i>
	Deep learning allows computational models that are composed of multiple processing layers to learn representations of data with multiple levels of abstraction. These methods have dramatically improved the state-of-the-art in speech recognition, visual object recognition, object detection and many other domains such as drug discovery and genomics. Deep learning discovers intricate structure in large data sets by using the backpropagation algorithm to indicate how a machine should change its internal parameters that are used to compute the representation in each layer from the representation in the previous layer. Deep convolutional nets have brought about breakthroughs in processing images, video, speech and audio, whereas recurrent nets have shone light on sequential data such as text and speech.</i><sup>1.</sup>
	</p> 
	  <p class="firstparagraph">Artificial Intelligence has evolved from a prototypal event known as the "Cambrian Explosion, only five years ago."<sup>1</sup> An architect named Alex Krizhevsky offered a new paradigm for <i>deep learning</i> at an image recognition event, Imagenet Competition. Mr. Krizhevsky's "Alex Net" became the pivotal <i>Convolutional Neural Network</i>, with a mere 8 layers' depth (think of the decision tree mentioned in post 6/20) &amp; millions of parameters. </p>
	
	<p>The handwriting-signature recognition algorithm is still in use today! The design--using a training technique called "Stochastic Gradient Descent", by Geoff Hinton--blew the competition away and revolutioned machine learning. </p>
	<p>Today, neural netwoks boast <i>hundreds of layers and billions of paremeters: The last five years has been busy!</i> And the varied species of designs since the original Convolutional Neural Network (CNN) include Recurrent Neural Networks (RNN), Generative Adverserial Networks (GAN) and Reinforcement Learning.
	</p> 
	`;
	blogcite8 = 
	`<p class="footnotes">1. <a href="https://www.nature.com/articles/nature14539"   target="_blank">https://www.nature.com/articles/nature14539</a>
	</p> 
	
	<p class="footnotes">2. <a href="https://papers.nips.cc/paper/4824-imagenet-classification-with-deep-convolutional-neural-networks"   target="_blank">https://papers.nips.cc/paper/4824-imagenet-classification-with-deep-convolutional-neural-networks</a><br />
	PDF:  <a href="https://www.nvidia.cn/content/tesla/pdf/machine-learning/imagenet-classification-with-deep-convolutional-nn.pdf"   target="_blank">https://www.nvidia.cn/content/tesla/pdf/machine-learning/imagenet-classification-with-deep-convolutional-nn.pdf</a>  
	</p> 
	`
	
	blogpost7 = 
	  `  <p class="quote"><i>I sat one evening in my laboratory; the sun had set, and the moon was just rising from the sea; I had not sufficient light for my employment, and I remained idle, in a pause of consideration of whether I should leave my labour for the night, or hasten its conclusion by an unremitting attention to it. As I sat, a train of reflection occurred to me, which led me to consider the effects of what I was now doing. <br />
	  <br />
	  --Victor Frankenstein<sup>1</sup>
	  </i><br /> 
	</p>
	<p class="firstparagraph">Nvidia's latest 12" by 4" by 4" GPU accelerates algorithmic work from 1<sup>1/2</sup> months to 4 days. The most recent exponential leaps in computing power--most notably for A.I. purposes, are thanks only to the Graphical Processing Unit. Progress followed a linear path in as 1998 world, a world enlightened by the pivotal A.I. publication, "Convolutional Neural Netowrks for Handwritten Digital Recognition" (Lecun, Bottou, <strong>Bengio</strong>, Haffner, 1998) to the present use in blockchain computing and deep learning algorithms, among many other purposes. The technical advantage offered by Nvidia explained by 2012's "ImageNet Classification with NVIDIA GPUs (Krizhevsky, Hintou, et al.). Ten years ago, Daniele G. Spamintato and Anne C. Elstery offer a succinct explanation:
	</p>
	<p class="quote">Optimization algorithms are becoming increasingly more important in many areas, such as finance and engineering. Typically, real problems involve several hundreds of variables, and are subject to as many constraints. Several methods have been developed trying to reduce the theoretical time complexity. Nevertheless, when problems exceed reasonable sizes they end up being very computationally intensive. Heterogeneous systems composed by coupling commodity CPUs and GPUs are becoming relatively cheap, highly performing systems.
	<br />
	<br /> Recent developments of GPGPU technologies give even more powerful control over them. In this paper, we show how we use a revised simplex algorithm for solving linear programming problems originally described by Dantzig for both our CPU and GPU implementations. Previously, this approach has showed not to scale beyond around 200 variables. However, by taking advantage of modern libraries such as ATLAS for matrix-matrix multiplication, and the NVIDIA CUDA programming library on recent GPUs, we show that we can scale to problem sizes up to at least 2000 variables in our experiments for both architectures. On the GPU, we also achieve an appreciable precision on large problems with thousands of variables and constraints while achieving between 2X and 2.5X speed-ups over the serial ATLAS-based CPU version. With further tuning of both the algorithm and its implementations, even better results should be achievable for both the CPU and GPU versions.<sup>2</sup></p>
	<p>So, given the exponential development advantages of GPU use, it's clear the horizon for more and more developers implicates high computing needs.  So, what exactly is novel yet increasingly a household developer tool? </p>
	<p class="quote">
	CUDA® is a parallel computing platform and programming model developed by NVIDIA for general computing on graphical processing units (GPUs). With CUDA, developers are able to dramatically speed up computing applications by harnessing the power of GPUs.<br /><br />
	
	In GPU-accelerated applications, the sequential part of the workload runs on the CPU – which is optimized for single-threaded performance – while the compute intensive portion of the application runs on thousands of GPU cores in parallel. When using CUDA, developers program in popular languages such as C, C++, Fortran, Python and MATLAB and express parallelism through extensions in the form of a few basic keywords.
	<br /><br />
	The CUDA Toolkit from NVIDIA provides everything you need to develop GPU-accelerated applications. The CUDA Toolkit includes GPU-accelerated libraries, a compiler, development tools and the CUDA runtime.
	<sup>3</sup></p>
	<p>And, this tech is arriving at both the mainstream PC-optimization level as much as typical university research, the potential of both laid out in a June 2018 Wired Magazine article:</p>
	<p class="quote">PCs that work on smartphone parts. Devices that run all day, but for real this time. A 32-core hellbeast processor. The first GPU shrunk down to a 7nm process. Always-connected 5G laptops. And while not a PC, the ASUS ROG put vapor cooling in gaming-focused smartphone. (Vapor cooling. In a smartphone.) 
	<br /> . . .
	<br />And then there's arguably the real star of the show, an AMD prototype of the first-ever GPU built on a 7nm process. Unlike some of the other blockbuster announcements out of Taipei this week, this one won't make its way to your computer any time soon. It'll find a home in data centers, helping AI and machine learning compute at blistering speeds, using a lot less energy to do so.<sup>4</sup>
	  </p>
	  <p>And so, with blistering speed and the joining of disciplines of science, the spear's tip of innovation accelerates ... without a spare nanosecond for reflection!
	  `;
	
	  blogcite7 =  `<p class="footnotes">1. Frankenstein, or Modern Prometheus, Mary Shelley, 1818. <br /><a href="https://www.gutenberg.org/files/84/84-h/84-h.htm"   target="_blank"> PDF https://www.gutenberg.org/files/84/84-h/84-h.htm</a>
	  </p>  
	  
	  <p class="footnotes">2.  <a href="https://www.gutenberg.org/files/84/84-h/84-h.htm"   target="_blank">2009 IEEE International Symposium on Parallel & Distributed Processing</a>
	  </p>  
	  <p class="footnotes">3.  <a href="https://developer.nvidia.com/cuda-zone"   target="_blank">https://developer.nvidia.com/cuda-zone</a>
	  </p> 
		 <p class="footnotes">4.  <a href="https://www.wired.com/story/computex-2018-new-chips-qualcomm-amd-intel/"   target="_blank">https://www.wired.com/story/computex-2018-new-chips-qualcomm-amd-intel/</a>
	  </p>  
	  
	  `;
	 
	blogpost6 = 
	  `
	  <p class="firstparagraph">
	  <p class="firstparagraph">Small, online businesses face the music today to pay state sales taxes, thanks to the Supreme Court's <i>Wayfair V. South Dakota</i>.<sup>2</sup> My <a href="#18-04-14">April 14th blog</a>, <i>Clash of the Brick &amp; Mortars against Online Stores</i> goes more in depth... </p>
	  <p>What this means is that imminently, 50 variations of newly permitted State internet sales taxes for small businesses.<sup>2</sup> This will inevitably hurt variety, and likely lead to a lot of inter-state confusion: </p>
	  <p class="quote">The new law may seem straightforward, but there are fairly complicated specifics when it comes to different jurisdictions and categorization of goods.
	<br /><br />
	  For example, New Jersey places a tax on marshmallows, which are considered candy and a luxury, but they don’t tax marshmallow fluff which is considered food. In some states Kitkat bars are categorized as food because they contain flour, but a snickers bar is candy. Meanwhile a snickers ice cream bar, which needs to be refrigerated, would be considered food and not taxed.<sup>1</sup></p>
	  <p>Small, online businesses: Get your calculators ready!
	  </p> 
	 `;
	  
	 
	
	  blogcite6 =  ` 
	  <p class="footnotes">1.  <a href="https://www.forbes.com/sites/advisor/2018/06/21/state-sales-tax-which-states-are-most-affected-by-the-supreme-court-online-retail-ruling/#791a05383e66"   target="_blank">https://www.forbes.com/sites/advisor/2018/06/21/state-sales-tax-which-states-are-most-affected-by-the-supreme-court-online-retail-ruling/#791a05383e66</a>
	  </p> 
	  
	  <p class="footnotes">2.  <a href="http://money.cnn.com/2018/06/21/technology/wayfair-vs-south-dakota/index.html"   target="_blank">http://money.cnn.com/2018/06/21/technology/wayfair-vs-south-dakota/index.html</a>
	  </p> 
	  
	  `;
	  blogpost5 = ` 
	  <p class="firstparagraph">What difference does it make for Net Neutrality to morph into 50 different variations now that the neutrality protections leave the federal arena to fall into  state legislation?<sup>1</sup> Who can tell. Unfortunately, a potential micro-balkanization of bandwith rules within an interdependent network doesn't spell faster service for anyone. </p>
	  
	  <p>
	  What people seem to forget is that the key win for the 2015 net neutrality laws were merely <i>a small reflection of the larger significance of <strong>the net's reclassification as a service, like water, natural gas, and electricity.</i></strong> State legislators need to focus on the air we breathe as critical to providing enough at reasonable cost, to merely survive in the times.</p>
	  <p>After all, the internet venues are what color the web...the last thing we need is the vast and varied imagination of 5 umbrella content-providers. Wired Magazine makes a good point that </p>
	  <p class="quote">California's current legislative debates may lead the precedent for others, more influential than Seattle's--California's economy is equally sized with France at 2.5 trillion. 
	  <br />
	  <br />[California State Senator Scott Wiener's] original bill included all the major provisions of the FCC's old rules, which banned broadband providers from blocking, throttling, or otherwise discriminating against lawful content. But it went further than the FCC rules by banning companies from blocking or throttling content as it enters their network from other networks, under so-called interconnection agreements.<sup>2</sup> </p>   
	  <p>The Internet, after all, is a Network, and a network is by definition a singular entity.</p>
	  `;
	 
	
	  blogcite5 =  ` 
	  <p class="footnotes">1.  <a href="http://www.latimes.com/politics/la-na-pol-court-online-taxes-20180621-story.html"   target="_blank">http://www.latimes.com/politics/la-na-pol-court-online-taxes-20180621-story.html</a>
	  </p>
	  <p class="footnotes">2.  <a href="https://www.wired.com/story/california-net-neutrality-bill-was-hijacked-lawmaker-says/"   target="_blank">https://www.wired.com/story/california-net-neutrality-bill-was-hijacked-lawmaker-says/</a>
	  </p>
		`;
	
	  blogpost4 =  `<p class="quote"><i>
	  They left The Denver Post amid newsroom layoffs and interference in the editorial process by the newspaper’s hedge-fund owners. And now those reporters and editors are creating their own news outlet, The Colorado Sun.  They will be partnering with the Civil Media Company, an ambitious New York start-up that aims to use blockchain technology and crypto economics to start 1,000 publications nationwide by the end of the year. </i>
	  <br /><br />- New York Times, June 17, 2018</p><br />
	  <p class="firstparagraph">Power from the 4th Estate tends to flow in the form of printers' ink, however Blockchain Tech empowers journalists with  new resources for their trade: free money and data, and more importantly, an empowered readership in Cooperative form: 
	  </p>
	  <p class="quote">
	  The new publication will have a conventional website whose data will be written permanently into the secure digital ledger known as the blockchain. Expenses for the fledgling outlet will be covered by a grant from Civil, whose sole investor, for now, is ConsenSys, a Brooklyn-based blockchain software technology company founded by the Canadian entrepreneur Joseph Lubin. Mr. Lubin is also a co-founder of the Ethereum, a virtual currency and blockchain database platform. As part of its plan to fund new media entities, Civil plans to unveil a new token this summer called CVL.
	<br /><br />
	People who purchase the CVL token, a form of cryptocurrency, will have a say concerning the projects hosted by Civil — meaning that they can vote on whether one of its websites violates the company’s journalism standards, which are outlined in the Civil Constitution.<sup>1</sup> 
	  </p>
	  <p>Who would have guessed that through Crypto-Currency for money and Distributed Ledger Tables for data, modern Journalism would rise from the ashes of tech-induced impoverishment and so-called 'fake-news' delegitimization to regain limitless ink for influence, with a renewed and democratized legitimacy.  <br />
	  <br />
	  Thank you, Blockchain, for restoring Truth to Power!
	  </p>
	  `;
	
	  blogcite4 =  `
	  <p class="footnotes">1.  <a href="https://www.nytimes.com/2018/06/17/business/media/denver-post-blockchain-colorado-sun.html"   target="_blank">https://www.nytimes.com/2018/06/17/business/media/denver-post-blockchain-colorado-sun.html</a>
	  </p>
	  
	  `;
	blogpost3 =  `<p class="firstparagraph">Deep Learning--a 70's thing--clearly predates   personal computing, the web, and even the 70's Show. But the true advances have been a long time in development, and credit belongs to Statistics and Data Science, and specifically quantitative analysis' ever cleverer classification trees that deliver the goods with greater accuracy, coupled with less intensive computing costs. And this origin is interesting in itself: </p>
	 <p class="quote">
	Fifty years have passed since the publication of the first regression tree algorithm. New techniques have added capabilities that far surpass those of the early methods. Modern classification trees can partition the data with linear splits on subsets of variables and fit nearest neighbor, kernel density, and other models in the partitions ... <br />
	<br />Classification And Regression Trees (CART) (Breiman et al., 1984) was instrumental in regenerating interest in the subject. It follows the same greedy search approach as  Automatic Interaction Detection (AID) and THeta Automatic Interaction Detection (THAID), but adds several novel improvements. Instead of using stopping rules, it grows a large tree and then prunes the tree to a size that has the lowest cross-validation estimate of error. The pruning procedure itself is ingenious, being based on the idea of weakest-link cutting, with the links indexed by the values of a cost-complexity parameter. This solves the under-fitting and over-fitting problems of  AID and THeta Automatic Interaction Detection (THAID), although with increased computation cost.<sup>1</sup>
	</p>
	<p>Today, Machine Learning curricula usually begin with the same sample datasets on Iris characteristics (pictured below)</p>
	<img style="min-width:300px;"  src="dist/img/learningData.PNG"><br /><br />
	<p>So how does it really work, in oversimplified terms? Contrary to most algorithms' step-by-step manual decision-making through for- and while-loops, if-else, and so on, the scalability of design clearly falls off. Enter Deep Learning, which is nothing more mystical than simple classification--i.e. decision--trees. Beginning with a million choices, a decision passes through multiple layers that may or may not be activated, and with each activated layer, a decision is narrowed down, until finally a decision is reached between recognizing a dog and a cat!
	</p><img style="min-width:300px;" src="dist/img/classifTree.PNG">
	</p><img style="min-width:300px;" src="dist/img/classifTree2.PNG"><br /><br />
	<p>And yet, for all of this science, up until 2011, the error rate for simple shape recognition, like say a dog from a cat still averaged a 26% error rate! A mere 7 years later? Today, that error rate averages less than 3% error, most recently due to computing, power, and memory advances.   Those come in handy for delivering a warehouse worth of computing onto your smartphone! That's a boon for delivering sensors, i.e. training data, into the environment. My last post mentioned Google's upcoming, yet unnamed Android OS...but we do know it's a candy that starts with "P"...my guess is Peppermint Patties? Or maybe Pez has more of a ring to it.</p>  
	<p  >
	Whatever the new OS is called, it comes with a developing potential to exponentially advance <i>Tree Science</i>:  ML Kit behaves like an API layer connecting the ML software to the app developers' models, making dev easy to run and deploy with an "experimental model compression flow that aims to reduce model size (up to orders of magnitudes) while maintaining similar accuracy."<sup>3</sup> Talk about maturing exponentially quickly! Now, this origin story can't compete with Wolverine's nor Han Solo's, but this gem carries a mythical and futuristic potential to satisfy screen-goers from all devices, frame-sizes, and platforms!</p>
	`;
	
	blogcite3 = `
	
	<p class="footnotes">1. Loh, W. Y. (2014). Fifty years of classification and regression trees. International Statistical Review, 82(3), 329-348.
	<a href="https://onlinelibrary.wiley.com/doi/full/10.1111/insr.12016"   target="_blank">https://onlinelibrary.wiley.com/doi/full/10.1111/insr.12016</a>
	</p>
	
	<p class="footnotes">2. Classification and Regression Trees Leo Breiman, Jerome Friedman, Charles J. Stone, R.A. Olshen (1984).
	<a href="https://www.taylorfrancis.com/books/9781351460491"   target="_blank">https://www.taylorfrancis.com/books/9781351460491</a>
	</p> 
	
	<p class="footnotes">3. 
	<a href="https://developers.google.com/ml-kit/"   target="_blank"> https://developers.google.com/ml-kit/</a>
	</p>
	<p>Images:Maurice Roux
	Université Marseille 3
	Saint-Jérôme</p>
	`;
	
	blogpost2 = 
	`
	<p class="firstparagraph">
	The upcoming Android 'P' OS--still in beta and only available on Pixel phones, Essential, and a few others--promises a new era in mobile app development<sup>1</sup>  Most features, like expanding Maps' indoor functionality, inclusive Emojis, and a revamped navigation bar are all nice, but one element of the build empowers app developers' access to machine-learning code: 
	</p>
	<p class="quote"> With  ML, i.e. machine-learning, Kit, app developers can use Google’s machine learning tasks within their own apps. ML Kit allows developers to use the camera for face detection, landmark recognition, text recognition, and a host of other recognition features.<sup>2</sup></p>
	<p>
	So, in conceptual terms, this means developing app-data models that are <i>optimized for mobile inference</i>. This means that the long process of acquiring enough training data to optimize an app's design or behavior (generally or specifically user personalization), can now be shortened with better quantity and quality of training data &aacute; la machine learning. So in concrete terms, the past 15 years' of Google ML research is now distilled into (again, still beta) an SDK (software developers' kit) that facilitates dev integration without needing to hand-make a model to access the run-time environment. 
	</p>
	<p>In other words, past server-side inferences now jump to the mobile device, and tap into   on-device machine learning library framework and toolkit--i.e. TensorFlowLite. This jump-starts customized application of machine learning already in production--that is, Android devices' <i>Neural Networks API</i> and <i>iOS' Metal</i>.  
	</p>
	<p>What makes this new programming horizon most interesting is that an equally new feature, called "Actions" and "Slices",  allows for certain app features to be accessed by the phone itself outside of the app. A May 8th Verge article explains:
	
	</p>
	<p class="quote">
	Google is introducing developers to a couple of terms: “Actions” and “Slices.” They are essentially deep links into apps that are able to surface in other parts of the operating system. Actions are analogous to Actions on Google Assistant; Slices are a subset that can show the app’s own UI when you type out a global search on the phone.
	<br /><br />
	The idea behind both of these concepts is to break out the different pieces of the apps you use into the larger operating system. Samat calls it the “decomposition of apps,” though without the connotations of death. “Yeah, you want to go the app,” he says, “but actually what you want to do is go to your house or reorder from Instacart.”
	<br /><br />
	Developers will need to build some frameworks into their apps to make Actions and Slices available to the system. When they do, the AI in Android P will try to understand what those apps can actually do and suggest those actions to you. “When you modularize the app, it’s not just an API call,” Samat says. “You have these components that can be understood by the system, predicted by the system, and then rendered by the system.”<sup>3</sup>
	</p>
	<p>So what does this mean? Better, higher-quality time spent with your work or play, rather than hopping from one icon to the next for each and every task...`;
	  blogcite2 = `
	
	  <p class="footnotes">1.
	
	  <a href="https://developer.android.com/preview/devices/"   target="_blank"> https://developer.android.com/preview/devices/</a>
	 
	  </p>
	  <p class="footnotes">2.
	
	  <a href="https://www.digitaltrends.com/mobile/google-android-p-news/"   target="_blank"> https://www.digitaltrends.com/mobile/google-android-p-news/</a>
	 
	  </p>
	  <p class="footnotes">3.
	
	  <a href="https://www.theverge.com/2018/5/8/17327302/android-p-update-new-features-changes-video-google-io-2018"   target="_blank"> https://www.theverge.com/2018/5/8/17327302/android-p-update-new-features-changes-video-google-io-2018</a>
	 
	  </p>
	  `
	blogpost1 =  `<p class="firstparagraph">Blockchain technologies, i.e. Government contracts, Business contracts, Bitcoin and other
	
	cryptocurrencies, all rely on network graph theory, both on the low-level programming technology (peer-to-peer global
	
	ip networks) across the spectrum to high-level interfaces for institutional, corporate, individual needs and uses.
	
	These blockchain &quot;network&quot; analyses depend on highly variable--and simultaneous--network changes, node
	
	changes, and link changes; and, the latter three may arbitrarily change interdependantly or not.</p>
	
	
	
	<p>Therefore, blockchain technologies must first accomodate  complex node variables, including one- or two-way contracts (relationships) that
	
	 depend on<i> arbitrarily hierarchical mappings and conditional data structures.</i> Secondly, blockchain tech must face analytical
	
	challenges that arise from informal practices<sup>1</sup><span class="new">--you can survey opinions, but how do you measure whim?</span>
	The organizational nodes (employees) choose to deviate from their employment roles&#39; protocol <span class="new">because it it is sunny outside, or maybe because the traffic was long today, or because a butterfly's wing-swish cooled a rash decision down to reason.  That small detail often trumps statistical patterns of efficiency, convenience, company culture, and multiple other levels of analysis of human factors.</p>
	
	
	
	<p>Sociologists Meyer &amp; Rowan&#39;s (1977)
	
	<i>New Institutionalism</i> explains how employees change practices and decouple
	
	<i>actual</i> organizational structure from recorded rules, as a function of organizational size, time, convenience,
	
	etc. Noone can argue against this wall of reason. <span class="new"><i> The problem is not the reason, the problem is the static, frozen wall called Social Science Theory, constructed from a pastiche of different meanings</i> and arbitrary theoretical starting points.  <span class="new">The esteemed Scholar of Comparative Politics, Dr. Ellen M. Immergut, undermined modern sociology concepts in 1998--a logical blow from which Sociology has never recovered (nor yet faced). She writes:</span>
	</p>
	<p class="quote new">
	Further confusion has arisen because the new institutionalists do not propose one generally accepted definition of an institution, nor do they appear to share a common research program or methodology. In fact, three separate branches of scholarship--rational choice, organizational theory, and historical institutionalism -- all lay claim to the label, seemingly without adhering to an overarching theoretical framework.<sup>3</sup></p>
	<p class="new">
	In other words, the long-standing Civil War within the discipline of Sociology (beginning with Functionalists' irreconcilable contradictions of Conflict Theorists' entire World-View--and vice-versa). From this initial schism begins the disassembling of the discipline--as it stands until today. 
	All of that talent and no single vision to harness a lasting explanatory platform.  And this is <i>before</i> addressing--from a Scientific Method Paradigm--the problem of continually new, unknown constraints on data that must be intimately understood without falling back to the old, "USA Today" habits of 'Theoretical Relativism'.</p>
	</span>
	<p>
	So, how do we recognize unwritten, soft rules and behaviors of a bank, a person,
	
	or a company&#39;s internal bot?</p> 
	
	<p>The hard sciences domain of Software Engineering, Computer Science, and Mathematics have brilliantly brought the
	
	world the blockchain tool, based on a <span class="new"><i>technical, numerical aptitude--numeracy--for which the Hard Sciences can and must share and propogate it's technical expertise and higher standard of metric truth</i><s style="color:purple" class="strike-purple"> not contribute everything, especially relating with</s> to the other sciences that are still lagging behind--namely The Discipline of Sociology</s> toward acclimating to the modern age's social priorities and needs. Ask yourself, how well do 1,000 top blockchain-related programmers understand the multi-dimensional layers of hierarchical social, corporate, and governmental relationship networks--probably 700 of the 1,000. And how many social scientists can understand the technological sciences? Probably 200 out of 1,000. This means that <i>a chunk of the scientific displines suffer from acute innumeracy</i>. So how do we bridge this massive knowledge gap between qualitative meaning in the smart-contract?</span></p>
	
	<p>In the past, the layers of abstraction from raw technological tool to societal use was refined, improved, integrated through multiple layers of &quot;middlemen&quot;, such as lawyers, corporate lawyers, government institutions, non-governmental, non-profit and for-profit actors. Blockchain technology, by its very nature, erases the middlemen. Suddenly, one programmer, for example, is writing the same healthcare insurance crypto-contract, that last month an entire team of hospital employees spent a month writing; then overseeing and managing different facets of this same thing.</p>
	
	
	
	<p>However, the crypto-contract, once deployed to the blockchain, auto-manages the rest, forever or for the life of
	the contract. Therefore, rather than redoing the trials and errors of 200 years&#39; Sociology Network Analysts&#39;
	research and analytical development. <span class="new"> Therefore, much of the social scientists have arrived at the end of the line of technology, still shackled to analog methodology relegated to the Sine and Cosine of progress; while the World leaves it behind, led by the Hard Sciences of Software Engineering--the new social fabric of the 21st Century. So, can the anthropological and social domains survive this existential threat to any authority--that depends if the Hard Sciences, Gatekeepers of Empirical Science will extend an open door and pro-actively share technical instructions for the soft sciences.  Therefore, the social sciences are not safe hiding at home, within the academic
	tower--far removed from the pace of societal and technological change.  
	 </p>
	 
	
	<p class="new">The point is this: The innumeracy of the Soft Sciences increasingly loses authority, with the less it can prove at the Command Line Interface. So, how will an analog academic field in the early 21st century compete with artifical intelligence? Problems grow exponentially in the modern age, and only the sciences with  machine-learnig on their side can expect to thrive by applying extraordinary applications of machine-learning to network theories. <span class="new">
	 Sociologists deal with real-time, logical and hierarchical network mappings that appear arbitrary, yet are characterized by fixed patterns. This implies a higher level of competency to accurately judge a point-of-view without the ability to directly consult machine learning. <i>This is a Code or Be Coded moment in the life trajectory of the social sciences.</i></span></p>
	
	
	
	<p>  <i>the Power  of the Social Sciences, even while paraliyzed, cannot be underestimated:</i> No other academic field than sociology has advanced into the details, and endless network rabbit-holes that characterize societal behavior. Not until this second millenial decade could the marriage of Large Number Statistical Theory
	
	become consumated with the brilliance of early 1900&#39;s Sociological French Network Theories, like Maurice Halbswach&#39;s
	
	work on the clearly defined network patterns of a society&#39;s Collective Memory.</p>
	
	
	
	<p>So, current sociology, having collected and refined knowledge on network arbitrariness, such that Economic&#39;s &quot;irrational
	
	behaviors&quot; and Mathematical &quot;complexity models&quot; do not
	
	<i>touch to the bone</i> the meaning, the intersectionality of network analysis, which must incorporate simultaneous
	
	node changes (person gets job /or/ does not get job), network changes (All get jobs /or/ only 3 of 15 network groups
	
	get jobs), and most importantly the
	
	<i>relationship</i> changes (all jobs always useful /or/ half of job groups no longer useful) across time and fixed.</p>
	
	
	
	<p>Fine. So, why is Sociology&#39;s network theory so valuable, yet inaccessible, beyond just the network insights gleaned from 19th and
	
	20th centuries&#39; network problems?  European sociology came of age in the analog social era, while North
	
	American Sociology only recently come of age (Quebec in the 1960&#39;s [post-1968], U.S. in the 1990&#39;s[post-1999],
	
	in the digital social era. Therefore, the problem-solving patterns of past sociology are inherently small-data and
	
	more qualitative analysis, and thus only Sociology incorporates &quot;human-ness&quot; into the billion rows and
	
	columns of quantitative--numbers-only--analysis.</p>
	
	
	
	<p>For example, Oxford-developed S.I.E.N.A. Software accomplishes this task. SIENA--named for Simulation Investigation
	
	for Empirical Network Analysis--software calculates the real-time values, direction, and conditions of each relationship
	
	(link) in a network, simultaneously as each node, network, or alter-link changes or is changed; with this, it is
	
	possible to isolate directional, conditional
	
	<i>influence change</i> in real-time. Real-time sounds impossible, however, the SIENA documentation
	
	<sup  >2</sup> describes its program algorithm to the statistical analysis of network data, with the focus on social networks.</p>
	
	
	
	<p>An easy example to grasp this is the concept of whether a person
	
	<i>self-selects </i>(e.g., due to subconscious leanings) into a group and thus matches to fruition the group&#39;s
	
	behavior with little group influence? Or does this same person join a group and emulates the group&#39;s behavior,
	
	by the group&#39;s influence over time. Sociological network analysis, using Snjder&#39;s SIENA software, achieves
	
	the impossible with the closed, directed graph networks that characterize blockchain technology. The network graph
	
	can be here understood as entire (complete) networks (i.e, the blockchain in its entirety without hard forks), not
	
	as personal (egocentered) networks: Using this SIENA model allows for the necessary assumptions that a set of nodes
	
	(social actors) is given, and all ties (links) between these nodes are known - except perhaps for a moderate amount 
	of missing data</p> 
	
	<p>If, and only if, this level of analysis may be achieved, the blockchain development may follow a linear, directed
	
	path of maturity with social and world needs.<span class="new"> Until   Social Science Network Theorists stop from basing their numerical analysis on the mutable sand of theory, rather than theory based on the   foundation of numerical science, <i>any attempt at conclusion...you guessed it...cannot be conclusive.</i>So, the social sciences must consult the hard sciences, otherwise they risk squandering countless years of talented theorists' work; <i>the discipline's executive functions are cut off from it's increasingly inaccessible (and increasingly powerful) knowledge base.</i> --Such a talented, powerful Thoroughbred of a Science, that still wanders without a head for technical direction.</span></p>
	`;
	
	blogcite1 = `
	<p class="footnotes">1. 
	<a href="http://www.journals.uchicago.edu/doi/abs/10.1086/226550"   target="_blank"> http://www.journals.uchicago.edu/doi/abs/10.1086/226550</a>
	 
	
	</p>
	
	<p> 
	2. 
	<a href="https://www.stats.ox.ac.uk/~snijders/siena/"  target="_blank"> https://www.stats.ox.ac.uk/~snijders/siena/</a>
	<br />
	<p class="footnotes">3. The Theoretical Core of the New Institutionalism, Ellen M. Immergut: Politics &amp; Society, Vol. 26, Issue I, pp. 5-34 
	<a href="http://journals.sagepub.com/doi/abs/10.1177/0032329298026001002?journalCode=pasa
	"  target="_blank">http://journals.sagepub.com/doi/abs/10.1177/0032329298026001002?journalCode=pasa
	</a>
	</p>
	` ;
	
	  var url =  
	  [ 
	  {
		id:'14', 
	  did:'06-30-18',
	  date:'June 30-July 1, 2018<br />Weekend ',
		author:'by Thomas Maestas',
		cat3:'Sociology Tomorrow!',
		title:'The Space Powers that Be:<br />When Boeing issues a Ticket to the Moon', 
		post:blogpost14,
	   blogcite:blogcite14
	 },{
	  id:'13', 
	did:'06-29-18',
	date:'July 29, 2018',
	  author:'by Thomas Maestas',
	  cat3:'A.I.Now',
	  title:'A.I. &amp; Work, Part II<br />Learning to Learn alongside a Cheerful Automoton Work-Partner', 
	  post:blogpost13,
	 blogcite:blogcite13
	},
	 {
		id:'12',
	   
	  did:'06-28-18',
	  date:'June 28, 2018 ',
		author:'by Thomas Maestas',
		cat3:'A.I.Now',
		title:'A.I. &amp; Work, Part I<br />Fighting Obsessive Compulsive Quantitative Optimization Disorder and the Slide into a Weberian Iron Shell',
	
		post:blogpost12,
	   blogcite:blogcite12
	 },{
		id:'11',
	   
	  did:'06-27-18',
	  date:'June 27, 2018 ',
		author:'by Thomas Maestas',
		cat3:'Web Dev Affairs',
		title:'Apple: You are our Tech Leader!',
	
		post:blogpost11,
	   blogcite:blogcite11
	 }, {
	  id:'10',
	  did:'06-26-18',
	  date:'June 26, 2018 ',
		author:'by Thomas Maestas',
		cat3:'Sociology Tomorrow!',
		title:'T-Nation Makes the Case: Sprint Merger takes on the Senate',
		
	  post:blogpost10,
	 blogcite:blogcite10
	},  {
		id:'9',
		did:'06-25-18',
		date:'June 25, 2018 ',
		author:'by Thomas Maestas',
		cat3:'A.I.Now',
		title:'Modern Prometheus, Part III: <br />Accelerating Evolution of Neural Networks &agrave; la Nvidia GPU',
		post:blogpost9,
	   blogcite:blogcite9
	 },  {
		id:'8',
		did:'06-23-18',
		date:'June 23-24, 2018<br />Weekend',
		author:'by Thomas Maestas',
		cat3:'A.I.Now',
		title:'Modern Prometheus, Part II: <br />Broadening Evolution of Deep Learning Species &agrave; la Neural Network',
		post:blogpost8,
	   blogcite:blogcite8
	   },   { 
		id:'7',
		did:'06-22-18',
		date:'June 22, 2018',
		author:'by Thomas Maestas',
		cat3:'A.I.Now',
		title:'Modern Prometheus, Part I.<br />Made from 8 billion transistors and 1,000 Cuda Cores:<br /> Today\'s Irreplaceable NVidia GPU',
		post:blogpost7,
	   blogcite:blogcite7
	   }, { 
		id:'6',
		did:'06-21-18',
		date:'June 21, 2018',
		author:'by Thomas Maestas',
		cat3:'Sociology Tomorrow!',
		title:'"Taxation Without Representation is Tyranny!"<br /><br />-- James Otis, 1776',
		post:blogpost6,
	   blogcite:blogcite6
	   }, 
	   { 
		id:'5',
		did:'06-20-18',
		date:'June 20, 2018',
		author:'by Thomas Maestas',
		cat3:'Sociology Tomorrow!',
		title:'A Healthy Internet is a Fast, Cooperative Internet: <br />Net Neutrality Protections move to State-Level Legislation',
		post:blogpost5,
	   blogcite:blogcite5
	   }, { 
		id:'4',
		did:'06-19-18',
		date:'June 19, 2018',
		author:'by Thomas Maestas',
		cat3:'Musing Blockchain',
		title:'Rise of the Embattled 4th Estate',
		post:blogpost4,
	   blogcite:blogcite4
	   },   
		{ 
		id:'3',
		did:'06-18-18',
		date:'June 18, 2018',
		author:'by Thomas Maestas',
		cat3:'A.I.Now',
		title:'Machine Learning, Democratized:<br />Part II: Deep Learning\'s Origin Story',
		post:blogpost3,
	   blogcite:blogcite3
	   },  { 
		id:'2',
		did:'06-16-18',
		date:'June 16-17, 2018<br />Weekend',
		author:'by Thomas Maestas',
		cat3:'Sociology Tomorrow!',
		title:'Machine Learning, Democratized<br />Part I: Google\'s ML Kit',
		post:blogpost2,
	   blogcite:blogcite2
	   }, 
		{ 
		id:'1',
		did:'06-15-18',
		date:'June 15, 2018',
		author:'by Thomas Maestas',
		cat3:'Musing Blockchain',
		title:' The Spectre of a Headless Horseman:<br /> Why  Sociologists <i> are<span class="new">n\'t </span></i> Key Players in Data Analysis within the Domain of Blockchain Technologies?<br /><span class="new">A Re-Do of my <s >Feb 10,2018</s> post</span>',
		post:blogpost1,
	   blogcite:blogcite1
	   }
	   ] ;
	
	   for (i=0;i<url.length;i++){ 
		var cat = ` 
		<div id="${url[i].did}" class="blogDiv"> 
		<hr />  
		<a href="#top"><button>Top</button></a>  
		<h4 class="title dailytech longtitle">OUR DAILY TECH:</h4>  
		<h5 id="cat3" class="  subdailytech">${url[i].cat3}</h5> 
		<p id="author" class="  author">${url[i].author}</p>   
		<h6  id="date" class="  chapternumber">${url[i].date}</h6>    
		<h6  id="title"   class="dailytitle chapternumber">${url[i].title}</h6>
		<br />
		<div id="post">${url[i].post}
		</div>
		<div id="blogcite">${url[i].blogcite}
		</div>` ;
	
		secretParagraphJUNE.innerHTML  += cat; 
	 
	 
	} 
	
	document.getElementById("paragraph-june").innerHTML = cat; 
	
	
	 
	 
	} else {
	  secretParagraphJUNE.style.display = 'none';
	}
	}
/* JULY */



console.log('blogger-july');
function updateSecretParagraphJULY() {
	if (showSecretJULY) {
	secretParagraphJULY.style.display = 'block';
	secretParagraphJULY.style.fontFamily = 'Roboto';
	secretParagraphJULY.style.opacity = '1';
	secretParagraphJULY.style.color = 'darkslategray';
	 
	
 

	blogpost24 = `<p class="firstparagraph">Cloud.google.com wins the day for offering the Willy Wonka's of Technological Candy at a free tour's view: You won the Golden Ticket. Google Cloud CEO Diane Greene explains that prioritizing customers' needs rather than drifting with market forces offers solid growth moving past technological shifts and drifts with little course correction.</p>
	<p class="quote">While Google is still looking up at Amazon Web Services and Microsoft Azure when it comes to infrastructure cloud computing, it appears to be finding the balance between keeping engineers happy with cloud-native computing tools and courting enterprise company suits with service-level agreements and steak dinners.<sup>1</sup></p>`;
	blogcite24 =   `
	
	<p class="cite">1. <a href="https://cloud.google.com"   target="_blank">https://cloud.google.com
	</a>
	</p><p class="cite">1. <a href="https://www.geekwire.com/2018/google-cloud-ceo-diane-greene-wane-cloud-pricing-wars-never-want-win-price/"   target="_blank">https://www.geekwire.com/2018/google-cloud-ceo-diane-greene-wane-cloud-pricing-wars-never-want-win-price/
	</a>
	</p>`;
 
	blogpost23 = `<p class="firstparagraph">Planet Green dodged a bullet recently, as activists' climate change research officially gains legitimacy from the Supreme Court, albeit a few of their qualms ... But who could deny that if there is one thing that will save the earth, it's knowledge, knowledge far outweighs any other salvo. This is because the more data, the more accurate the models to indicate specific environmental needs and threats--<i>not to mention all the clues the data could reveal toward helping earth regain balance. </i></p><p>A.I. training would starve if the Supreme Court would have allowed administration clamp-downs on knowledge. After all, the overwhelming popular and professional opinions favor earth-friendly policies. 
 <p class="quote">The Supreme Court on Monday denied the Trump administration’s plea to halt proceedings in a landmark lawsuit by young people seeking stronger federal action on climate change.<sup>1</sup>
 </p>`;
 blogcite23 = `<p class="footnotes">1. <a href="http://thehill.com/policy/energy-environment/399562-supreme-court-denies-trump-admin-request-to-halt-youth-climate"   target="_blank">http://thehill.com/policy/energy-environment/399562-supreme-court-denies-trump-admin-request-to-halt-youth-climate
 </a>
 </p>
 <p class="cite">1. <a href="http://thehill.com/policy/energy-environment/399562-supreme-court-denies-trump-admin-request-to-halt-youth-climate"   target="_blank">http://thehill.com/policy/energy-environment/399562-supreme-court-denies-trump-admin-request-to-halt-youth-climate
 </a>
 </p>
	`;
 blogpost22 = `
 <p class="quote"><i>“It feels like a magical mirror that reflects your moves with images of all kinds of human activity – from sports and dance to martial arts, acting and beyond.”</i></br></br>
 --Google creative technologist Irene Alvarado 
 </p>
 <p class="firstparagraph">Magical Mirror is a wonderful tool for A.I.-powered video imaging and mimicry. Google's soon-to-be open source software is freely available for A.I. developers ... now that should be amusing to have life-like personal avatars will certainly make for some interesting uses. 
	The power of Big Data really proves itself, but Google's algorithm-sharing provides a real democracy of A.I. technology for everyone to use.  On the other side of the coin, accuracy in video and voice mimicry now means A.I.-driven authenticity detectors will soon prove pretty darn useful!
 </p>
 `
 blogcite22 = `<p class="cite"> 
 <p class="footnotes">1. <a href="https://www.standard.co.uk/tech/google-move-mirror-dancing-gif-a3892471.html"   target="_blank">https://www.standard.co.uk/tech/google-move-mirror-dancing-gif-a3892471.html
 </a>
 </p> 
 </p>`
 blogpost21 =   `<p class="firstparagraph">Wired.com ...</p>
 <p class="quote"> 
 "But big retailers can sell millions of products, so it's not feasible to have workers browse each item and manually adjust prices. Instead, the companies employ software to scan rival websites and collect prices, a process called “scraping.” From there, the companies can adjust their own prices."<br /><br />
 "Retailers want to see what their rivals are doing, but they want to prevent rivals from snooping on them; retailers also want to protect intellectual property like product photos and descriptions, which can be scraped and reused without permission by others. So many deploy defenses to subvert scraping ..." <sup>1</sup></p>`;
 blogcite21 = ` 
 <p class="footnotes">1. <a href="https://www.wired.com/story/scraper-bots-and-the-secret-internet-arms-race/"   target="_blank">https://www.wired.com/story/scraper-bots-and-the-secret-internet-arms-race/
 </a>
 </p>   `;
 
	 blogpost20 =  `<p class="firstparagraph">Space.com ...</p>
	 <p class="quote">"NASA's Robonaut program and Roscosmos' FEDOR program seem to share the goal of creating robots that make it safer for humans to accomplish things in space that otherwise would be too dangerous for humans to attempt.<i> Still, the FEDOR androids' gun-wielding design might raise a few eyebrows."</i><sup>1</sup></p>
	 <img src="dist/img/droid.jpg" class="zoom" width="288px" />
	 `;
 blogcite20 = ` 
 <p class="footnotes">1. <a href="https://www.space.com/41253-russian-robots-fly-to-space.html"   target="_blank">https://www.space.com/41253-russian-robots-fly-to-space.html
 </p>   `;
	 
	 blogpost19=
	 `<p class="quote">
	 <i> One person familiar with the matter described the office scene as “chaotic” and said at one point more than 300 people tuned in to an emergency conference call.  “Currently out of capacity for scaling,” one of the updates said about the status of Amazon’s servers, roughly an hour after Prime Day’s launch. “Looking at scavenging hardware.” <sup>1</sup></i> </p>
	 <p class="firstparagraph">Prime Day's saga of cascading failures stemming from an internal software reveals the <i> relentless challenge of Scalability</i>. In their words, the root cause was a "breakdown in auto-scaling, a critical component when dealing with unexpected traffic spikes"<sup>1</sup>. So the exponential spikes may be hard to expect because their nature is both spontaneous, but the inflection is calculable! ...only dramatically represented as the folding a sheet of paper 42 times to reach the moon ...
	 </p>
	 <img src="dist/img/paper.png" width="340px" class="zoom" />
	 <p><small>Image Credits: Coder's Revolution</small></p>
	 <p class="quote">  Amazon wasn't able to handle the traffic surge and failed to secure enough servers to meet the demand on Prime Day, according to expert review of internal documents obtained by CNBC.<br /><br />
	 That led to a cascading series of failures, including a slowdown in its internal computation and storage service called Sable and other services that depend on it, including Prime, authentication and video playback.
	 Amazon immediately launched a scaled-down "fallback" front page to reduce workload and temporarily killed all international traffic too. 
	 </p><p>And so, the same Bezosian leadership that manages space exploration's <strong>Blue Origin</strong> inspired a system of fall-back redundencies to get back up to speed dramatically within 80 minutes. Perhaps the quick, albeit unconventional recovery strategy deserves great respect--because chance happens to all!   
	 </p>
	 `; 
 
	 blogcite19 = ` 
	 <p class="footnotes">Image Credit: <a href="http://wwvv.codersrevolution.com/blog/will-a-piece-of-paper-folded-42-times-reach-the-moon"   target="_blank">http://wwvv.codersrevolution.com/blog/will-a-piece-of-paper-folded-42-times-reach-the-moon
	 </a>
	 </p>   
 <p class="footnotes">1. <a href="https://www.cnbc.com/2018/07/19/amazon-internal-documents-what-caused-prime-day-crash-company-scramble.html"   target="_blank">https://www.cnbc.com/2018/07/19/amazon-internal-documents-what-caused-prime-day-crash-company-scramble.html
 </a>
 </p>   
	`;
	 blogpost18=
	 `
	 <p class="firstparagraph">Business models of all shapes and sizes, and the diversity of tech that comes with them, are the natural consequence of<i> unlimited <strong>creative</strong> potential in Tech. So, a small business with few resources now has unlimited resources in the cloud with game-changing access to A.I.</i> Luckily, investments in smaller tech sources cover all sectors:</p>
	
	 <p class="quote">The Energy Department has announced that it will award 95 grants worth a total of $95 million to 80 small businesses located in 26 states as part of its Small Business Innovation Research and Small Business Technology Transfer programs. <sup>1</sup>
	 </p>
	 <p>So, for as much as tech giants grow out of proportion, so do smaller businesses; because not only is the economic horizon  not a zero-sum tech pie, but growing. Secondly, the pace of evolving needs and tech capabilities favor smaller, more maneuvrable entrepreneur-producers.`;
	 
	 blogcite18 = ` 
 <p class="footnotes">1. <a href="http://www.executivegov.com/2018/07/doe-to-award-rd-grant-for-innovative-tech-to-80-small-businesses/
	 "   target="_blank">http://www.executivegov.com/2018/07/doe-to-award-rd-grant-for-innovative-tech-to-80-small-businesses/
	 
 </a>
 </p>   
	`;
 
	 blogpost17 =
	 `
	 <p class="firstparagraph"> Cloud computing has never offered more convenience--especially in e-commerce. Walmart ramps up online presence, Amazon's Whole Foods ramps up offline presence. More importantly, everything and all businesses in between these two vortices has the opportunity to ride the same wave of platform and supply chain integration. </p>
	 <p class="quote"> 
	 </p>
	 <p class="quote"> Retail giant Walmart Inc said on Tuesday it entered into a strategic partnership with Microsoft Corp for wider use of cloud and artificial intelligence technology, in a sign of major rivals of Amazon.com Inc coming together.
 <br /><br />
	 The five-year agreement will leverage the full range of Microsoft's cloud solutions, including Microsoft Azure and Microsoft 365, to make shopping faster and easier for customers, the Bentonville Arkansas-based company said.
	 
	 As part of the partnership, Walmart and Microsoft engineers will collaborate to migrate a significant portion of walmart.com and samsclub.com to Azure, Walmart added. <sup>1</sup>
	 </p>`;
	 
	 blogcite17 = ` 
 <p class="footnotes">1. <a href="https://www.usnews.com/news/technology/articles/2018-07-17/walmart-microsoft-in-partnership-to-use-cloud-tech
	 "   target="_blank">https://www.usnews.com/news/technology/articles/2018-07-17/walmart-microsoft-in-partnership-to-use-cloud-tech
	 
 </a>
 </p>   
	`;
 
	 blogpost16 = `
	 <p class="firstparagraph">Alibaba--a Chinese search giant akin to Google--dwarfs the market value of Amazon. So much so, that Alibaba's earnings last year don't compete with Amazon's year, <i>but  past several years</i>.<sup>1</sup> Their success isn't a haphazard event, but years of strategy that focused on integrating services, whether online or offline origins, a true supply chain no longer discriminating marketplaces, logistics, cloud computing and payments. With unlimited global reach, big gets bigger and bigger. </p>
	
	 <p class="quote">  "Alibaba Cloud has always been dedicated to empower enterprises of different sizes to tap into opportunities in the digital age. With digital transformation poised to add close to $154 billion to India's GDP, this is a great opportunity for us to do business in India," Alex Li, General Manager of Alibaba Cloud Asia Pacific, said in a statement.<sup>2</sup> 
		</p>
		<p>
		Ultimately, what goes up does not necessarily come back down with cloud computing. And the further integrated systems become, the less feasible to divide, no matter which part of the globe.<sup>3</sup></p>`;
	 
	 blogcite16 = `
	 <p class="footnotes">1. <a href="
	 https://www.lemonde.fr/idees/article/2018/07/10/comment-alibaba-va-tuer-amazon_5329170_3232.html"   target="_blank">https://www.lemonde.fr/idees/article/2018/07/10/comment-alibaba-va-tuer-amazon_5329170_3232.html
	 </a>
	 </p>    
	 
	 <p class="footnotes">2. <a href="https://economictimes.indiatimes.com/small-biz/startups/newsbuzz/india-presents-great-business-opportunities-alibaba-cloud/articleshow/64974989.cms"   target="_blank">https://economictimes.indiatimes.com/small-biz/startups/newsbuzz/india-presents-great-business-opportunities-alibaba-cloud/articleshow/64974989.cms
	 </a>
	 </p>      <p class="footnotes">3. <a href="https://www.wsj.com/articles/breaking-up-big-tech-is-hard-to-do-1532290123"   target="_blank">https://www.wsj.com/articles/breaking-up-big-tech-is-hard-to-do-1532290123
	 </a>
	 </p>    
	`;
 
	 blogpost15 = `
	 <p class="firstparagraph">Ethereum Architect Vitalik Buterin's unwavering commitment to the Crypto-contract currency finally pays off. In my February blogposts, I recounted the technical challenges that Ethereum still faced: As a "Proof of Work" currency that requires Ether (in <i>Wei</i>) currency for each transaction hindered more widespread adoption. After the big boost from last month's Switzerland's Crypto Valley Conference, Ethereum walked away handily with scores of investors and renewed momentum. The 23-year old hero of the platform almost appears precocious for the recent feature in Fortune Magazine's Top 40 Under 40.</p>
	 <p class="quote">
	 [Buterin's] visionary project has rocketed to a market cap of nearly $30 billion—as high as the private valuations Airbnb and Snapchat achieved—from $1 billion a year ago, when Fortune first placed him on its 40 under 40 list.<sup>2</sup>
	 </p>
	 <p>To recap the enormous advantages of Ethereum functions as a <i> global operating system--The Ethereum Virtual Machine--</i>  the platform upon which shared, distributed applications can be designed and deployed. Unlike Bitcoin's function-less platform, contracts from banking to betting to real-estate can easily be drawn up in Solidity code, into the DAPP, <i>Distributed Application  deployed onto a Fintech network so expansive</i>, no wonder that even a crypto-currency needs a Swiss bank account!
	 </p>
	 `;
 
	 blogcite15 = `<p class="footnotes">1. <a href="
 https://www.cnbc.com/2018/07/18/ethereum-is-a-leading-driver-in-blockchain-says-circle-ceo.html
 "   target="_blank">
 https://www.cnbc.com/2018/07/18/ethereum-is-a-leading-driver-in-blockchain-says-circle-ceo.html
 </a> 
 </p>
 <p class="footnotes">2. <a href="
 http://fortune.com/40-under-40/vitalik-buterin-10/"   target="_blank">http://fortune.com/40-under-40/vitalik-buterin-10/
 </a>
 </p>   
	`;
	
	 blogpost14 = `
	<p class="firstparagraph">Prime's Allure begins with the greatest deals, the most convenient deliveries, and a new Accessibility of Whole Foods Breads, Pastries, and HoneyCrisp Apples to every citizen!</p>
	<p>On a darker note, many articles and studies focus on the vendors' side of the Amazon effect, i.e. the push to remote shopping;<sup>1</sup> But the consumer side of the Amazon effect is more insidious: the sheer off-scale underpricing of goods, mock holidays, and shopping-memberships push new spending habits. <i>The more convenient shopping with 'one-click buy' becomes, the 'less convenient' becomes the explorative, exciting-/debate-filled shopping experiences that reward the Creative Entrepreneurs'</i> cultural interaction with consumers  
 
 `;
	 blogcite14 = `
 <p class="footnotes">1. <a href="
 https://www.statista.com/chart/10295/shopping-on-amazon/
 "   target="_blank">
 https://www.statista.com/chart/10295/shopping-on-amazon/
 </a>
 </p>   
 `;
	 blogpost13 = `
	 <p class="firstparagraph"> Now that 49% of American e-commerce passes through Amazon's gates, it's official: <i>50% market share signifies a hostile take-over of Amerian Culture.</i> From the remaining half of the Online Shopping pie goes to  the next top nine, 22%: 
	</p>
	<p class="quote">
	 eBay (EBAY): 6.6%<br /><br />
	 Apple (AAPL): 3.9%<br /><br />
	 Walmart (WMT): 3.7%<br /><br />
	 Home Depot (HD): 1.5%<br /><br />
	 Best Buy (BBY) 1.3%<br /><br />
	 QVC Group (QVCA): 1.2%<br /><br />
	 Macy's (M): 1.2%<br /><br />
	 Costco (COST): 1.2%<br /><br />
	 Wayfair (W): 1.1%<br /><br />
	 <small style="align:right;">Business Insider, July 2018 </small></p>
	 </p>
	 <p>These are more palatable organizations, without Amazon's cardboard-like culture.  There you still have the lofty, beautify Apple products, and who doesn't love the umbrella-cane only available on QVC limited quantities do apply!</p>
	 <p>
	 Of course, the remaining free birds, the 32% comprise the millions of home-office,brick-and-mortars, and online market entrepreneurs. (These do not include the independent vendor sales using Amazon's Marketplace). </p><p>So why does this 32-percentile slice of e-commerce represent the last stand of American Culture? The Creative Spirit may survive, even thrive; but it changes, and <i> creative verve takes on a reshaped form and a new pace, fitting to bureaucratic constraints and pricing schema. </p>   `;
	 blogcite13 = `
	 <p class="footnotes">1. <a href="
	 http://www.businessinsider.com/amazon-is-closing-in-on-owning-half-of-the-e-commerce-market-2018-7?utm_source=feedburner&amp%3Butm_medium=referral&utm_medium=feed&utm_campaign=Feed%3A+businessinsider%2Ftravel+%28Business+Insider%29&r=US&IR=T&IR=T
	 "   target="_blank">
	 http://www.businessinsider.com/amazon-is-closing-in-on-owning-half-of-the-e-commerce-market-2018-7 
	 </a>
	 </p>     
 
	 `;
	 blogpost12 = `
	 
	 <p class="firstparagraph">Fintech's revered "Crypto Valley Conference on Blockchain Technology" in Zug, Switzerland, featured blockchain expertise from all corners, including Keynote Speakers, Stefan Thomas CTO of Ripple [cryptocurrency] and Professor Emin G&uuml;n Sirer of Cornell University, along with Economists and Swiss Government officials. World-class economists, investors, and Regulation authorities aside, the host-countries whole-hearted commitment to cryptocurrency is evident: </p>
	 <p class="quote">“They want Switzerland to be the place to make it happen — but they don’t want to be seen
	 as the ‘wild west’. It is Swiss pragmatism,” says Martin Eckert, partner at MME, a Swiss law firm. <br /><br /> 
	 Digital pioneers say Switzerland emerged as an ICO hub because it has a cluster of rich
	 investors and technology specialists. The small canton of Zug, near Zurich, has unofficially
	 Switzerland embraces cryptocurrency culture Seite 2 von 7
	 25.01.2018
	 become “Crypto Valley”.<sup>4</sup>
	 </p>
	 <img src="dist/img/swissBlockchain.png" width="350" class="zoom" />
	 <p><small>Image Credit: Source Lykke, Coindesk</small></p>
 `;
	 blogcite12 = `<p class="footnotes">3. <a href="
	 https://www.cryptovalleyconference.com
	 "   target="_blank">
	 
	 https://www.cryptovalleyconference.com
	 </a>
	 </p>
	 <p class="footnotes">4. <a href="
	 https://www.crypto-finance-conference.com/resources/public/lava3/media/switzerland-embraces-cryptocurrency-culture.pdf
	 "   target="_blank">
	 
	 https://www.crypto-finance-conference.com/resources/public/lava3/media/switzerland-embraces-cryptocurrency-culture.pdf
	 </a>
	 </p>
 `;
	 blogpost11 = `
	 <p class="firstparagraph"><i>Zen of Python: "Beautiful is better than ugly.<i> Explicit is better than implicit.</i>  Simple is better than complex.  Complex is better than complicated. Flat is better than nested.  Sparse is better than dense"<br /></i> -- Pythoneer Tim Peters<p> In my April 19th post, I recount Python's near-mystical author and leader of language's development up to this month's retirement:  About Guido van Rossum, </p>
	 <p class="quote">After almost 30 years of overseeing the development of the world's<i> most popular language, Python, its founder and Benevolent Dictator For Life" (BDFL), Guido van Rossum,</i> has decided he would like to remove myself entirely from the decision process.<sup>2</sup> </p><p>
 Python is NASA's drug-of-choice because of the language's superior handling of precision mathematics, and yet the syntax and module libraries makes the language easy for anyone to pick up. Few could argue against Guido van Rossum's reductionist philosophy that inspires the clear, expansive structure. So, farewell to the great Guido van Rossum's official leadership and Thank You! 
 </p>
 `;
	 blogcite11 = ` <p class="footnotes"><a>1. Tim Peters <p class="footnotes">2. <a href="https://www.zdnet.com/article/python-language-founder-steps-down/  "   target="_blank">
	 https://www.zdnet.com/article/python-language-founder-steps-down/ </a>
	 </p>
 
 `;
	 blogpost10 = `<p class="quote">
 ...The colossal shift in the chip world came with the advent of artificial intelligence (AI) and machine learning (ML). With these emerging technologies, a flood of new processors has arrived—and they are coming from unlikely sources. <br /><br />
 Microsoft is preparing an AI chip for its HoloLens VR/AR headset, and there’s potential for use in other devices. 
 <i> Google has a special AI chip for neural networks called the Tensor Processing Unit, or TPU, which is available for AI apps on the Google Cloud Platform. </i>Apple is working on an AI processor called the Neural Engine that will power Siri and FaceID.  <sup>1</sup></p>
 <p class="firstparagraph">All ... All the A.I. Tools a busy bee could ask for!
 </p>
	`;
	 blogcite10 = `
 <p class="footnotes">1. <a href="
 https://arstechnica.com/gadgets/2018/07/the-ai-revolution-has-spawned-a-new-chips-arms-race/
 "   target="_blank">
 https://arstechnica.com/gadgets/2018/07/the-ai-revolution-has-spawned-a-new-chips-arms-race/
 </a>
 </p>     
 `;
 
	 blogpost9 = ` 
 <p class="firstparagraph">Moore's Law--a function of transistor count--has guided CPU bench-mark expectations along a fairly linear path year-by-year. However, computing requirements have multiplied while the mathematical relevence of the law wanes. <br /><br />
 <img src="dist/img/moores_law.png" width="400px" class="zoom" title="Moore's Law Graphic" /><br />Image Credit: ourworldindata.org <br /><br /> <i>Enter the Decision Tree, the Random Forest, Na&iuml;ve Bayes, and K-Nearest Neighbors</i>: The machine learning tools and theoretical building blocks to get more bang for the buck from all that computing power. How? <i> Teaching software to teach itself, which is the pathway out of computing-power deficits and the move from theoretical to practical</i> ...</p> 
 <p class="quote">
 Every technology follows a similar path of diszcovery, engineering, and transformation. In the case of electricity, Faraday uncovered new principles, but no one really knew how to make them useful. They first had to be understood well enough that people such as Edison, Westinghouse, and Tesla could figure out how to make things that people would be willing to buy.
	
 <br /><br />  The digital revolution, for all of its charms, has had a fairly limited economic impact, compared with earlier technologies such as electricity and the internal combustion engine. Even now, information technologies make up only about 6% of GDP in advanced economies. Compare that to manufacturing, health care, and energy, which make up 17%, 10%, and 8% of global GDP, respectively, and you can see how there is vastly more potential to make an impact beyond the digital world.
 <sup>2</sup></p>
 <p>As the saying goes, <i>One crowded hour of glorious life is worth an age without a name.</i><sup>3</sup> And now the tide is high for Tech to venture out into the world and make a name for herself!
 `;
	 blogcite9 = `<p class="footnotes">2. <a href="https://ourworldindata.org/wp-content/uploads/2013/05/Transistor-Count-over-time.pngArticle"   target="_blank">https://ourworldindata.org/wp-content/uploads/2013/05/Transistor-Count-over-time.png</a>
 </p>
 <p class="footnotes">2. <a href="https://hbr.org/2018/07/the-industrial-era-ended-and-so-will-the-digital-era"   target="_blank">https://hbr.org/2018/07/the-industrial-era-ended-and-so-will-the-digital-era</a>
 </p>
 
 <p class="footnotes">3. Thomas Osbert Mordaunt`
 
	 blogpost8 = `<p class="firstparagraph">Advances in computer science and data research follow the path of the tools that pave a developer's path: The tools make the worker, and therefore the work. For example, any of the Industrial Revolutions leaped forward with every new tool. <i>Now, Artificial Intelligence research and design  lurches forward by the tooling, but in a new fashion: Open source tools owned and operated by the community, the work by and for any community.</i>
 </p>
 <p> Neural network tools like TensorFlow.js, a "JavaScript library for training and deploying Machine Learning models in the browser and on Node.js" <sup>1</sup>  along with other programming-library frameworks, abstract away a layer of the visible mechanics. On the one hand, it is the democratization of cutting-edge technology, formerly siloed apart and under government, corporate or university controls. </p>
 <p>
 The genie is definitely out of the bottle, yet he or she is now at the keyboards across the globe. This has a clear effect in bringing technological innovation to the community, to the coffeeshops and meet-up groups, instead of clearly defined, bureaucratically-directed research ends. </p>
 <p>Therefore,  bootstrapping open-source projects brings the community to the forefront of technological innovation! Though the common mobile app has grown familiar for changing landscapes, those apps chiefly leverage the social network (links) of friends and professionals; while the common-use spread of machine-learning research provides leverage to the actual work (nodes) of progress</p>
 <p>Therefore, the tools provide one dimension of A.I.'s path, while the democratized distribution of tools across social networks provides a second dimensional path. This alters the A.I. evolution in the long-term, by means of short-term and frequent tooling revolutions.   </p>
 `;
	 blogcite8 = `
 <p class="footnotes">1. <a href=" https://js.tensorflow.org/"   target="_blank"> https://js.tensorflow.org/</a>
 </p>   
 `;
	 blogpost7 = `
 <p class="firstparagraph">Panic and anxiety cover the Snapchat countries across far-flung locales from Latvia to Denver to Spain--</i>and in one case blighting the entire island of the United Kingdom...</i></p>
 <p class="quote">Some users went to Twitter and shared their frustration.
 "I've been sending people abuse on snapchat for not replying to me only to discover its down. Oops?" one user tweeted.<br /><br />
 "Snapchat just went down. I can literally feel the panic of a thousand generations in my bones. #snapchat," another user posted.
 Snapchat currently has 166 million users globally. <sup>2</sup>
 </p>
 <p> A chronic technical problem before May 2018 when SnapCrash went public   dating to October. <sup>1</sup> -- scalability challenges strike again!</p> 
 <img src="dist/img/snapchat.jpg" width="350" class="zoom" /><br /><br />
 <p>But inquiring minds want to know, <i>What's the Story with Snapchat? </i>Not to mention the Conspiracy Theorists that blame Snapchat's devotion to Advertisers--too many distractions?</p>
 <p class="quote">
 [Snapchat] tweeted: “Some Snapchatters are having trouble with the app. We’re aware of the issue and working on a fix! We recommend staying logged into your account.”
 <br /><br />
 Snapchat recently confirmed that it is testing six-second long ads in Shows on its Discover section that won’t budge no matter how many times a user tries to tap to skip them.<br /><br />
 
 This development has been coming for some time as Snapchat looks to placate advertisers who have grown frustrated by users who, on average, only stay on an ad for two seconds before skipping.</p> 
 <p>Every kind of Server malfunction pales in comparison to the Affordable Healthcare Act web-app's abysmal first few months.<i> Get Well Soon, Snapchat--you're breaking our heart!</i></p>`;
	 blogcite7 = `
 <p class="footnotes">1. <a href=" https://www.independent.co.uk/life-style/gadgets-and-tech/snapchat-down-not-working-android-broken-message-snap-inc-help-a8443236.html"   target="_blank"> https://www.independent.co.uk/life-style/gadgets-and-tech/snapchat-down-not-working-android-broken-message-snap-inc-help-a8443236.html</a>
 </p>    
 
 <p class="footnotes">2. <a href=" http://www.tribuneindia.com/news/science-technology/snapchat-outage-hits-users-globally/480068.html"   target="_blank"> http://www.tribuneindia.com/news/science-technology/snapchat-outage-hits-users-globally/480068.html</a>
 </p>    
 <p class="footnotes">3. <a href="https://outage.report/snapchat" target="_blank">https://outage.report/snapchat</a></p>
	`;
	 blogpost6 = `
	<p class="quote"><sup>0</sup><strong><small>
	The term “extropy,” coined in 1967, is generally used to describe life’s capacity to reverse the spread of entropy across space and time. </small></strong><sup>1</sup>
	</p>
	<p class="firstparagraph">
	Philosophies of A.I. range from the Aloof to Alarmed, from Punch-drunk Optimism to Harrowing Paranoia: A few vantage points from a Legacy New Yorker:</p>
	<p class="quote">
	Last summer, Oren Etzioni, the C.E.O. of the Allen Institute for Artificial Intelligence, in Seattle, referred to the fear of machine intelligence as a “Frankenstein complex.” Another leading researcher declared, “I don’t worry about that for the same reason I don’t worry about overpopulation on Mars.”<sup>1</sup></p>
	<p class="quote">
	Jaron Lanier, a Microsoft researcher and tech commentator, told me that even framing the differing views as a debate was a mistake. “This is not an honest conversation,” he said. “People think it is about technology, but it is really about religion, people turning to metaphysics to cope with the human condition. They have a way of dramatizing their beliefs with an end-of-days scenario—and one does not want to criticize other people’s religions.”
	<sup>1</sup></p>
	<p class="quote">
	Bostrom had little interest in conventional philosophy—not least because he expected that superintelligent minds, whether biologically enhanced or digital, would make it obsolete. “Suppose you had to build a new subway line, and it was this grand trans-generational enterprise that humanity was engaged in, and everybody had a little role,” he told me. “So you have a little shovel. But if you know that a giant bulldozer will arrive on the scene tomorrow, then does it really make sense to spend your time today digging the big hole with your shovel? Maybe there is something else you could do with your time. Maybe you could put up a signpost for the great shovel, so it will start digging in the right place.” He came to believe that a key role of the philosopher in modern society was to acquire the knowledge of a polymath, then use it to help guide humanity to its next phase of existence—a discipline that he called “the philosophy of technological prediction.” 
	<sup>1</sup></p>
	<p>At the end of the day, we can ask "are we there yet?" over again, but a more pointed query asks not about time, but about place: "It may be highly unpredictable where a traveller will be one hour after the start of her journey, yet predictable that after five hours she will be at her destination.”
	`;
	 blogcite6 = `
	
 <p class="footnotes">1. <a href=" https://www.newyorker.com/magazine/2015/11/23/doomsday-invention-artificial-intelligence-nick-bostrom"   target="_blank"> https://www.newyorker.com/magazine/2015/11/23/doomsday-invention-artificial-intelligence-nick-bostrom</a>
 </p>    
 <p class="footnotes">1. <a href="https://nickbostrom.com/"   target="_blank"> https://nickbostrom.com/</a>
 </p>  
 
	`;
	 blogpost5 = `
	<p class="firstparagraph">It turns out that data is unevenly distributed between sectors, leading to monopoles of dominance: After all, who controls the data, controls the commanding heights. And yet, the very substance of Big Data derives from and belongs precisely to  individuals, aggregated, that checked "Agree" to a given app's Privacy Policy, from a given Internet Service Provider, using a given Browser ....</p>
	<p>Now that physical products lose relative value for many reasons (not to mention easy downloads for 3-D printing), and alternately<i> informational data products gain value in the digital economy: hence the problem of allocating the value of personal data back to the person </i>... To this, the Canadian A.I. Mafia chimes in:</p>
	 <p class="quote">A persistent challenge for Element is the dearth of good data. The simplest way to train A.I. models is to feed them lots of well-labeled examples—thousands of cat images, or translated texts. Big Tech has access to so much consumer-oriented data that it’s all but impossible for anyone else to compete at building large-scale consumer products. But businesses, governments, and other institutions own huge amounts of private information. Even if a corporation uses Google for email, or Amazon for cloud computing, it doesn’t typically let those vendors access its internal databases about equipment malfunctions, or sales trends, or processing times. <br />
	 <br />That’s where Element sees an opening. If it can access several companies’ databases of, say, product images, it can then—with customers’ permission—use all of that information to build a better product-recommendation engine. Big Tech companies are also selling A.I. products and services to businesses—IBM is squarely focused on it—but no one has cornered the market. Element’s bet is that if it can embed itself in these organizations, it can secure a corporate data advantage similar to the one Big Tech has in consumer products.<sup>1.</sup></p>
	 <p>
		<p>So will this kind of data democratization work? Not only so, but the Cambridge Analytica fiasco only briefly awakened public attention to the deep science underlying each of our "online digital signatures" ... the race is on among the Tech Giants to use A.I. to understand our lives, our keystrokes, our buying preferences better than we understand. And in turn, provide a great utility, and win our financial allegiance!
 `;
 
 
	 blogcite5 = `
 
 <p class="footnotes">1. <a href="http://fortune.com/longform/element-ai-startup-tech/"   target="_blank">http://fortune.com/longform/element-ai-startup-tech/</a>
 </p>    
 
 `;
 
	 blogpost4 = ` 
	 <p class="quote">In the Modern Field of Artiificial Intelligence, all roads seem to lead to three researchers with ties to Canadian universities. The first, Geoffrey Hinton, a 70-year-old Brit who teaches at the University of Toronto, pioneered the subfield called deep learning that has become synonymous with A.I. The second, a 57-year-old Frenchman named Yann LeCun, worked in Hinton’s lab in the 1980s and now teaches at New York University. The third, 54-year-old Yoshua Bengio, was born in Paris, raised in Montreal, and now teaches at the University of Montreal. The three men are close friends and collaborators, so much so that people in the A.I. community call them the Canadian Mafia.<sup>1.</sup></p>
 
	 <p class="firstparagraph">A curious path of punctuated advancement due to insufficient memory and cpu power, characterized late 20th century A.I. development: Deep Learning development   lulls interrupted by rapid growth with each successive technological period.
		Toronto's Dr. Geoff Hinton's single-layered A.I. algorithm gained brief fame, yet A.I. research no longer advanced  for ten years. </p>
		<p class="quote">
		Programs that performed well in the laboratory were useless in everyday situations; a simple act like picking up a ball turned out to require an overwhelming number of computations.
 
 The research fell into the first of several “A.I. winters.” As Bostrom notes in his book, “Among academics and their funders, ‘A.I.’ became an unwanted epithet.”<sup>1</sup> 
 </p>
 <p>
 Then came the GPU with Alex Khreshinski's famous image-recognition competition-winning penmanship detector, which notably is still in use by the banking system. This novel use of the GPU to accomplish parallel calculations rewrote the the A.I. field overnight. Also known as the "Cambrian Explosion", this event (and really just the algorithm) set off widespread advancements in the weeks and months follwoing, leading to new speciation ranging from the ANN, Neural Network, to a whole alphabet soup from Convolutional Neural Networks (CNN) <i>to far-reaching mutations of Reinforcement Learning</i>.<sup>2</sup>
	 </p>
	
	 <p> Along with Hinton's close collaborator throughout the 1980's and 90's, Dr. Yoshua Bengio of the University of Montr&eacute;al, the researchers remain committed to humanity's service:</p>
		
	 <p class="quote">
	 Hinton moved from the U.S. to Canada in part due to disillusionment with Reagan-era politics and disapproval of military funding of artificial intelligence.[22] He believes political systems will use AI to "terrorize people". Hinton has petitioned against lethal autonomous weapons. Regarding existential risk from artificial intelligence, Hinton has stated that superintelligence seems more than 50 years away, but warns that "there is not a good track record of less intelligent things controlling things of greater intelligence". Asked in 2015 why he continues research despite his grave concerns, Hinton stated "I could give you the usual arguments. But the truth is that the prospect of discovery is too sweet." Hinton has also stated that "It is very hard to predict beyond five years" what advances AI will bring.<sup>1</sup></p>
	 
	 <p>While Hinton and company aren't necessarily Mahatma Gandhi-like, their devotion to a science prioritized to humanity' service and long-term best interest--free from monetary or other influence is admirable. No wonder their outlook on A.I.'s utility is so much brighter than that of Pessimist Elon Musk and company ... baah-humbug!
	</p>
		
	
	 `;
 
 
	 blogcite4 = `
 
 
	 <p class="footnotes">1. <a href="http://fortune.com/longform/element-ai-startup-tech/"   target="_blank">http://fortune.com/longform/element-ai-startup-tech/</a>
	 </p>    
	 <p class="footnotes">2. <a href="https://www.benzinga.com/pressreleases/18/06/p11846924/join-ai-pioneer-geoffrey-hinton-in-toronto-and-learn-from-global-leade"   target="_blank">https://www.benzinga.com/pressreleases/18/06/p11846924/join-ai-pioneer-geoffrey-hinton-in-toronto-and-learn-from-global-leade</a>
	 </p>     
 
 
	 `;
 
	 blogpost3 = ` 
	 <p class="firstparagraph">Already A.I. has shown its true colors as an ideal tool for solving disproportionately large, complex data problems: Similar to Watson's medical recommendations based on millions of pages read, the off-the scale amount of pages from every tech company is the item of interest. This is the flurry-to-snowstorm of Privacy Policies simultaneously released in response to the E.U.'s May 25th General Data Protection Regulations.  In reference to my June 30th post on A.I. workplace solutions, months of busy-reading-work all distilled to a fraction of the time to analyze those policies. Guess what? The rule-breaking is well under way!</p>
	 <p class="quote">Researchers from the European Union Institute in Florence worked with an EU consumer organization to create the software. They then used the program to examine the privacy policies of 14 major technology businesses, including by Alphabet Inc., Amazon.com Inc., and Facebook Inc.<br /><br />
	
	 They found that a third of those clauses were "potentially problematic" or contained "insufficient information." Another 11 percent of the policy’s sentences used unclear language, the academics said.  The researchers didn’t make public which companies’ policies violated which provisions of the law, publishing only aggregate findings for all of the companies in the study.<sup>1</sup></p>
	
	 <p>Aha! <i>The practices of Tech companies' use of A.I. to analyze customers' private data is well-known, but <strong>what do we actually know</strong> beyond just that? Behind the veil of commercial secret, much less is known than is led on ... until now. Now, A.I. becomes increasingly useful as a tattle-tale! </i> So by the same token that tech creates problems, Tech is the first to provide a solution. But A.I. rule-checking sounds good but raises another question: Who owns, or can access by alternate means, the personal data we have strewn across the internet? And what quality of data does each party have, or shares?  </p>
	 `;
 
	 blogcite3 = `
	 
 <p class="footnotes">1. <a href="https://www.bloomberg.com/news/articles/2018-07-04/new-ai-tips-off-regulators-to-possible-eu-data-privacy-faults"   target="_blank">https://www.bloomberg.com/news/articles/2018-07-04/new-ai-tips-off-regulators-to-possible-eu-data-privacy-faults</a>
 </p>    
	 `;
 
	 blogpost2 =
		 `
 <p class="quote"><i>Power is “various forms of domination and subordination and the asymmetrical balance of forces which operate whenever and wherever social relations exist.”  </i><sup>1</sup><br /><br />--Michel Foucault</p>
 <p class="firstparagraph">Ties and balances of power, at their fundamental core are constantly changing variations of symmetry between two agents, whether unilateral or bilateral: Two nodes interlinked. Magnified by overlapping networks and layers of relations, it's easy to see why long-standing institutions are interlocked, for better or worse ... Clearly the trend of turbulence and power grabs reaches far and wide:
	</p>
 <p class="quote">Poland was once a beacon for countries struggling to escape the yoke of the Soviet Union and embrace Western democracy. But it is now in league with neighboring nations, like Hungary, whose leaders have turned to authoritarian means to tighten their grip on power, presenting a grave challenge to a European Union already grappling with nationalist, populist and anti-immigrant movements.<br /><br />
 
 The forced retirements of up to 27 of 72 Supreme Court justices, including the top judge, and the creation of a judicial disciplinary chamber were the latest in a series of steps by Poland’s right-wing Law and Justice Party to take over the justice system.
 </p>
 <p>As it always is in film, it is so now that dire situations have to call upon the true Super Man, Technology, to save the day: And what form this time? Blockchain technology, which presents a cryptographic solution to the problem of trust:<i> If two agents can agree on a third cryptographic intermediary, then a bridge of trust is built--the kind that in the past only institutions could broker!</i>. </p>
 <p>And so, two humans devise a new means to exchange without disruption--an indestructable scaffolding firmly set in the foreground from today's creaking and swaying institutions. Sounds good, but where's the music? There seems to be a subtle interlude between the honeymoon stage of investing and inventing new currencies, and little in the way of micro-transactions and <i> the actual <strong>using</strong> it</i>. It takes a little trust to make trust, so the effort is on to make a bridge from the <i>early adopters</i> stage to <i>mainstream adoption</i>...<sup>3</sup>  
 </p>
 `;
	 blogcite2 =
		 `
 <p class="footnotes">2. <a href="https://books.google.com/books?id=6rfP0H5TSmYC&printsec=frontcover"   target="_blank">Foucault, Michel. Discipline and punish: The birth of the prison. Vintage, 2012.</a>
 </p>   
 <p class="footnotes">2. <a href="https://www.nytimes.com/2018/07/03/world/europe/poland-supreme-court-protest.html"   target="_blank">https://www.nytimes.com/2018/07/03/world/europe/poland-supreme-court-protest.html</a>
 </p>   
 <p class="footnotes">3. <a href="https://www.nytimes.com/2018/07/01/technology/cryptocurrency-ripple.html?rref=collection%2Fsectioncollection%2Ftechnology&action=click&contentCollection=technology&region=stream&module=stream_unit&version=latest&contentPlacement=9&pgtype=sectionfront"_blank">https://www.nytimes.com/2018/07/01/technology/cryptocurrency-ripple.html</a>
 </p> 
 
 `;
 
	 blogpost1 = `<p class="quote">A vast majority of the half-million bodies in the inner asteroid belt may in fact be shrapnel from as few as five parent bodies called "planetesimals," scientists say. But the tangled orbits of those lost worlds meant they were doomed to collide, producing fragments that also collided, producing still more fragments in a cataclysmic cascade that's been going on for more than 4 billion years.<sup>1</sup></p><p> 
 </p>
 `;
 
	 blogcite1 = `<p class="footnotes">1. <a href="https://www.washingtonpost.com/news/speaking-of-science/wp/2018/07/03/many-asteroids-might-be-remnants-of-five-destroyed-worlds-scientists-say/?noredirect=on&utm_term=.4f1e000cc632"   target="_blank">https://www.washingtonpost.com/news/speaking-of-science/wp/2018/07/03/many-asteroids-might-be-remnants-of-five-destroyed-worlds-scientists-say/?noredirect=on&utm_term=.4f1e000cc632</a>
 </p> 
 `;
	 var url =  [   
				{ id: '24',
				did: '07-28-18',
				 date: 'July 28-29, 2018<br />Weekend',
				 author: 'by Thomas Maestas',
				 cat3: 'Web Dev Affairs',
				 title: '',
				 post: blogpost24,
				 blogcite: blogcite24
			 }, 
				{
	id: '23',
		 did: '07-27-18',
		 date: 'July 27, 2018',
		 author: 'by Thomas Maestas',
		 cat3: 'Sociology Tomorrow!',
		 title: 'Hooray for Planet Green!',
		 post: blogpost23,
		 blogcite: blogcite23
		}, 
	 
		 {
			 id: '22',
			 did: '07-26-18',
			 date: 'July 26, 2018',
			 author: 'by Thomas Maestas',
			 cat3: 'Bot Mercenaries:<br />',
			 title: 'As Long as I Can Feel the Beat, Baby I don\'t Need Dollar Bils to Have Fun Tonight<br /><span class="pull-left"> - Sia',
			 post: blogpost22,
			 blogcite: blogcite22
		 },  
			{
		 id: '21',
		 did: '07-25-18',
		 date: 'July 25, 2018',
		 author: 'by Thomas Maestas',
		 cat3: 'Web Dev Affairs',
		 title: 'Bot Mercenaries:<br />Armies of Secret Shoppers',
		 post: blogpost21,
		 blogcite: blogcite21
	 },  {
		 id: '20',
		 did: '07-24-18',
		 date: 'July 24, 2018',
		 author: 'by Thomas Maestas',
		 cat3: 'Sociology Tomorrow!',
		 title: 'Bot Mercenaries:<br />Warrior Bots in Space',
		 post: blogpost20,
		 blogcite: blogcite20
	 },
		 {
			 id: '19',
			 did: '07-23-18',
			 date: 'July 23, 2018',
			 author: 'by Thomas Maestas',
			 cat3: 'Web Dev Affairs',
			 title: 'Amazon\'s Prime Day Scaling Slip and Recovery:<br />A How-To Guide to Graceful Error Handling',
			 post: blogpost19,
			 blogcite: blogcite19
		 },
		 {
			 id: '18',
			 did: '07-21-18',
			 date: 'July 21-22, 2018<br />Weekend',
			 author: 'by Thomas Maestas',
			 cat3: 'Web Dev Affairs',
			 title: 'Cloud Wars, Part III:<br />Creativity that Turns on a Dime',
			 post: blogpost18,
			 blogcite: blogcite18
		 },
		 {
			 id: '17',
			 did: '07-20-18',
			 date: 'July 20, 2018',
			 author: 'by Thomas Maestas',
			 cat3: 'Sociology Tomorrow!',
			 title: 'Cloud Wars, Part II:<br />EZ-Commerce ',
			 post: blogpost17,
			 blogcite: blogcite17
		 },
		 {
		 id: '16',
		 did: '07-19-18',
		 date: 'July 19, 2018',
		 author: 'by Thomas Maestas',
		 cat3: 'Web Dev Affairs',
		 title: 'Cloud Wars, Part I:<br />Behomeths from Across the Sea  ',
		 post: blogpost16,
		 blogcite: blogcite16
	 },{
			 id: '15',
			 did: '07-18-18',
			 date: 'July 18, 2018',
			 author: 'by Thomas Maestas',
			 cat3: 'Musing Blockchain',
			 title: 'By the Light of Ethereum',
			 post: blogpost15,
			 blogcite: blogcite15
		 },
		 {
			 id: '14',
			 did: '07-17-18',
			 date: 'July 17, 2018',
			 author: 'by Thomas Maestas',
			 cat3: 'Sociology Tomorrow!',
			 title: 'Annual Prime Day , Part II:<br /> The Credit Card Hangover',
			 post: blogpost14,
			 blogcite: blogcite14
		 },
		 {
			 id: '13',
			 did: '07-16-18',
			 date: 'July 16, 2018',
			 author: 'by Thomas Maestas',
			 cat3: 'Web Dev Affairs',
			 title: 'Prime Day\'s Annual All-You-Can-Eat Buffet, Part I<br />',
			 post: blogpost13,
			 blogcite: blogcite13
		 },
		 {
			 id: '12',
			 did: '07-14-18',
			 date: 'July 14-15, 2018<br />Weekend',
			 author: 'by Thomas Maestas',
			 cat3: 'Musing Blockchain',
			 title: 'Crypto Valley, Switzerland',
			 post: blogpost12,
			 blogcite: blogcite12
		 },
		 {
			 id: '11',
			 did: '07-13-18',
			 date: 'July 13, 2018',
			 author: 'by Thomas Maestas',
			 cat3: 'Web Dev Affairs',
			 title: 'Simple is better than Complex. Complex is Better than Complicated.<br /><small>--Tim Peters</small>',
			 post: blogpost11,
			 blogcite: blogcite11
		 },
 
		 {
			 id: '10',
			 did: '07-12-18',
			 date: 'July 12, 2018',
			 author: 'by Thomas Maestas',
			 cat3: 'A.I.Now.',
			 title: 'Tools of the A.I. Trade, Part III:<br />  Operation Architecture Drilldown',
			 post: blogpost10,
			 blogcite: blogcite10
		 },
 
		 {
			 id: '9',
			 did: '07-11-18',
			 date: 'July 11, 2018',
			 author: 'by Thomas Maestas',
			 cat3: 'Web Dev Affairs',
			 title: 'Tools of the A.I. Trade, Part II:<br />Machine Learning\'s Pedal to the Metal',
			 post: blogpost9,
			 blogcite: blogcite9
		 },
		 {
			 id: '8',
			 did: '07-10-18',
			 date: 'July 10, 2018',
			 author: 'by Thomas Maestas',
			 cat3: 'A.I.Now.',
			 title: 'Tools of the A.I. Trade, Part I: <br />The Proliferation of Machine Learning Modeling Libraries ',
			 post: blogpost8,
			 blogcite: blogcite8
		 },
		 {
			 id: '7',
			 did: '07-09-18',
			 date: 'July 9, 2018',
			 author: 'by Thomas Maestas',
			 cat3: 'Web Dev Affairs',
			 title: '187 million Snapchat Users and Enquiring Minds want to Know: Did Multiple Clusters Fail at once?...or is there Foul Play?',
			 post: blogpost7,
			 blogcite: blogcite7
		 },
		 {
			 id: '6',
			 did: '07-07-18',
			 date: 'July 7-8, 2018<br />Weekend',
			 author: 'by Thomas Maestas',
			 cat3: 'Sociology Tomorrow!',
			 title: 'Theories of Extropy <sup>0</sup>',
			 post: blogpost6,
			 blogcite: blogcite6
		 },
		 {
			 id: '5',
			 did: '07-06-18',
			 date: 'July 6, 2018',
			 author: 'by Thomas Maestas',
			 cat3: 'A.I.Now.',
			 title: 'The Canadian Mafia, Part II.<br />Data Better Recollected',
			 post: blogpost5,
			 blogcite: blogcite5
		 },
 
		 {
			 id: '4',
			 did: '07-05-18',
			 date: 'July 5, 2018',
			 author: 'by Thomas Maestas',
			 cat3: 'A.I.Now.',
			 title: 'The Canadian Mafia, Part I.<br /> On the Good-Natured Vision of the Godfathers of A.I.',
			 post: blogpost4,
			 blogcite: blogcite4
		 },
		 {
			 id: '3',
			 did: '07-04-18',
			 date: 'July 4, 2018',
			 author: 'by Thomas Maestas',
			 cat3: 'A.I.Now.',
			 title: 'Training Data, Big and Beloved Data<br />Big Data\s Most Notorious Rule-Breaker and Rule-Enforcer: A.I.',
			 post: blogpost3,
			 blogcite: blogcite3
		 },
		 {
			 id: '2',
			 did: '07-03-18',
			 date: 'July 3, 2018',
			 author: 'by Thomas Maestas',
			 cat3: 'Musing Blockchain',
			 title: 'What\'s Behind the Rebirth of the Nation-State?<br />There\'s a <i>Blockchain DAPP</i> for that!',
			 post: blogpost2,
			 blogcite: blogcite2
		 },
		 {
			 id: '1',
			 did: '07-02-18',
			 date: 'July 2, 2018',
			 author: 'by Thomas Maestas',
			 cat3: 'Sociology Tomorrow!',
			 title: 'Celestial Bodies: Always Out to Impress!',
			 post: blogpost1,
			 blogcite: blogcite1
		 }
 
	 ];
  
	 for (i=0;i<url.length;i++){ 
		var cat = ` 
		<div id="${url[i].did}" class="blogDiv"> 
		<hr />  
		<a href="#top"><button>Top</button></a>  
		<h4 class="title dailytech longtitle">OUR DAILY TECH:</h4>  
		<h5 id="cat3" class="  subdailytech">${url[i].cat3}</h5> 
		<p id="author" class="  author">${url[i].author}</p>   
		<h6  id="date" class="  chapternumber">${url[i].date}</h6>    
		<h6  id="title"   class="dailytitle chapternumber">${url[i].title}</h6>
		<br />
		<div id="post">${url[i].post}
		</div>
		<div id="blogcite">${url[i].blogcite}
		</div>` ;
	
		secretParagraphJULY.innerHTML  += cat;   
	}  
	document.getElementById("paragraph-july").innerHTML = cat; 
 
 
} else {
	secretParagraphJULY.style.display = 'none';
} 
}

/* AUG */



console.log('blogger-aug');
function updateSecretParagraphAUG() {
	if (showSecretAUG) {
	secretParagraphAUG.style.display = 'block';
	secretParagraphAUG.style.fontFamily = 'Roboto';
	secretParagraphAUG.style.opacity = '1';
	secretParagraphAUG.style.color = 'darkslategray';
	 
  blogpost22 = `<p class="firstparagraph">Quantum computing, now readily available for science-venturing public consumption: IBM's Quantum Community and Resources offer cloud access to quantum hardware:
  </p>
  <p class="quote">Check out our User Guides and interactive Demos to learn more about quantum principles. Or, dive right in to create and run algorithms on real quantum computing hardware, using the Quantum Composer and QISKit software developer kit.</p>
  <p>With an uncanny resemblence to 22nd century chandeliers, the hardware itself is no light matter: Each successive layer cools down to the the final chamber that runs at a cool .0017 &deg; Kelvin--colder than space!
  </p>`;
  blogcite22 = `<p class="cite">. <a   href="https://quantumexperience.ng.bluemix.net/qx/experience"   target="_blank">https://quantumexperience.ng.bluemix.net/qx/experience
  </a>
  </p>`
 
  blogpost21 = ` 
  <p class="quote">The Lamborghini Aventador SVJ already made a splash last month when it set a new Nürburgring Nordschleife record for production cars, running an incredible 6:44.97 lap time. Now, it sheds its camouflage, and yep, it looks exactly as crazy as we hoped. This might be one of the wildest Lamborghinis yet.<br /><br />
  Since we've tackled the SVJ's Nürburgring lap time, let's cover some other numbers. Its 6.5-liter V12 produces 770 horsepower, making this one of the most powerful naturally aspirated road cars of all time. Maximum torque is 531 lb-ft at 6750 rpm, while the power peak comes at 8500 rpm. Lamborghini claims a dry weight of 3362 lbs, which is 110 lbs lighter than an Aventador S coupe according to the factory. Acceleration is jaw-dropping, too, with 62 mph arriving in 2.8 seconds and 124 mph coming in 8.6. Top speed is 217 mph.<sup>1</sup></p>
  <img src="dist/img/huracan.jpg" /><br />
  <p>Image credit: Road &amp; Track</p>
 
    `;
  blogcite21 = `   <p class="cite">1. <a   href="https://www.roadandtrack.com/car-shows/monterey-car-week/a22822020/2019-lamborghini-aventador-svj-debut-specs-photos-price/"   target="_blank">https://www.roadandtrack.com/car-shows/monterey-car-week/a22822020/2019-lamborghini-aventador-svj-debut-specs-photos-price/
    </a></p> 
    `;
    blogpost20 = `<p class="firstparagraph">Security patches that couldn't have arrived sooner ... </p><p class="quote">The Fortnite Installer was easily exploitable to hijack the request to download the full game.      The problem, as Google's security team discovered, was that the Fortnite Installer was very easily exploitable to hijack the request to download Fortnite from Epic and instead download anything when you tap the button to download the game. It's what's known as a "man-in-the-disk" attack: an app on your phone looks for requests to download something from the internet and intercepts that request to download something else instead, unbeknownst to the original downloading app.<br /><br />Here's where things get really bad. Because of the way Android's permissions model works, you won't have to accept installation of an app from "unknown sources" beyond the time you accepted that installation for Fortnite.  </p>
      <p class="quote"></p>
      `;
    blogcite20 = `   <p class="cite">1. <a   href="https://www.androidcentral.com/epic-games-first-fortnite-installer-allowed-hackers-download-install-silently"   target="_blank"> 
    https://www.androidcentral.com/epic-games-first-fortnite-installer-allowed-hackers-download-install-silently </a></p> 
      `;
      blogpost19 = `<p class="firstparagraph"> </p>
  <p class="quote">
Computers do calculations using bits, too. After all, we want them to plug into our existing data and computers. But quantum bits, or qubits, have unique and powerful properties that allow a group of them to do much more than an equivalent number of conventional bits.

Qubits can be built in various ways, but they all represent digital 0s and 1s using the quantum properties of something that can be controlled electronically. Popular examples—at least among a very select slice of humanity—include superconducting circuits, or individual atoms levitated inside electromagnetic fields. The magic power of quantum computing is that this arrangement lets qubits do more than just flip between 0 and 1. Treat them right and they can flip into a mysterious extra mode called a superposition.<sup>1</sup>
</p> 
<p class="quote">For some problems that are very time consuming for conventional computers, this allows a quantum computer to find a solution in far fewer steps than a conventional computer would need. Grover’s algorithm, a famous quantum search algorithm, could find you in a phone book with 100 million names with just 10,000 operations. If a classical search algorithm just spooled through all the listings to find you, it would require 50 million operations, on average. </p>
        
        `;
      blogcite19 = ` <p class="cite">1.  <a   href="https://www.wired.com/story/wired-guide-to-quantum-computing/"   target="_blank">https://www.wired.com/story/wired-guide-to-quantum-computing/
      </a></p>     `;
      
  blogpost18 = `<p class="firstparagraph">Quantum research has finally progressed beyond proof-of-concept to practical utility. First photon state transfer, and now solid state transfer of "entangled states" allowing for binary, instant data transfer. Beyond medical and enterprise use, quantum entanglement's incremental progress now raises a few eyebrows: 
    </p>
   <p class="quote">That’s because Google, IBM, and others have decided it’s time to invest heavily in the technology, which, in turn, has helped quantum computing earn a bullet point on the corporate strategy PowerPoint slides of big companies in areas such as finance, like JPMorgan, and aerospace, like Airbus. In 2017, venture investors plowed $241 million into startups working on quantum computing hardware or software worldwide, according to CB Insights. That’s triple the amount in the previous year. <br /><br /><sup>1</sup></p>
  
<p>   The cause for excitement accelerates at the pace of progress on the technical engineering side:
   </p>
<p class="quote">Physicists have experimentally demonstrated 18-qubit entanglement, which is the largest entangled state achieved so far with individual control of each qubit. As each qubit has two possible values, the 18 qubits can generate a total of 218 (or 262,144) combinations of output states. Since quantum information can be encoded in these states, the results have potential applications anywhere quantum information processing is used.
 .<sup>2</sup></p>
   <p>So, while there are algorithms, like <i>Shor's SHA-defeating algorithm, that have only existed in theory, can now be applied using capable computational power for the job.</i>
 </p> 
   `;
  blogcite18 =
    `  <p class="cite">1.  <a   href="https://www.wired.com/story/wired-guide-to-quantum-computing/"   target="_blank">https://www.wired.com/story/wired-guide-to-quantum-computing/
   </a></p> 
   
   <p class="cite">2. <a   href="https://phys.org/news/2018-07-qubit-entanglement.html"   target="_blank">https://phys.org/news/2018-07-qubit-entanglement.html
   </a></p>  
   `;


  blogpost17 = `<p class="firstparagraph">Silicon Valley's tide has rolled in and the ships are tucked away for the night. At dawn, Silicon Valley arises and inherits the kingdom, along with Seattle: And, so   become <i> the intractable data needs of all institutions, public or private, big and small--needs only the cloud can answer.</i> </p>
    <p>And why not? Cloud data storage offers security, direct service providers with big data jobs, Netflix and Linkedin's extensive real-time network analsyis using Kafka speeds up their ever-ready recommendations.  Reuters shows a glimpse of the Pentagon's (and other nations's) accelerating need to secure data as the intertwining networks of world data migrates to distributed, cloud storage. In this domain, public infrastructure, whether platform-as-a-service or servers, technology -- as usual -- must swoop to save the day. </p>

    <p class="quote">Consultants associated with the $927 billion Seattle juggernaut occupied top positions at the Pentagon ahead of the rollout of a massive cloud contract worth some $10 billion that Amazon looks poised to snag. Rivals complain the requirements were written to favor Bezos’s company. Either way, investors should be prepared for its government business to attract greater scrutiny.<sup>1</sup> 
    </p>
    <p>Surely controversy awaits any bid decision down here on earth, but all things that go up to the cloud need not come down.</p>
    `;
  blogcite17 =
    `   <p class="cite">1. <a   href="https://www.reuters.com/article/uk-usa-pentagon-breakingviews/breakingviews-amazon-pentagon-ties-may-receive-greater-scrutiny-idUSKBN1L10AS"   target="_blank">https://www.reuters.com/article/uk-usa-pentagon-breakingviews/breakingviews-amazon-pentagon-ties-may-receive-greater-scrutiny-idUSKBN1L10AS
    </a></p> 
    `;

  blogpost16 = `<p class="firstparagraph">Einstein's remark on quantum entanglement's 'spooky' characteristics holds for those caught off-guard, but sudden isn't spooky when sudden is expected. Tokyo's first photon to satellite back to earth with a button switch control almost leads to banality. Yet, transmitting data through a shared quantum state from the first party to second party appears intuitive, even if it is   other-worldly. Wired Magazine:  </p>
    <p class="quote">You may have heard that a qubit in superposition is both 0 and 1 at the same time. That’s not quite true and also not quite false—there’s just no equivalent in Homo sapiens’ humdrum classical reality. If you have a yearning to truly grok it, you must make a mathematical odyssey WIRED cannot equip you for. But in the simplified and dare we say perfect world of this explainer, the important thing to know is that the math of a superposition describes the probability of discovering either a 0 or 1 when a qubit is read out—an operation that crashes it out of a quantum superposition into classical reality.<sup>1</sup>  
    </p>
    <p>Yale researchers on the topic:</p>
    <p class="quote">
    In a quantum process known as teleportation the unknown state of a quantum bit can be relayed to a distant party using shared entanglement and classical information. Here we present experiments in a solid-state system based on superconducting quantum circuits demonstrating the teleportation of the state of a qubit at the macroscopic scale. In our experiments teleportation is realized deterministically with high efficiency and achieves a high rate of transferred qubit states. This constitutes a significant step towards the realization of repeaters for quantum communication at microwave frequencies and broadens the tool set for quantum information processing with superconducting circuits. </i><sup>2</sup></p>
    `;
  blogcite16 = `<p class="cite">1. <a href="https://www.wired.com/story/wired-guide-to-quantum-computing/"   target="_blank">https://www.wired.com/story/wired-guide-to-quantum-computing/
    </a></p>
    <p class="cite">2. <a href="https://seas.yale.edu/news-events/news/quantum-technology-chip"   target="_blank">https://seas.yale.edu/news-events/news/quantum-technology-chip
    </a></p>`;

  blogpost15 = `
    <p class="firstparagraph">Quantum communication of data offers instant data transfer, and impenatrability from 3rd parties ... Among the exciting on events on New Haven's public space Green Park, Yale researchers' quantum advances steal the headlines: </p>
    <p class="quote">The two essential requirements for a scalable quantum information processor are quantum interference (in which a photon – able to be in more than one place at a time – crosses its own path) and single-photon detectors. The chip that the researchers designed contains a nanophotonic waveguide, which can guide light into small spaces and to wherever is needed on the chip. It also has a directional coupler that can split a light beam into two identical beams, or conversely, combine two beams into one output.
    <br /><br />
    With this research, Schuck said the research team should eventually realize a programmable optical quantum processor that can run a quantum algorithm. The scalability of the nanofabrication routines for silicon chips will then allow them to solve problems difficult for classical computers.<sup>1</sup></p>
    <p>Besides the quantum characteristic of a third party's observation/interference, the state is broken and data transfer disappears--and, yet another state is but a button flip's switch away!</p> `;
  blogcite15 = `
    </p>
    <p class="cite">1. <a href="https://arxiv.org/abs/1302.5621"   target="_blank">https://arxiv.org/abs/1302.5621
    </p>
    <p class="cite">1. <a href="https://www.nature.com/articles/ncomms10352"   target="_blank">https://www.nature.com/articles/ncomms10352
    </a>
    </p>
    
    `;
  blogpost14 = `<p class="firstparagraph">      </p>
    <p class="quote">   </p> 
    `;
  blogcite14 = ` 
    <p class="cite">1. <a href="https://www.zdnet.com/article/how-brand-new-science-will-manage-the-fourth-industrial-revolution/"   target="_blank">https://www.zdnet.com/article/how-brand-new-science-will-manage-the-fourth-industrial-revolution/
    </a>
    </p>
    <p class="cite">1. <a href="https://scitechdaily.com/physicists-teleport-information-in-a-solid-state-system/amp/"   target="_blank">https://scitechdaily.com/physicists-teleport-information-in-a-solid-state-system/amp/
    </a>
    </p>
    `;
  blogpost13 = `<p class="firstparagraph"> 
</p><p class="quote"> 
<p >“Historically, magnetism and superconductivity were very disparate fields of physics,” Birge said. “The 1960s’ point of view was that if you were to bring a ferromagnet near a superconductor, you would kill the conductivity.<br /><br />
“It was found that you can put a ferromagnet near a superconductor; in fact, you can even make a ‘sandwich’—superconductor, ferromagnet, superconductor,” said Joseph Glick, a former doctorate student in Birge’s lab and the paper’s lead author. “Any sandwich of this type is called a Josephson junction, which is at the heart of everything we are doing.<sup>1</sup> </p> 
`;
  blogcite13 = `  
<p class="cite">1. <a href="https://msutoday.msu.edu/news/2018/msu-physicists-solve-a-storied-problem/"   target="_blank">https://msutoday.msu.edu/news/2018/msu-physicists-solve-a-storied-problem/
</a>
</p>
`;
  blogpost12 = `<p class="firstparagraph">      </p>
    <p class="quote"> <sup> </sup>
    </p><br />    <p > </p>`;
  blogcite12 = `<p class="cite">  <a href="https://www.nature.com/articles/ncomms10352"   target="_blank">https://www.nature.com/articles/ncomms10352
    </a>
    </p>`;
  blogpost11 = `<p class="firstparagraph">Marvels of anomaly detection extend from business and state security to software integriy -- why not extend the use to <i>social integrity traced by network interaction signatures ...</i> 
    </p>
    <p class="quote">While some attempts to detect social-media accounts of malicious actors rely on content or language filters that terrorists and disinformers have proved capable of confusing, Mr. Alvari’s algorithm looks for accounts that spread content further and faster than expected. Since this is the goal of terrorist recruiters and propagandists alike, the method could be on the front lines of algorithmic filtering across social networks. Humans still need to make the final determination, to avoid false positives. <sup>1</sup>
    </p>
    <p class="quote">While some attempts to detect social-media accounts of malicious actors rely on content or language filters that terrorists and disinformers have proved capable of confusing, Mr. Alvari’s algorithm looks for accounts that spread content further and fas                                                                                                         ter than expected. Since this is the goal of terrorist recruiters and propagandists alike, the method could be on the front lines of algorithmic filtering across social networks. Humans still need to make the final determination, to avoid false positives. <sup>1</sup>
    </p><br />  
    <p > </p>.
 `;
  blogcite11 = ` 
    <p class="cite">1. <a href="https://www.wsj.com/articles/bots-vs-trolls-how-ai-could-clean-up-social-media-1533849001?mod=djemCIO_h"   target="_blank">https://www.wsj.com/articles/bots-vs-trolls-how-ai-could-clean-up-social-media-1533849001?mod=djemCIO_h
    </a>
    </p>`;

  blogpost10 = `<p class="firstparagraph"> 
    </p>
    <p class="quote">Machines used to be serviced according to a plan, and late maintenance would mean a risk of production downtime. Today, process data from machines is used for predicting remaining service life. Especially critical parameters such as temperature, noise, and vibration are recorded to help determine the optimal operating state or even necessary maintenance times. This allows unnecessary wear to be avoided and possible faults and their causes to be detected early on. With the help of this monitoring, considerable optimization potential in terms of facility availability and effectiveness arises, bringing with it decisive advantages.

    The main element in this predictive maintenance (PM) is condition-based monitoring (CBM)

    Addressing Sensor Challenges and Demands for Future Servicing<sup>1</sup>
    </p><br />
    <img src="dist/img/mechDegrade.jpg" width="350px" class="zoom" /><br />
    <p > </p>`;
  blogcite10 = ` 
    <p class="cite">1. <a href="https://www.sensorsmag.com/components/addressing-sensor-challenges-and-demands-for-future-servicing"   target="_blank">https://www.sensorsmag.com/components/addressing-sensor-challenges-and-demands-for-future-servicing
    </a>
    </p>`;

  blogpost9 = `<p class="firstparagraph"> 
    </p>
    <p class="quote">. Arrays of SQUIDs (superconducting quantum interference devices) are currently the most common magnetometer, while the SERF (spin exchange relaxation-free) magnetometer is being investigated for future machines.<sup>1</sup>
    </p><br /> 
    <p > </p>.
 `;
  blogcite9 = `  
    <p class="cite">1. <a href="https://www.xlstat.com/en/solutions/features/classification-and-regression-trees"   target="_blank">https://www.xlstat.com/en/solutions/features/classification-and-regression-trees
    </a>
    </p>`;

  blogpost8 = `<p class="firstparagraph">Classification and Regression (Decision) Trees are not just accurate, multipurpose and foundational to predictive machine learning algorithms (e.g. random forests, bayesian trees, bagging), but the trees' final product reveals the different rationale for the output. Printed onto a sheet   of paper, both statistical practitioner and the domain professional intuitively and heuristically understand practical use for an analysis. This July 2017 Cancer study exemplifies the utility of healthcare-based algorithms of analysis ... 
    </p>
    <p class="quote">The aim of this study was to develop and validate a clinical predictive model for 1-year mortality among patients with colon cancer who survive for at least 30 days after surgery.<br /><br />Random forest, genetic algorithms and classification and regression trees were combined in order to identify the variables and partition points that optimally classify patients by risk of mortality. The resulting decision tree was categorized into four risk categories. Split-sample and bootstrap validation were performed.<sup>1</sup>
    </p><br />
    <img src="dist/img/irisCART.jpg" width="350px" class="zoom" /><br />
    <p >And, now that sound methodology meets an increasingly user-friendly Machine Learning software toolset for wider practical applications, beginning firstly within healthcare technologies <i>and that second opinion!</i></p>.
 `;
  blogcite8 = `Image credits: https://www.xlstat.com/en/solutions/features/classification-and-regression-trees
    <p class="cite">1. <a href="https://www.dovepress.com/combining-statistical-techniques-to-predict-postsurgical-risk-of-1-yea-peer-reviewed-article-CLEP#"   target="_blank">https://www.dovepress.com/combining-statistical-techniques-to-predict-postsurgical-risk-of-1-yea-peer-reviewed-article-CLEP#
    </a>
    </p>`;

  blogpost7 = `<p class="firstparagraph">Predictive analytics  has slowly progressed in sophistication over the past 45 years, and the current nexus with powerful machine-learning tools changes the health game: </p>
    <p class="quote"> A report by ABI Research June 2018 report highlighted a significant rise in patient monitoring devices, including AI for home-based preventative healthcare and predictive analytics, which could save hospitals around $52bn by 2021.<br /><br />

    Accenture’s Digital Health Technology Vision 2018 report also claims that 85% of health executives in the US believe that every human will be directly impacted on a daily basis by an AI-based decision within the next three years.<br /><br />
    
    Utilising big data generated by clinical information and research can reveal clusters and patterns which can benefit all aspects of healthcare, leading patient care to become increasingly strategic.<sup>1</sup>  </p>
    <p>It should be noted that the long road paved by statistical theory has revolutionized the above-mentioned fields as much as it now powers the practical use of analytics:</p>
    <p class="quote">Originating in the statistical (e.g., Holland
      1986; Rosenbaum 2002; Rubin 2005, 2006) and
      econometrics literature (see Heckman 2000,
      2001, 2005; Heckman & Vytlacil 2007a,b;
      Manski 1995, 2007), the counterfactual,
      Rubin, or potential outcomes model of causality
      has, over the past three decades, become
      the standard conceptual tool to unify the notion
      of causality, to understand the identification
      problem at the heart of causal inference,
      and to assess the utility of alternative estimation
      techniques (Sobel 2005).<sup>2</sup></p>
      <p>So, the take-away here is that A.I. and <i>Machine-Learning Research could have never progressed so quickly if not for the settled scientic paradigm over sound analysis that rules out spurious variables, while properly weighting the conditions that matter.</i> Furthermore, the mistakes in algorithm design were made in the 1970's, 1980's, and 1990's--misleading mistakes--have been swept aside, providing much-tested and refined strategies. The medical field's case exemplifies this evolution:</p>
    <p class="quote">Randomized controlled trials are considered the gold
    standard for assessing the efficacy of medications, medical
    procedures, or clinical strategies. Nevertheless, particularly
    for research on the prevention of chronic disease, randomized
    trials are often infeasible because of their size, time,
    and budget requirements, as well as questionable generalizability
    or ethical constraints.<br /><br />
    On the other hand, nonexperimental studies of interventions
    have frequently been criticized because of their potential
    for selection bias. This concern reached a crescendo
    with the disparity in estimated effects of hormone replacement
    therapy from randomized trials and nonexperimental
    studies. This imbroglio highlighted the need to develop
    and apply improved methods to reduce bias in nonexperimental
    studies in which selection bias or confounding is
    likely to occur .<sup>3</sup></p>
    <p>So, nowadays we don't ask for a second opinion when we can ask for a trillion opinions narrowed down to one heck of a second opinion!</p>`;
  blogcite7 = `
    <p class="cite">1. <a href="https://www.healthcareglobal.com/technology/ai-seen-less-threat-and-welcomed-health-professionals-research-reveals"   target="_blank">https://www.healthcareglobal.com/technology/ai-seen-less-threat-and-welcomed-health-professionals-research-reveals
    </a>
    </p>
    <p class="cite">2. <a href="https://www.annualreviews.org/doi/abs/10.1146/annurev.soc.012809.102702"   target="_blank">https://www.annualreviews.org/doi/abs/10.1146/annurev.soc.012809.102702
    </a>
    </p>    <p class="cite">3. <a href="https://www.ncbi.nlm.nih.gov/pmc/articles/PMC1448214/"   target="_blank">https://www.ncbi.nlm.nih.gov/pmc/articles/PMC1448214/
    </a>
    </p>`;

  blogpost6 = `<p class="quote">  <i>[Intel's]  i9-8950HK processor is the first mobile Intel processor with six cores and 12 threads. It comes fully unlocked. It has the new Intel thermal Velocity Boost, which automatically increases clock frequency up to 200 MHz if the processor temperature is low enough and there's enough turbo power, giving a turbo frequency of up to 4.8 GHz.</i></p>
    <p class="quote" The i9-8950HK processor is the first mobile Intel processor with six cores and 12 threads. It comes fully unlocked. It has the new Intel thermal Velocity Boost, which automatically increases clock frequency up to 200 MHz if the processor temperature is low enough and there's enough turbo power, giving a turbo frequency of up to 4.8 GHz.</i>
    </p>
    <p class="firstparagraph"> Needs shape our inventions and our inventions shape our needs: With the brand new set of mobile computing requirements serve up utility for the i9.  Intel's advances pale in comparison, however, to GPU and newer computing trends. This theme arises time after time in my posts, but mathematics will rewrite the rules of performance . . .</p>
    <p class="quote">The 8th Gen processors incorporate Intel Octane memory, a smart and adaptable system accelerator for desktop and mobile platforms using SATA-based storage technology.<br /><br />

    Intel also has released a new Data Drive Acceleration feature that boosts a large secondary HDD hard drive.
    
    Together, Intel Octane and Data Drive Acceleration provide up to 4.7x the game loading speed and 1.7x faster media loading, Intel said.
     </p>
    <p class="quote">
    The actual task of processing AI is a very different process from standard computing or GPU processing, hence the perceived need for specialized chips. A x86 CPU can do AI, but it does a task in 12 steps when only three are required; a GPU in some cases can also be overkill.
    <br /><br />
    Generally, scientific computation is done in a deterministic fashion. You want to know two plus three equals five and calculate it to all of its decimal places—x86 and GPU do that just fine. But the nature of AI is to say 2.5 + 3.5 is observed to be six almost all of the time without actually running the calculation. What matters with artificial intelligence today is the pattern found in the data, not the deterministic calculation. 
    <br /><br />
The result of this predictive problem solving is that AI calculations can be done with single precision calculations. So while CPUs and GPUs can both do it very well, they are in fact overkill for the task. A single-precision chip can do the work and do it in a much smaller, lower power footprint.</p>

<p class="quote">Intel "can deliver on CPU functionality, which has dropped in performance, but still lags on GPUs and modems," noted Rob Enderle, principal analyst at the Enderle Group.

"Much of the performance these days is gated by the modem and the GPU, not the CPU, which just isn't as importance as it once was," he told TechNewsWorld.

Developers may not benefit much from the new processors, Enderle said, because "with IDF shut down, Intel's developer efforts are largely moot."
</p> `;

  blogcite6 = ` 
    <p class="cite">1. <a href="https://www.technewsworld.com/story/85252.html"   target="_blank">https://www.technewsworld.com/story/85252.html
    </a>
    </p>
    
    <p class="cite">2. <a href="https://www.cnet.com/news/intel-core-i9-9900k-may-boost-to-5ghz/"   target="_blank">https://www.cnet.com/news/intel-core-i9-9900k-may-boost-to-5ghz/
    </a>
    </p>
     `;
  blogpost5 = `<p class="firstparagraph">Batteries optimized by machine learning is a feature in the latest version of Android OS, Pie. Some may roll theirs, but the only of desserts that share nameship with the great constant, pi. <i>Mystical 3-1-4 also features A.I.-empowered Textual Analysis, which opens to multiple new possibilities:</i></p>
    <p class="quote">The other new machine learning-powered feature is the smart text selection tool that recognizes the meaning of the text you selected and then allows you to suggest relevant actions like opening Google Maps or bringing up the share dialog for an address.<sup>1</sup></p>
    <p>Further, Android Pie's <i>Digital Wellness</i> features offer all the trending self-obedience features--not the least of which FitBit's guilt-inducing, and highly effective,<strong>walk prompts--already the bots are running my life and I obey!</p></strong>`;
  blogcite5 = ` 
    <p class="cite">1. <a href="https://techcrunch.com/2018/08/06/say-hello-to-android-9-pie/"   target="_blank">https://techcrunch.com/2018/08/06/say-hello-to-android-9-pie/
    </a>
    </p>
     `;
  blogpost4 = `<p class="quote"><i>Bone is constantly turning over through a process in which cells called osteoclasts dig tunnels through bone, and then cells called osteoblasts re-pave those tunnels with new bone. Econs acknowledges that it sounds like an inefficient system, but it has to work this way because you obviously need to be able to use your bones while those repairs are taking place.</i><br /><br />
     --Michael Econ, physician and member of the American Society for Bone and Mineral Research   
     <p class="firstparagraph"><i>Bone loss in space can reach 5 to 10% over the course of a year, however the sure cure is Digital Responsibility, the trending fad of 2018, spans from the upcoming Android Pie's in-device digital behavioral tools across the spectrum to Fitbit, Youtube, and others' timed get-up-and-walk push notifications.       </p>  `;
  blogcite4 = `<p class="cite">1. <a href="https://tonic.vice.com/en_us/article/ne5zg8/this-is-the-effect-working-out-has-on-your-bones"   target="_blank">https://tonic.vice.com/en_us/article/ne5zg8/this-is-the-effect-working-out-has-on-your-bones
     </a>
     </p> 
     `;
  blogpost3 = `<p class="quote"><i>Responsive experience with real-time inferencing. There are many tasks where speed matters. This includes interactive speech, visual search, and video recommendations. As AI models increase in accuracy and complexity, traditional CPUs can’t keep up, and the Tesla P4 GPUs can cut latency by an order of magnitude.<br /><br />
  Video decoding. The Tesla P4 has a dedicated hardware-accelerated decode engine that works in parallel with the GPU, enabling it to transcode and infer up to 35 HD video streams in real time. The integration of deep learning into video pipelines lets organizations offer smarter video services.<br /><br />
  The inferencing engine that the Tesla P4 uses is based on Nvidia’s Pascal architecture and is designed to increase the performance of servers running deep learning workloads. Google didn’t give a date for general availability other than saying it’s “coming soon” to its public cloud.</i></p>  
  <p class="firstparagraph">Toys, if they are offered as presents remain unconditional gifts, and yet the devotion they procure make for a reciprocal gift: Google's Developer Tools and little to no cost serve the same purpose as Microsoft's free provisions of Integrated Develepment Environments, i.e. VS Code and recent purchase of GitHub. The New Data Economy, applies as much to the developers' field as it does to consumers'. </p>  `;
  blogcite3 = `<p class="cite">1. <a href="https://www.cio.com/article/3293424/artificial-intelligence/more-artificial-intelligence-options-coming-to-google-cloud.html"   target="_blank">https://www.cio.com/article/3293424/artificial-intelligence/more-artificial-intelligence-options-coming-to-google-cloud.html
  </a>
  </p> 
  `;
  blogpost2 = `<p class="quote"><i>Google announced it is making Nvidia's Tesla P4 GPU available as a cloud service, enabling more businesses to get started with AI projects quicklyi><sup>1</sup></p>
  <p class="firstparagraph">API Services &agrave; la Google Cloud have become a new Hallmark--available for 12-month free trial--of <i>Google's ambitious  kit: Cloud IoT (Internet of Things) API, Cloud Genomics API, Cloud Machine Learning Engine API, among dozens of others.</i> Rivers of Kubernetes Data,Tensor-Processing-Unit Automotons for Oompah-Loompahs, and the ever-lasting flavor of chewing gum in the name of publicly available data for your tasting pleasure!   </p>`;
  blogcite2 = `<p class="cite">1. <a href="https://www.cio.com/article/3293424/artificial-intelligence/more-artificial-intelligence-options-coming-to-google-cloud.html"   target="_blank">https://www.cio.com/article/3293424/artificial-intelligence/more-artificial-intelligence-options-coming-to-google-cloud.html
  </a>
  </p>`;


  blogpost1 = `<p class="quote"><i>In July, Blackrock — the world’s largest exchange-traded fund (ETF) — announced that it has launched a working group to assess the potential of investing in Bitcoin.  <br /><br />
    Blackrock’s move could be described as a preemptive strike to avoid missing the crypto bus. Goldman Sachs is making headway with cryptocurrency involvement and Blackrock is following suit.</i><sup>1</sup></p>
    <p class="firstparagraph">
    <p class="quote">Fintech broke onto the scene as a disruptive force following the 2008 crisis, but the industry's influence on the broader financial services system is changing.
  
    The fintech industry no longer stands clearly apart from financial services proper, and is increasingly growing embedded in mainstream finance. We're now seeing the initial stages of this transformation.<br /><br />
    
    For instance, funding is growing more internationally distributed, and startups are making necessary adjustments to prove sustainability and secure a seat at the table. Most fintech segments in the ascendant a year ago have continued to rise and grow more valuable to the broader financial system. Meanwhile, several fintech categories have had to make adjustments to stay on top. New subsegments are also appearing on the scene — such as digital identity verification fintechs — as new opportunities for innovation are discovered. 
    <br /><br /> ... 
    The rising influence of fintechs is having a dramatic effect on incumbents, from banks to insurers to wealth managers, pushing them to respond proactively to stay relevant. Incumbents are reacting to changes wrought by fintechs on three key fronts: the front end, the back end, and in their core business operations. As such, incumbents and fintechs are converging on a digital middle ground.
  <br /><br />
    As this happens, the fintech industry is on the cusp of becoming an integral component of the broader financial services ecosystem. But it will likely first have to go through a complete credit cycle, and survive an economic downturn like the one that set the stage for its arrival in 2008, for this to happen.<sup>2</sup>
    </p>
    `;
  blogcite1 = `
    <p class="cite">1. <a href="https://cointelegraph.com/news/institutional-investors-and-fintech-will-wall-street-go-head-first-into-crypto"   target="_blank">https://cointelegraph.com/news/institutional-investors-and-fintech-will-wall-street-go-head-first-into-crypto
    </a>
    </p> 
    <p class="cite">2. <a href="https://www.businessinsider.com/8-3-2018-fintech-ecosystem-financial-technology-research-and-business-opportunities-2018-8?utm_source=feedburner&utm_medium=feed&utm_campaign=Feed%3A+clusterstock+%28ClusterStock%29&r=US&IR=T&IR=T"   target="_blank">https://www.businessinsider.com/8-3-2018-fintech-ecosystem-financial-technology-research-and-business-opportunities-2018-8 
  </a>
  </p> 
    `;

  var url = [  
    {
      id: '22',
      did: '08-25-18',
      date: 'August 25-26, 2018<br />Weekend',
      author: 'by Thomas Maestas',
      cat3: 'Sociology Tomorrow!',
      title: '',
      post: blogpost22,
      blogcite: blogcite22
    }, 
    {
      id: '21',
      did: '08-24-18',
      date: 'August 24, 2018',
      author: 'by Thomas Maestas',
      cat3: 'Sociology Tomorrow!',
      title: 'Air, More Air, and the Tech of Fast Air',
      post: blogpost21,
      blogcite: blogcite21
    }, 
    {
    id: '20',
    did: '08-23-18',
    date: 'August 23, 2018',
    author: 'by Thomas Maestas',
    cat3: 'Web Dev Affairs',
    title: 'The Best Offense is a Good Defense',
    post: blogpost20,
    blogcite: blogcite20
  }, 
   {
    id: '19',
    did: '08-22-18',
    date: 'August 22, 2018',
    author: 'by Thomas Maestas',
    cat3: 'Quantum Data',
    title: 'Quantum Data V:<br />The Bits and Bolts of Zero, One, and the Superposed Third State',
    post: blogpost19,
    blogcite: blogcite19
  }, 
    {
      id: '18',
      did: '08-21-18',
      date: 'August 21, 2018 ',
      author: 'by Thomas Maestas',
      cat3: 'Quantum Data',
      title: 'Quantum Data IV:<br />The Business of Quantum Data  ',
      post: blogpost18,
      blogcite: blogcite18
    },

    {
      id: '17',
      did: '08-20-18',
      date: 'August 20, 2018',
      author: 'by Thomas Maestas',
      cat3: 'Web Dev Affairs',
      title: 'Data that Go Up but Do not Go Down',
      post: blogpost17,
      blogcite: blogcite17
    },
    {
      id: '16',
      did: '08-18-18',
      date: 'August 18-19, 2018<br />Weekend',
      author: 'by Thomas Maestas',
      cat3: 'Quantum Data',
      title: 'Quantum Data III: Sudden Data ',
      post: blogpost16,
      blogcite: blogcite16
    },

    {
      id: '15',
      did: '08-17-18',
      date: 'August 17, 2018',
      author: 'by Thomas Maestas',
      cat3: 'Sociology Tomorrow!',
      title: 'Quantum Data, Part II:<br /> Quantum State-Entanglement across a Solid State',
      post: blogpost15,
      blogcite: blogcite15
    },
    {
      id: '14',
      did: '08-16-18',
      date: 'August 16, 2018',
      author: 'by Thomas Maestas',
      cat3: 'Sociology Tomorrow!',
      title: ' ',
      post: blogpost14,
      blogcite: blogcite14
    },

    {
      id: '13',
      did: '08-15-18',
      date: 'August 15, 2018',
      author: 'by Thomas Maestas',
      cat3: 'Sociology Tomorrow!',
      title: 'Quantum Data',
      post: blogpost13,
      blogcite: blogcite13
    },
    {
      id: '12',
      did: '08-14-18',
      date: 'August 14, 2018',
      author: 'by Thomas Maestas',
      cat3: 'Quantum Data',
      title: '',
      post: blogpost12,
      blogcite: blogcite12
    },

    {
      id: '11',
      did: '08-12-18',
      date: 'August 12-13, 2018<br />Weekend',
      author: 'by Thomas Maestas',
      cat3: 'A.I.Now.',
      title: ' ',
      post: blogpost11,
      blogcite: blogcite11
    },

    {
      id: '10',
      did: '08-11-18',
      date: 'August 11, 2018',
      author: 'by Thomas Maestas',
      cat3: 'Web Dev Affairs',
      title: 'The Good Doctor, Part IV: Good Doctor, Heal Thyself!',
      post: blogpost10,
      blogcite: blogcite10
    },
    {
      id: '9',
      did: '08-10-18',
      date: 'August 10, 2018',
      author: 'by Thomas Maestas',
      cat3: 'A.I.Now.',
      title: 'The Good Doctor, Part III: Magneto Encephelop',
      post: blogpost9,
      blogcite: blogcite9
    },
    {
      id: '8',
      did: '08-09-18',
      date: 'August 9, 2018',
      author: 'by Thomas Maestas',
      cat3: 'Sociology Tomorrow!',
      title: 'The Good Doctor, Part II:  <br />About that Second Opinion . . . <br />',
      post: blogpost8,
      blogcite: blogcite8
    },
    {
      id: '7',
      did: '08-08-18',
      date: 'August 8, 2018',
      author: 'by Thomas Maestas',
      cat3: 'A.I.Now.',
      title: 'The Good Doctor, Part I: <br /> How A.I.-Driven Predictive Analytics Rewrites Healthcare',
      post: blogpost7,
      blogcite: blogcite7
    },
    {
      id: '6',
      did: '08-07-18',
      date: 'August 7, 2018',
      author: 'by Thomas Maestas',
      cat3: 'Web Dev Affairs',
      title: 'New Math &amp; the Speed of Antiquation, a Case Study:<br />Mobile 8th Generation Intel',
      post: blogpost6,
      blogcite: blogcite6
    },
    {
      id: '5',
      did: '08-06-18',
      date: 'August 6, 2018',
      author: 'by Thomas Maestas',
      cat3: 'Web Dev Affairs',
      title: 'Android Pi(e) Day',
      post: blogpost5,
      blogcite: blogcite5
    },
    {
      id: '4',
      did: '08-04-18',
      date: 'August 4-5, 2018<br />Weekend',
      author: 'by Thomas Maestas',
      cat3: 'Sociology Tomorrow!',
      title: 'The New Age of Digital Responsibility',
      post: blogpost4,
      blogcite: blogcite4
    },
    {
      id: '3',
      did: '08-03-18',
      date: 'August 3, 2018',
      author: 'by Thomas Maestas',
      cat3: ' ',
      title: 'Tour of Google\'s Chocolate Factory, Part II:<br />Glass Elevator into the Cloud',
      post: blogpost3,
      blogcite: blogcite3
    },
    {
      id: '2',
      did: '08-02-18',
      date: 'August 02, 2018<br />Weekend',
      author: 'by Thomas Maestas',
      cat3: 'Web Dev Affairs',
      title: 'Tour of Google\'s Chocolate Factory, Part II:<br />Google\'s Golden Ticket',
      post: blogpost2,
      blogcite: blogcite2
    },
    {
      id: '1',
      did: '08-01-18',
      date: 'August 1, 2018',
      author: 'by Thomas Maestas',
      cat3: 'Musing Blockchain',
      title: 'Fintech Auchtung!',
      post: blogpost1,
      blogcite: blogcite1
    }

  ];

  for (i = 0; i < url.length; i++) {
    var cat = ` 
    <div id="${url[i].did}" class="blogDiv"> 
    <hr />  
    <a href="#top"><button>Top</button></a>  
    <h4 class="title dailytech longtitle">OUR DAILY TECH:</h4>  
    <h5 id="cat3" class="  subdailytech">${url[i].cat3}</h5> 
    <p id="author" class="  author">${url[i].author}</p>   
    <h6  id="date" class="  chapternumber">${url[i].date}</h6>    
    <h6  id="title"   class="dailytitle chapternumber">${url[i].title}</h6>
    <br />
    <div id="post">${url[i].post}
    </div>
    <div id="blogcite">${url[i].blogcite}
   
   </div>` ;
	
   secretParagraphAUG.innerHTML  += cat;   
}  
document.getElementById("paragraph-aug").innerHTML = cat; 

} else {

	secretParagraphAUG.style.display = 'none';
	} 
	} 
/* END*/
	$scope.getArchives = function(){
		$http.get('/api/archives').success(function(response){
			$scope.archives = response;
		});
	};
 
  
}]); 