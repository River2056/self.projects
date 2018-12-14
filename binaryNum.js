var input = prompt("Please enter a number: ");
var x = input;
var arr = [];
var array = [];
var i = 0;

do {
    arr[i] = x % 2;
    i++;
    x = Math.trunc(x / 2);
} while (x != 0);

for(let i = arr.length-1, j = 0 ; i >= 0, j < arr.length ; i--, j++){
    array[j] = arr[i];
}

console.log(array);
document.write("Binary number is: " + array);