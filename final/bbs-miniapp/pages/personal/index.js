const app = getApp()

Page({
  data: {
    balance: 0,
    freeze: 0,
    score: 0,
    score_sign_continuous: 0
  },
  onLoad() {

  },
  onShow() {
    if(!app.globalData.token){
      wx.navigateTo({
        url: '/pages/auth/index',
      })
      return;
    }
    this.setData({
      userInfo: app.globalData.userInfo
    })
    //this.getBalance();
  },

  getBalance: function () {
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/wechat/user/getBalance',
      header: {
        token: app.globalData.token
      },
      success: (res) => {
        if (res.data.code == 0) {
          that.setData({
            balance: res.data.balance
          })
        }
      }
    })
  },
  
})