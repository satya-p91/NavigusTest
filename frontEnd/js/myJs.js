async function getAllData() {
    url = "http://localhost:8080/api/v1/products";
    console.log("url : "+url)
    let response = await fetch(url, { method: 'GET', mode: 'cors', cache: 'no-cache', credentials: 'same-origin', headers: { 'Content-Type': 'application/x-www-form-urlencoded' } });
    x = await response.json()
    console.log(x)

    var mainContainer = document.getElementById("myData");
    for(var i =0;i< x.length;i++){
        var div =  document.createElement("div");

        div.innerHTML = '<div class="col mt-4"><img src="images/'+x[i].img+'" style="width:100px;height:150px;"/> <div class="col"><b>'+x[i].name +'</b></div> </div> </div> <div class="col col-lg-6">'+x[i].descr +' </div> <div class="w-100"></div>'

        mainContainer.appendChild(div);
    }

    //return x;
}

async function searchData() {

    var str = document.getElementById("searchip");

    url = "http://localhost:8080/api/v1/search?name="+str.value;

    console.log("url : "+url)

    let response = await fetch(url, { method: 'GET', mode: 'cors', cache: 'no-cache', credentials: 'same-origin', headers: { 'Content-Type': 'application/x-www-form-urlencoded' } });
    x = await response.json()
    console.log(x)

    var mainContainer = document.getElementById("myData");
    mainContainer.innerHTML="";  

    var div =  document.createElement("div");
    div.innerHTML = '<div class="col mt-4"><img src="images/'+x.img+'" style="width:100px;height:150px;"/></div> <div class="col"><b>'+x.name +'</b></div> </div> <div class="col col-lg-6">'+x.descr +' </div> <div class="w-100"></div>'

    mainContainer.appendChild(div)
    //return x;
}