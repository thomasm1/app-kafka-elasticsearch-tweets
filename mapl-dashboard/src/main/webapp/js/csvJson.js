// d3 STACKS
//console.log("%c D3 data convert csv->json: ", "border:outset 3px silver;color:black; background-color:silver");

const baseUrl = 'data/';
const dcClass = ".dataConvert";

const eth = 'Coinbase_ETHUSD_2019.csv';
const btc = 'Coinbase_BTCUSD_2019.csv';
const ltc = 'Coinbase_LTCUSD_2019.csv';
const coinArr = [btc, eth, ltc];

for (let i = 0; i < coinArr.length; i++) {
 
  const dc = 'dataConvert'; 
  document.getElementById(dc + i).innerHTML = `  
  <h4>${(i===0)? 'Bitcoin': (i===1)?'Ethereum':'Litecoin'} Daily Prices</h4>
  <div class="${dc + i}">
  </div>  
  `; 

    function render(data){
      d3.select(dcClass+i)
        .append("pre")
        .text(JSON.stringify(data, null, 2) + ',');
    }
    function type(d){
      d.Date = +d.Date;
      d.Symbol  = +d.Symbol;
      d.Open = +d.Open;
      d.Close  = +d.Close;
      d.High  = +d.High;
      d.Low  = +d.Low;
      return d;
    }
    d3.csv(`${baseUrl}${coinArr[i]}`, type, render); 
   }
      /*
function csv<object, string>(url: string, init: RequestInit, row: (rawRow: d3.DSVRowString<string>, index: number, columns: string[]) => object): Promise<d3.DSVParsedArray<object>> (+2 overloads)
Fetches the CSV file at the specified input URL and returns a promise of an array of objects representing the parsed rows.
The init object is passed along to the underlying call to fetch.
The specified row conversion function is used to map and filter row objects to a more-specific representation; see dsv.csvParse for details.
The first generic parameter describes the type of the object representation of a parsed row. 
The second generic paremeter describes the column names as union of string literal types
*/