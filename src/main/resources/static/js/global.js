// 后端根目录，发起后台请求时引入本js文件，然后使用里面的footPath根目录变量
// var rootPath = 'http://domla.xyz:8080/member' //服务器地址
// var rootPath = 'http://10.33.9.157:8080/member' //飞儿测试地址
var rootPath = 'http://localhost:8080/member' //测试使用

// 点击侧边栏切换页面，跳转方法
// var page = rootPath + "/schedule-list.html";
var page = rootPath + '../views/schedule-list.html'
function navigate(page) {
    $('#content').attr(page)
}

// 使用bootstrap重写系统alert
/**
 * title string 对话框标题
 * msg string 消息内容
 * callback function 返回函数。
 **/
// window.alert = function(title, msg, callback) {
//     if (!title) {
//         title = '对话框'
//     }
//     var dialogHTML = '<div id="selfAlert" class="modal fade">'
//     dialogHTML += '<div class="modal-dialog">'
//     dialogHTML += '<div class="modal-content">'
//     dialogHTML += '<div class="modal-header">'
//     dialogHTML +=
//         '<button type="button" class="close" data-dismiss="modal" aria-label="Close">'
//     dialogHTML += '<span aria-hidden="true">&times;</span>'
//     dialogHTML += '</button>'
//     dialogHTML += '<h4 class="modal-title">系统提示</h4>'
//     dialogHTML += '</div>'
//     dialogHTML += '<div class="modal-body">'
//     dialogHTML += title
//     dialogHTML += '</div>'
//     dialogHTML += '<div class="modal-footer">'
//     dialogHTML +=
//         '<button type="button" class="btn btn-primary" data-dismiss="modal">确定</button>'
//     dialogHTML += '</div>'
//     dialogHTML += '</div>'
//     dialogHTML += '</div>'
//     dialogHTML += '</div>'

//     if ($('#selfAlert').length <= 0) {
//         $('body').append(dialogHTML)
//     }

//     $('#selfAlert')
//         .on('hidden.bs.modal', function() {
//             $('#selfAlert').remove()
//             if (typeof callback == 'function') {
//                 callback()
//             }
//         })
//         .modal('show')
// }

// if ($('#selfAlert').length <= 0) {
//     $('body').append(dialogHTML)
// }

// $('#selfAlert')
//     .on('hidden.bs.modal', function() {
//         $('#selfAlert').remove()
//         if (typeof callback == 'function') {
//             callback()
//         }
//     })
//     .modal('show')
