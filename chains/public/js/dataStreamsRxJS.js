// 0. mouseEvents
const doubleClick = Rx.Observable.fromEvent(document, 'dblclick')
doubleClick.subscribe(dblclick => console.log(dblclick))

const clicks = Rx.Observable.fromEvent(document, 'click')
clicks.subscribe(click => printMouse('X: ' + JSON.stringify(click.clientX) + ' | ' + 'Y: ' + JSON.stringify(click.clientY)))

// 1. Syntax
const observable = Rx.Observable.create(observer => {
    observer.next('this is ...')
    observer.next('...your data STREAM!\n\n')
})
observable.subscribe(val => print1('1. ' + val))

// 2. Promise to Observable
const promesa = new Promise((resolve, reject) => {
    setTimeout(() => {
        resolve("2. ...PROMISE resolved\n\n");
    }, 1000);
});
const observaPromesa = Rx.Observable.fromPromise(promesa);
observaPromesa.subscribe(result => print1(result));

// 3. Timer
const timer = Rx.Observable.timer(0)
timer.subscribe(done => print1('3. TIMER ding!\n\n'))

// 4. Miscellaneous Observables
const mashUp = Rx.Observable.of('string', ['array'], 12) //, true, { property: 'value' })
mashUp.subscribe(val => print1('4. Misc ' + val + '\n\n'))

// 5. Cold Observable (value is build inside the observable...)
const coldOne = Rx.Observable.create(observer => {
    observer.next(Math.random())
});
coldOne.subscribe(a => print1(`5. Cold Subscribe_A: ${a}`))
coldOne.subscribe(b => print1(`5. Cold Subscribe_B: ${b}\n\n`))

// 6. Hot Observable (value build outside of observable, so same for subscribers)
const x = Math.random();
const hotOne = Rx.Observable.create(observer => {
    observer.next(x)
});
hotOne.subscribe(a => print1(`6a. Hot Subscribe_A: ${a}`))
hotOne.subscribe(b => print1(`6a. Hot Subscribe_B: ${b}\n\n`))
    // OR //
const cold = Rx.Observable.create(observer => {
    observer.next(Math.random())
});
const hot = cold.publish()
hot.subscribe(a => print1(`6b. Hot Subscribe_A: ${a}`))
hot.subscribe(b => print1(`6b. Hot Subscribe_B: ${b}\n\n`))
hot.connect()

// 7. Completion
const timerComplete = Rx.Observable.timer(0);
timer
    .finally(() => print2('7. Timer .FINALLY completed!\n\n'))
    .subscribe()

// 8. Interval
const interval = Rx.Observable.interval(200)
    // interval.subscribe(int => print1(new Date().getSeconds())) 
    .finally(int => print2('8a. Interval ' + new Date() + '\n\n'))

// Interval manually unsubscribed 
const unSubscribe = interval.subscribe(x => print2('8b.unsubscribe() ' + x))
setTimeout(() => {
    unSubscribe.unsubscribe()
}, 500)

// 9.  MAP
const nums = Rx.Observable.of(10, 1000);
nums.map(num => Math.log(num))
    .finally(() => print1('\n\n'))
    .subscribe(n => print1('9 MAP:  ' + n))

const jsonString = '{ "type": "Dog", "breed": "pug" }';
const apiCall = Rx.Observable.of(jsonString);
apiCall.map(json => JSON.parse(json))
    .subscribe(obj => {
        print1('9b. MAP: ' + obj.type)
        print1('9b: MAP' + obj.breed + '\n\n')
    })

// 10. DO
const names = Rx.Observable.of('Thomas', 'milton')
names
    .do(name => print1(name))
    .map(name => name.toUpperCase())
    .do(name => print1('10. DO: ' + name + '\n\n'))
    .subscribe()

// 11.  FILTER
const numFilters = Rx.Observable.of(-2, 3, 33, 34, -3);
numFilters.filter(n => n <= 0)
    .finally(() => print2('\n\n'))
    .subscribe(n => print2('11. FILTER: ' + n))

// 12. first()
const numFirst = Rx.Observable.of(-2, 3, 33, 34, -3)
    .first()
    .subscribe(n => print2('12. first: ' + n + '\n\n'))


// 13. throttle()
let mouseEvents = Rx.Observable.fromEvent(document, 'mousemove')
    //mouseEvents
    //    .subscribe(e => print2(e.type));
    // mouseEvents
    //     .throttleTime(1000) // GIVES FIRST VALUE, WAITS 1000
    //     .subscribe(e => print2('13. THROTTLE: ' + e.type));
mouseEvents
    .debounceTime(1000) // WAITS 1000, THEN GIVES LAST VALUE
    .subscribe(e => print2('13. DEBOUNCE: ' + e.type + '\n\n'));

//. 14 scan()  JUST LIKE ARRAY REDUCE
let cliicks = Rx.Observable.fromEvent(document, 'click')
cliicks
    .map(e => parseInt(Math.random() * 10))
    .do(score => printMouse(`14. SCAN -- Click scored = ${score}`))
    .scan((highScore, score) => highScore + score)
    .subscribe(highScore => printMouse(`14. SCAN High Score ${highScore}` + '\n\n'))

//. 15. switchMap()2
let clicksSwitch = Rx.Observable.fromEvent(document, 'click');
const stopSwitchMap = Rx.Observable.timer(2000)
clicksSwitch.switchMap(click => {
        return Rx.Observable.interval(500)
    })
    .takeUntil(stopSwitchMap)
    .finally(() => print2('--15.SWITCHMAP finally'))
    .subscribe(i => print2('--15 SWITCHMAP ' + i + '\n\n'))

