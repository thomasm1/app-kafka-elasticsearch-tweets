// Most of this material
// I gleaned from FROM WEBSITE https://css-tricks.com/now-ever-might-not-need-jquery/ 
// POLYFILL  <script src="https://cdn.polyfill.io/v2/polyfill.min.js"></script>

// JS ES6 METHODS

// jQuery 
var $elem = $(".someClass");
$elem.remove();
$elem.prepend($otherElem)
$elem.before($otherElem)
$elem.replaceWith($otherElem)
$elem.closest('div')

// vanilla alternatives


var elem = document.querySelector(".someClass")
elem.remove();
elem.prepend(otherElem)
elem.before(otherElem)
elem.replaceWith(otherElem)
elem.closest('div')




// TRANSITIONS

// jQuery 
var $elem = $(".someClass")
$elem.animate({
    width: "70%",
    opacity: 0.4,
    marginLeft: "0.6in",
    fontSize: "3em",
    borderWidth: "10px"
}, 1500);
 
// vanilla alternatives

var elem = document.querySelector(".someClass");
elem.animate([
    {
        transform: 'translateY(-1000px) scaleY(2.5) scaleX(.2)',
        transformOrigin: '50% 0',
        filter: 'blur(40px)',
        opacity:0
    },
    {
        transform: 'translateY(0) scaleY(1) scaleX(1)',
        transformOrigin: '50% 50%',
        filter: 'blur(0)',
        opacity:1
}
],1000);
 


// AJAX

// jQuery 
var $elem = $(".someClass")
$.ajax('https://some.url', {
    success: (data) => { /* do stuff with data */}
});
 

// vanilla alternatives

var elem = document.querySelector(".someClass"); 
fetch("https://some.url")
.then(response => response.json())
.then(data => {
    //do stuff with data
});

############# GENERIC ES6+ METHODS
## let a, b, rest;
[a, b] = [10, 20];
console.log(a); // 10
console.log(b); // 20

[a, b, ...rest] = [10, 20, 30, 40, 50];
console.log(a); // 10
console.log(b); // 20
console.log(rest); // [30, 40, 50]

({ a, b } = { a: 10, b: 20 });
console.log(a); // 10
console.log(b); // 20

// Stage 4(finished) proposal
({a, b, ...rest} = {a: 10, b: 20, c: 30, d: 40});
console.log(a); // 10
console.log(b); // 20
console.log(rest); // {c: 30, d: 40}
