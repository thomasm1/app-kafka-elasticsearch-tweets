 

  setTimeout(function() {

 
        // OLD_KEY: NNKOjkoul8n1CH18TWA9gwngW1s1SmjESPjNoUFo
        // NEW_KEY: p2o1kCukELyMEhVm912JFO17GgidlBIx4dhi4Ppu
        let url = "https://api.nasa.gov/planetary/apod?api_key=mF6DQEqY3WtCubgab5P2otQQ6bP1b8nY24VmiJw0";
        let xhttp = new XMLHttpRequest();

        xhttp.onreadystatechange = function () {
          // console.log("onreadystate changed")
          // if (xhttp.readyState == 4 && xhttp.statusText == 200) {  
          // console.log("200");
          let result = JSON.parse(this.responseText);
          // console.log(this.responseText);

          if (result.copyright != "") {
            document.getElementById("copyright").innerHTML = "Image Credits: " + result.copyright;
          }
          else {
            document.getElementById("copyright").innerHTML = "Image Credits: " + "Public Domain";
          }

          if (result.media_type == "video") {
            document.getElementById("apod_img_id").style.display = "none";
            document.getElementById("apod_vid_id").setAttribute("src", result.url);
          }
          else {
            document.getElementById("apod_vid_id").style.display = "none";
            document.getElementById("apod_img_id").setAttribute("src", result.url);
          }
            document.getElementById("reqObject").text = url;
            document.getElementById("returnObject").innerHTML = JSON.stringify(result, null, 4);

            document.getElementById("apod_explaination").innerHTML = result.explanation;
            document.getElementById("apod_title").innerHTML = result.title;
          // }
        }
        xhttp.open("GET", url, true);
        xhttp.send();  
// var url = "https://api.nasa.gov/planetary/apod?api_key=NNKOjkoul8n1CH18TWA9gwngW1s1SmjESPjNoUFo";


// $.ajax({
//   url: url,
//   success: function(result){
//   if("copyright" in result) {
//     $("#copyright").text("Image Credits: " + result.copyright);
//   }
//   else {
//     $("#copyright").text("Image Credits: " + "Public Domain");
//   }
  
//   if(result.media_type == "video") {
//     $("#apod_img_id").css("display", "none"); 
//     $("#apod_vid_id").attr("src", result.url);
//   }
//   else {
//     $("#apod_vid_id").css("display", "none"); 
//     $("#apod_img_id").attr("src", result.url);
//   }
//   $("#reqObject").text(url);
//   $("#returnObject").text(JSON.stringify(result, null, 4));  
//   $("#apod_explaination").text(result.explanation);
//   $("#apod_title").text(result.title);
// }
// });
  
  }, 2500); 
  