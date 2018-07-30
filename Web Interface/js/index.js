var svgns = "http://www.w3.org/2000/svg";
var svg = document.getElementById("svg");
var path = svg.getElementById("path");
var button_add = document.getElementById("add");
var export_text = document.getElementById("export-text");
var node_connectors = svg.getElementById("node-connectors");
var nodeCount = 0;
var nodes = [];
nodes.push(makeNode(), makeNode(), makeNode(), makeNode());
button_add.addEventListener("click", function(e) {
  nodes.push(makeNode(), makeNode());
});

function makeNode() {
  var node = document.createElementNS(svgns, "circle");
  node.classList.add("node");
  svg.appendChild(node);
  makeDraggable(node);
  return node;
}

function drawCurve() {
  var points = [];
  for (var elem of nodes) {
    var css = window.getComputedStyle(elem);
    points.push([
      parseFloat(css.getPropertyValue("cx"), 10),
      parseFloat(css.getPropertyValue("cy"), 10)
    ]);
  }
  export_text.innerText = "";
  for (var p of points) {
    export_text.innerText += `new Point(${p.toString(",")}),`;
  }
  export_text.innerText = export_text.innerText.slice(0,-1);//remove last comma
  node_connectors.innerHTML = "";
  for (var i = 0; i + 1 < points.length; i += 2) {
    var line = document.createElementNS(svgns, "line");
    line.classList.add("node-connector");
    line.setAttribute("x1", points[i][0]);
    line.setAttribute("y1", points[i][1]);
    line.setAttribute("x2", points[i + 1][0]);
    line.setAttribute("y2", points[i + 1][1]);
    node_connectors.appendChild(line);
  }
  var d = "".concat(
    "M",
    points.shift().join(" "),
    " C ",
    points.shift().join(" "),
    ",",
    points.shift().join(" "),
    ",",
    points.shift().join(" ")
  ); //initial 4 points
  while (points.length >= 2) {
    d += "".concat(
      "S",
      points.shift().join(" "),
      ",",
      points.shift().join(" ")
    );
  }
  path.setAttribute("d", d);
}

svg.addEventListener("mousemove", drag);
document.addEventListener("mouseup", dragEnd);
document.addEventListener("mouseleave", dragEnd);
function makeDraggable(elem) {
  elem.setAttribute("data-dragging", "false");
  elem.addEventListener("mousedown", dragStart);
}
function dragStart(e) {
  var elem = e.srcElement;
  elem.setAttribute("data-dragging", true);
}
function drag(e) {
  var CTM = svg.getScreenCTM();
  for (var elem of nodes) {
    if (elem.getAttribute("data-dragging", false) == "true") {
      elem.style.cx = (e.clientX - CTM.e) / CTM.a; //http://www.petercollingridge.co.uk/tutorials/svg/interactive/dragging/
      elem.style.cy = (e.clientY - CTM.f) / CTM.d;
      drawCurve();
    }
  }
}
function dragEnd(e) {
  for (elem of nodes) {
    elem.setAttribute("data-dragging", false);
  }
}