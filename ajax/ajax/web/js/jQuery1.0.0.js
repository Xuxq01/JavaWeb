function jQuery(selector){
    if (typeof selector == "string") {

        if (selector.charAt(0) == "#") {
            domObj = document.getElementById(selector.substring(1))
            return new jQuery()
        }
    }
    if (typeof selector == "function") {
        window.onload = selector
    }
    this.html = function (htmlStr){
        domObj.innerHTML = htmlStr
    }
    this.click = function (fun){
        domObj.onclick = fun
    }
    this.val = function (v){
        if(v == undefined){
            return domObj.value
        }else{
            domObj.value = v
        }
    }
    this.change = function (fun){
        domObj.onchange = fun
    }

    //静态的方法,发送ajax请求
    jQuery.ajax = function (jsonArgs){
        var xhr = new XMLHttpRequest()
        xhr.onreadystatechange = function (){
            if(xhr.readyState == 4){
                if(this.status == 200){
                    var jsonObj = JSON.parse(this.responseText)
                    //调用函数
                    jsonArgs.success(jsonObj)
                }
            }
        }
        if (jsonArgs.type.toUpperCase() == "POST") {
            xhr.open("POST",jsonArgs.url,jsonArgs.async)
            xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded")
            var username = document.getElementById("username").value
            xhr.send(jsonArgs.data)
        }

        if (jsonArgs.type.toUpperCase() == "GET") {
            xhr.open("GET",jsonArgs.url + "?" + jsonArgs.data,jsonArgs.async)
            xhr.send()
        }

    }
}

$ = jQuery
new jQuery()