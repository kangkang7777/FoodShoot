var commonCityData = require('../../utils/city.js')
//获取应用实例
var app = getApp()
Page({
  data: {
    userInfo: {}
  },

  bindCancel: function () {
    wx.navigateBack({})
  },

  onLoad: function () {
    this.getUserInfo();
  },

  bindSave: function (e) {
    var that = this;
    var realName = e.detail.value.realName;
    var mobile = e.detail.value.mobile;
    var schoolName = e.detail.value.schoolName;
    var userNo = e.detail.value.userNo;
    if (realName == "") {
      wx.showModal({
        title: '提示',
        content: '请填写姓名',
        showCancel: false
      })
      return
    }
    if (mobile == "") {
      wx.showModal({
        title: '提示',
        content: '请填写手机号码',
        showCancel: false
      })
      return
    }

    wx.request({
      url: app.globalData.domain + '/api/user/update',
      method: "POST",
      header: {
        "token": app.globalData.token
      },
      data: {
        realName: realName,
        mobile: mobile,
        schoolName: schoolName,
        userNo: userNo,
        id: that.data.userInfo.id
      },
      success: function (res) {
        if (res.data.code != 0) {
          // 登录错误 
          wx.hideLoading();
          wx.showModal({
            title: '失败',
            content: res.data.msg,
            showCancel: false
          })
          return;
        }
        // 跳转到结算页面
        wx.showToast({
          title: '修改成功',
        })
        app.globalData.userInfo.realName = realName;
        app.globalData.userInfo.mobile = mobile;
        wx.navigateBack({})
      }
    })
  },

  getUserInfo: function () {
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/user/info',
      data: {
        token: app.globalData.token
      },
      success: function (res) {
        that.setData({
          userInfo: res.data.user
        })
      }
    })
  }


})