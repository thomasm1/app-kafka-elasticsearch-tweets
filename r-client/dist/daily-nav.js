document.getElementById("dailyNav").innerHTML = `<nav class="navbar navbar-toggleable-sm  fixed-top bg-primary app-navbar">
   
    <style>
 li#banner {
       
        
    }
    </style>
 
 
    <button aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation"
        class="navbar-toggler navbar-toggler-center hidden-md-up" data-target="#navbarResponsive" data-toggle="collapse"
        type="button" on-click="fadeUp()" id="toggler"> </button>

    <div class="collapse navbar-collapse   multi_drop_menu   menu" id="navbarResponsive">
        <ul class="navbar-nav mr-auto ">
            <li  id="banner" >
            <img src="dist/img/ourdailytechbanner.png" alt="our dailytech banner"  />
            </li>
            <li class="nav-item   ">
                <a class="nav-link" href="/" data-target="#navbarResponsive" data-toggle="collapse" type="button"
                    on-click="fadeUp()">
                    <span class=" subdailytech"> TECH
                        <br />BLOG </span>
                </a>
            </li>
            <li class="nav-item  ">
                <a class="nav-link" href="/archives" data-target="#navbarResponsive" data-toggle="collapse"
                    type="button" on-click="fadeUp()">
                    <span class="subdailytech ">BLOG  ✨
                        <br />ARCHIVES </span>
                </a>
            </li>
            <li class="nav-item hidden">
                <a class="nav-link" ng-href="https://www.ourdailytech.net/_For_Cat_Eyes_Only_/index.html"
                    title="tmm FICTION" data-target="#navbarResponsive" data-toggle="collapse" type="button">
                    <span class="caret subdailytech">FOR_CAT
                        <br />EYES_ONLY</span>
                </a>

                <a class="nav-link" ng-href="/_For_Cat_Eyes_Only_" title="tmm FICTION" data-target="#navbarResponsive"
                    data-toggle="collapse" type="button">
                    <span class="caret subdailytech">FOR_CAT
                        <br />EYES_ONLY</span>
                </a>
                <ul style="z-index:0" class="menu-left">
                    <li>
                        tmm FICTION
                        <a style="z-index:199; " ng-href="https://www.ourdailytech.net/_For_Cat_Eyes_Only_/index.html"
                            title="tmm FICTION" data-target="#navbarResponsive" data-toggle="collapse" type="button">For
                            Cat Eyes Only:
                            <i>Early Months of Win&#39;s Campaign</i>
                        </a>
                    </li>
                    <li style="z-index:199; ">
                        tmm FICTION
                        <a style="z-index:199; "
                            ng-href="https://www.ourdailytech.net/_For_Cat_Eyes_Only_/index.html#capturing"
                            title="tmm FICTION" data-target="#navbarResponsive" data-toggle="collapse"
                            type="button">Fiction Excerpts From:
                            <br />
                            <i>The Casperian Ancestries</i>
                            <br />
                            <small>Capturing One Cat&#39;s Past and Present</small>
                        </a>
                        tmm FICTION
                    </li>
                </ul>
            </li>
            <li style="z-index:5" class="nav-item">
                <a class="nav-link" data-target="#navbarResponsive" data-toggle="collapse" type="button"
                    on-click="fadeUp()">
                    <span class=" subdailytech">DEV
                        <br /> TOOLS
                    </span>
                </a>


                <ul>

                    <!--START UL -->

                    <li style="z-index:100;">
                        <a aria-expanded="false" aria-haspopup="true" class="dropdown-toggle" data-toggle="dropdown"
                            role="button"> Web &nbsp;&nbsp;
                            <span> </span>
                        </a>


                        <ul>
                            <li style="z-index:100;">
                                <a href="http://webreference.com/" target="_blank">Web Reference</a>
                            </li>
                            <li>
                                <a href="https://developer.mozilla.org" target="_blank">Mozilla Dev</a>
                            </li>
                            <li>
                                <a href="http://support.google.com/webmasters/?hl=en" target="_blank">Google Dev</a>
                            </li>
                            <li>
                                <a href="http://developer.yahoo.com/" target="_blank">Yahoo! Dev</a>
                            </li>
                            <li>
                                <a href="http://www.w3schools.com" target="_blank">W3 schools</a>
                            </li>
                            <li>
                                <a href="http://www.w3.org/" target="_blank">World Wide Web Consortium</a>
                            </li>
                            <li>
                                <a href="https://www.icann.org" target="_blank">ICANN</a>
                            </li>
                        </ul>
                    </li>
                    <li style="z-index:98.2;">
                        <a aria-expanded="false" aria-haspopup="true" class="dropdown-toggle" data-toggle="dropdown"
                            role="button"> D3 tools &nbsp;&nbsp; </a>
                        <ul class="dropdown-menu">
                            <li style="z-index:98">
                                <a href="http://d3js.org" target="_blank">D3js</a>
                            </li>
                            <li style="z-index:98.5">
                                <a
                                    href="https://github.com/d3/d3-3.x-api-reference/blob/master/API-Reference.md">d3.v3</a>
                            </li>
                            <!--    <li style="z-index:98.5">
        <a href="https://chartio.com/" target="_blank">chartio</a>
    </li>
    <li style="z-index:98.5">
    <a href="http://code.shutterstock.com/rickshaw/" target="_blank">rickshaw</a>
</li>
<li style="z-index:98.5">
    <a href="http://rawgraphs.io/" target="_blank">rawgraphs.io </a>
</li>
<li style="z-index:98.5">
    <a href="http://dimplejs.org" target="_blank">dimplejs</a>
</li>
<li style="z-index:98.5">
    <a href="http://nvd3.org/" target="_blank">nvd3</a>
</li>
<li style="z-index:98.5">
    <a href="https://developer.mozilla.org/en-US/docs/Web/SVG" target="_blank">SVG</a>
</li>
<li style="z-index:98.5">
    <a href="https://www.khronos.org/webgl/" target="_blank">WebGL</a>
</li>
<li style="z-index:98.5">
    <a href="https://developer.mozilla.org/en-US/docs/Web/API/Canvas_API" target="_blank">Canvas</a>
</li>
<li>
<a href="https://www.telerik.com/kendo-ui"  >  <i class="fa fa-cog"></i></a>
</li>
<li style="z-index:98.5">
    <a href="http://alignedleft.com/tutorials/d3/binding-data" target="_blank">binding-data</a>
</li>
<li style="z-index:98.5">
    <a href="http://datajournalismhandbook.org/1.0/en/getting_data_3.html" target="_blank">getting_data</a>
</li>
<li style="z-index:98.5">
    <a href="https://developer.mozilla.org/en-US/docs/Web/API/Canvas_API" target="_blank">Canvas</a>
</li>
<li style="z-index:98.5">
    <a href="https://github.com/d3/d3/blob/master/CHANGES.md" target="_blank">d3.v4 changes</a>
</li>
-->
                            <li style="z-index:98">
                                <a href="https://github.com/d3/d3/blob/master/API.md" target="_blank">D3js APIs</a>
                            </li>

                        </ul>
                    </li>
                    <li style="z-index:98;">
                        <a aria-expanded="false" aria-haspopup="true" class="dropdown-toggle" data-toggle="dropdown"
                            role="button">Javascript &nbsp;&nbsp; </a>
                        <ul class="dropdown-menu">
                            <li style="z-index:98">
                                <a href="https://jsbin.com" target="_blank">JS Bin</a>
                            </li>
                            <li style="z-index:98">
                                <a href="https://developer.mozilla.org/en-US/docs/Web/API" target="_blank">JavaScript
                                    APIs</a>
                            </li>
                        </ul>
                    </li>
                    <li style="z-index:10 ;">
                        <a aria-expanded="false" aria-haspopup="true" class="dropdown-toggle" data-toggle="dropdown"
                            role="button">Datasets &nbsp;&nbsp;</a>
                        <ul>
                            <li style="z-index:10 ;">
                                <a href="http://www.icpsr.umich.edu/icpsrweb/ICPSR/index.jsp" target="_blank">ICPSR
                                    Datasets</a>
                            </li>
                            <li style="z-index:10 ;">
                                <a href="http://data.imf.org/?sk=7CB6619C-CF87-48DC-9443-2973E161ABEB"
                                    target="_blank">Datasets IMF</a>
                            </li>
                        </ul>
                    </li>
                    <li style="z-index:101;">
                        <a aria-expanded="false" aria-haspopup="true" class="dropdown-toggle" data-toggle="dropdown"
                            role="button">Stats &nbsp;&nbsp;</a>
                        <ul>
                            <li style="z-index:101;">
                                <a href="https://stats.idre.ucla.edu/other/dae/" target="_blank">Stats</a>
                            </li>
                            <li style="z-index:101;">
                                <a href="http://openrefine.org/" target="_blank">OpenRefine</a>
                            </li>
                            <li style="z-index:102;">
                                <a href="http://statacumen.com" target="_blank">Stat Acumen</a>
                            </li>
                            <li style="z-index:102;">
                                <a href="http://www.mapageweb.umontreal.ca/durandc/" target="_blank">Montr&eacute;al
                                    Stats</a>
                            </li>
                        </ul>
                    </li>
                    <li style="z-index:12;">
                        <a aria-expanded="false" aria-haspopup="true" class="dropdown-toggle" data-toggle="dropdown"
                            role="button">SQL &nbsp;&nbsp; </a>
                        <ul>
                            <li style="z-index:12;">
                                <a target="_blank">MySQL &nbsp;&nbsp;</a>
                            </li>
                            <li style="z-index:12;">
                                <a href="https://www.mysql.com/" target="_blank">MySQL</a>
                            </li>
                            <li style="z-index:121;">
                                <a href="http://www.oracle.com/technetwork/developer-tools/apex/overview/index-155186.html"
                                    target="_blank">Oracle Express</a>
                            </li>
                            <li style="z-index:121;">
                                <a href="http://iacademy.oracle.com" target="_blank">Application Express</a>
                            </li>
                        </ul>
                    </li>
                    <li style="z-index:1;">
                        <a aria-expanded="false" aria-haspopup="true" class="dropdown-toggle" data-toggle="dropdown"
                            role="button"> R-Project &nbsp;&nbsp; </a>
                        <ul>
                            <li style="z-index:1;">
                                <a href="https://www.r-project.org/" target="_blank">R-Project </a>
                            </li>
                            <li>
                                <a href="https://www.rstudio.com/" target="_blank">RStudio</a>
                            </li>
                            <li>
                                <a href="https://shiny.rstudio.com/" target="_blank">Shiny</a>
                            </li>
                            <li>
                                <a href="http://amsantac.co/blog/en/2015/10/31/qgis-r.html" target="_blank">Open GIS</a>
                            </li>
                            <li>
                                <a href="http://www.tableau.com/products/cloud-bi" target="_blank">Tableau </a>
                            </li>
                        </ul>
                    </li>
                    <li style="z-index:1;">
                        <a aria-expanded="false" aria-haspopup="true" class="dropdown-toggle" data-toggle="dropdown"
                            role="button"> Python &nbsp;&nbsp; </a>
                        <ul>
                            <li style="z-index:1;">
                                <a href="https://www.python.org/" target="_blank">Python.org</a>
                            </li>
                            <li>
                                <a href="https://pypi.python.org/pypi" target="_blank">Python Package Index</a>
                            </li>
                            <li>
                                <a href="https://docs.python.org/2/library/index.html" target="_blank">Python Standard
                                    Library</a>
                            </li>
                            <li>
                                <a href="https://pandas.pydata.org/pandas-docs/stable/" target="_blank">Pandas Data
                                    Analysis Toolkit</a>
                            </li>
                        </ul>
                    </li>
                    <li style="z-index:9;">
                        <a aria-expanded="false" aria-haspopup="true" class="dropdown-toggle" data-toggle="dropdown"
                            role="button">Validators &nbsp;&nbsp;</a>
                        <ul>
                            <li style="z-index:9;">
                                <a href="https://stats.idre.ucla.edu/other/dae/" target="_blank">Validators </a>
                            </li>
                            <li>
                                <a href="http://validator.w3.org" target="_blank">HTML validator</a>
                            </li>
                            <li>
                                <a href="http://jigsaw.w3.org/css-validator/" target="_blank">CSS validator</a>
                            </li>
                            <li>
                                <a href="http://jsonlint.com/" target="_blank">JSON Validator</a>
                            </li>
                        </ul>
                    </li>
                    <li style="z-index:1;">
                        <a href="http://html-color-codes.info/" target="_blank">Color Codes</a>
                    </li>
                    <li style="z-index:1;">
                        <a href="https://inkscape.org/en/" target="_blank">Inkscape</a>
                    </li>
                    <li style="z-index:1;">
                        <a href="https://v4-alpha.getbootstrap.com" target="_blank">Bootstrap</a>
                    </li>
                    <li style="z-index:1;">
                        <a href="http://www.dynamicdrive.com/" target="_blank">Dynamic Drive</a>
                    </li>
                    <li style="z-index:1;">
                        <a href="http://php.net" target="_blank">PHP.net</a>
                    </li>
                    <li>
                        <a href="http://www.useit.com/" target="_blank">Jakob Nielson</a>
                    </li>
                    <li>
                        <a href="http://www.alistapart.com/" target="_blank">A List Apart</a>
                    </li>
                    <li>
                        <a href="http://codepen.io/" target="_blank">codepen.io</a>
                    </li>
                    <li>
                        <a href="http://www.sitepoint.com/" target="_blank">sitepoint</a>
                    </li>
                    <li>
                        <a href="http://www.kaggle.com" target="_blank">Kaggle</a>
                    </li>
                    <li>
                        <a href="http://plnkr.co/" target="_blank">Plunker</a>
                    </li>
                    <li>
                        <a href="https://github.com" target="_blank">GitHub</a>
                    </li>
                    <li>
                        <a href="https://gist.github.com/" target="_blank">Gist
                            <small>GitHub</small>
                        </a>
                    </li>
                    <li>
                        <a class="last" href="http://stackoverflow.com" target="_blank">Stack Overflow</a>
                    </li>
                    <li>
                        <a href="https://www.virtualbox.org/" target="_blank">Virtual Box</a>
                    </li>
                </ul>
                <!--end UL-->


            </li>
        </ul>
        <ul id="media" class="nav navbar-nav navbar-right">


            <li>

                <a title="Medium" href="https://medium.com/@thomasm1" target="_blank">

                    <i class="fa fa-medium"></i>

                </a>

            </li>
            <li>

                <a title="github" href="https://github.com/thomasm1" target="_blank">

                    <i class="fa fa-github"></i>

                </a>

            </li>


            <li>

                <a title="facebook" href="https://www.facebook.com/thomasm1.maestas" target="_blank">

                    <i class="fa fa-facebook"></i>

                </a>

            </li>

            <li>

                <a title="linkedin" href="http://linkedin.com/in/thomasmaestas" target="_blank">

                    <i class="fa fa-linkedin"></i>

                </a>

            </li>
            
            <!--End UL -->

        </ul>
        <abbr title="Our Daily Tech">

            <img class="card-profile-img zoom" id="dailylogo" alt="image of Le Mont Real"
                src="dist/img/blueColorTriomphe.png" />

        </abbr>

    </div>

</nav>`