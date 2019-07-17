function changeImages() {
    var x = document.getElementById("img2");
    var y = document.getElementById("img3");
    var z = document.getElementById("img4");

    x.setAttribute("src", "pic5.jpeg");
    y.setAttribute("src", "pic6.jpeg");
    z.setAttribute("src", "pic7.jpg");

    loadImages();
}

function backToDefault() {
    var x = document.getElementById("img2");
    var y = document.getElementById("img3");
    var z = document.getElementById("img4");

    x.setAttribute("src", "pic2.jpg");
    y.setAttribute("src", "pic3.jpeg");
    z.setAttribute("src", "pic4.jpeg");

    removeImages();
}

function loadImages() {
 var div11 = document.getElementById("placehere");
    for (var i = 8; i < 11; i++) {
        var img = document.createElement("img");
        img.src = "pic" + i + ".jpeg";
        img.id = "img" + i + "";
        img.width = 300;
        img.height = 200;
        img.alt = "pic" + i + "";
        div11.appendChild(img);
    }
}

function removeImages() {
    var div11 = document.getElementById("placehere");
    for (var i = 8; i < 11; i++) {
        var oldImages = "img" + i + "";
        div11.removeChild(document.getElementById(oldImages));
    }
}
