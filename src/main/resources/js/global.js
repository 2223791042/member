// 后端根目录，发起后台请求时引入本js文件，然后使用里面的footPath根目录变量
var rootPath = 'http://domla.xyz:8080/member'

// 点击侧边栏切换页面，跳转方法
// var page = rootPath + "/schedule-list.html";
var page = rootPath + '../views/schedule-list.html'
function navigate(page) {
    $('#content').attr(page)
}
