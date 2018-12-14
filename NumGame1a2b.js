var input;
var guess = generate();
var answer;
while (true) {
  input = prompt("Please enter your number here: (enter -1 to exit) ", "enter number or -1 to exit");
  answer = check(input, guess);
  if (answer[0] == guess.length) {
    window.alert("Congratulations! You win!");
    break;
  }
  if (input == -1) {
    window.alert("Don't give up yet! See you soon!");
    break;
  } else {
    window.alert(answer[0] + "A" + answer[1] + "B");
  }
}

function generate() {
  var gen = new Array(4).fill(0);
  var rnum;
  var flags = new Array(10).fill(false);

  for (let i = 0; i < gen.length; i++) {
    do {
      rnum = Math.floor(Math.random() * 10); //returns a random interger 0~9
    } while (flags[rnum]);
    gen[i] = rnum;
    flags[rnum] = true;
  }
  return gen;
}

function check(x, y) { //check for value and position
  var chk = [0, 0];
  for (let i = 0; i < x.length; i++) {
    for (let j = 0; j < y.length; j++) {
      if (x[i] == y[j]) {
        if (i == j) {
          chk[0]++;
        } else {
          chk[1]++;
        }
        break;
      }
    }
  }
  return chk;
}