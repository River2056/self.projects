var circle = {
  x: 0,
  y: 250,
  w: 70,
  h: 70
}

//Speed control
var xSpeed = 5;
var ySpeed = 5;

function setup() {
  createCanvas(800, 600);

}

function draw() {

  background(249, 243, 64);

  ellipse(circle.x, circle.y, circle.w, circle.h);
  fill(255, 130, 250);

  //check to see if ball hit the edge
  if (circle.y > height && circle.x < width) {
    ySpeed *= -1;
  } else if (circle.x > width && circle.y < height) {
    xSpeed *= -1;
  } else if (circle.y < 0 && circle.x > 0) {
    ySpeed *= -1;
  } else if (circle.x < 0 && circle.y < height) {
    xSpeed *= -1
  } else if ((circle.x == 0 || circle.y == 0) || (circle.x == width || circle.y == height)) {
    xSpeed *= -1;
    xSpeed *= -1;
  }
  circle.x += xSpeed;
  circle.y += ySpeed;
}