// 16. takeUntil
const interv = Rx.Observable.interval(500)
const notify = Rx.Observable.timer(2000)
interv
    .takeUntil(notify)
    .finally(() => print2('--16. finally'))
    .subscribe(i => print2('--16 TAKEUNTIL: ' + i + '\n\n'))

// 17.takeWhile
const namex = Rx.Observable.of('17. tom', '17. milton', 'maestas', 'another-name')
namex
.takeWhile(name => name != 'maestas')
.finally(() => print2('17. TAKEWHILE, found name \n\n'))
.subscribe(i => print2(i))

// 18. zip
const yin = Rx.Observable.of('peanut butter', 'wine', 'random')
const yang = Rx.Observable.of('jelly', 'cheese', 'orderly')

const combined = Rx.Observable.zip(yin, yang)
combined.subscribe(arr => print2('18. ZiP ' + arr))
 

// 19.forkJoin 
const yina = Rx.Observable.of('peanut butter', 'wine', 'random')
const yanga = Rx.Observable.of('jelly', 'cheese', 'orderly').delay(2000)

const forkJoined = Rx.Observable.forkJoin(yin, yang)
forkJoined.subscribe(arr => print2('19. FORKJOIN ' + arr))
 
// 20. catch 
const observeError = Rx.Observable.create( observer => {
    observer.next('good')
    observer.next('greate')
    observer.next('grand')
    //  throw '20. CATCH this!'  
    observer.next( 'wonderful' )
})
observeError
    .catch (err => print2( `Error caught: ${err}`))
    .retry(2)
    .subscribe( val => print2(val))

// 21. subject()
const subjectt = new Rx.Subject()

const subjA = subjectt.subscribe( val => print2(`21.Subject(A): ${val}`))
const subjB = subjectt.subscribe( val => print2(`21.Subject(B): ${val}`))
subjectt.next('hi ')
setTimeout(() => {
    subjectt.next('there...')
}, 1000)
// 22. subject()
const observMulticast = Rx.Observable.fromEvent(document, 'click');
const clickss = observMulticast
    .do( _ => print2('Do one time!'))
    const subject = clickss.multicast(() => new Rx.Subject() );
    const subA = subject.subscribe( c => print2(`22.SUBJECT-A: ${c.timeStamp}`))
    const subB = subject.subscribe( c => print2(`22.SUBJECT-B: ${c.timeStamp}`))
    subject.connect();

// 23. async
///
    const array1 = [{
        "Date": "2019-07-04",
        "Symbol": "BTCUSD",
        "Open": 11976.42,
        "High": 12064.26,
        "Low": 11820,
        "Close": 11909.55,
        "Volume BTC": 1237.57,
        "Volume USD": 14790355.69
    },
    {
        "Date": "2019-07-04",
        "Symbol": "ETHUSD",
        "Open": 301.79,
        "High": 304,
        "Low": 300.39,
        "Close": 301.5,
        "Volume ETH": 3825.69,
        "Volume USD": 1154988.12
    }
    ];
    const array2 = 
    {
        "Date": "2019-07-05",
        "Symbol": "LITECOIN",
        "Open": 101.79,
        "High": 104,
        "Low": 100.39,
        "Close": 101.5,
        "Volume LTC": 825.69,
        "Volume USD": 7777777.77
    }
    function afterTheDelay() {
    setTimeout(() => {
        let outputPromise = "";
        array1.forEach((array1, index) => {
            outputPromise += `<li>Date: ${array1.Date} Symbol:  ${array1.Symbol} Close: ${array1.Close}</li>`;
        });
        document.getElementById("array1").innerHTML = "<strong>Local Ether + Bitcoin:</strong><br />" + outputPromise;
    }, 2000);
    }

    function addPromise(price) {
        return new Promise((resolve, reject) => { 
            setTimeout(() => {
                array1.push(price);
                console.log("hey num2")
                // const error = true;
                const error = false;
                if (!error) {
                    resolve();
                } else {
                    reject(console.log("%c Promise Errorrr occured", "color:orange; border:solid 1px orange"));
                }
            }, 2000);
        });
    } 
    const promesa_New = new Promise((resolve, reject) => {
        setInterval(() => {  
            resolve(array1.push(
                {                   
                "Date": "2019-07-05",
                "Symbol": "NEWCOIN",
                "Open": 101.79,
                "High": 104,
                "Low": 100.39,
                "Close": 101.5,
                "Volume LTC": 825.69,
                "Volume USD": 7777777.77
            }
            ));  
            array1.push(array2) 
           console.log("inside Promes_NEW")
        }, 3000);
    });
    const observaPromesa_New = Rx.Observable.fromPromise(promesa_New);
    observaPromesa.subscribe(result => print3(result));
    /// 
    async function initAsync() {
    await addPromise({
        "Date": "2020-01-02",
        "Symbol": "coinASYNCAdded",
        "Open": 13000.00,
        "High": 14000,
        "Low": 12000.00,
        "Close": 1350.00
    });
    afterTheDelay();
    }
    initAsync(); 
/// 



/////////////////////////////////
// left colum
function print1(val) {
    let el = document.createElement('p')
    el.innerText = val;
    document.getElementById("analytics").appendChild(el)
}
function print3(val) {
    let el2 = document.createElement('p');
    el2.innerText = val
    document.getElementById("analyticsNum2").appendChild(el2)
}

// middle column
function print2(val) {
    let el = document.createElement('p')
    el.innerText = val;
    document.getElementById("analytics2").appendChild(el)
}

// right column
function printMouse(val) {
    let el = document.createElement('p')
    el.innerText = val;
    document.getElementById("mouse").appendChild(el)
}