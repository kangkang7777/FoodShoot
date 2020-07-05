// pages/topic-detail/index.js

const app = getApp()
var WxParse = require('../../wxParse/wxParse.js');
Page({

  /**
   * 页面的初始数据
   */
  data: {
    topic: {},
    isLike: false,
    isFollow: false,
    liked: false
  },

  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function (options) {
    var id = options.id;
    this.setData({
      id: id
    })
    this.getDetail(options.id)
    this.getCommentList();
    this.isLike(id);
  },

  isLike: function(id){
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/topic/isLike',
      data: {
        id: id,
        token: app.globalData.token
      },
      success: function (res) {
        if(res.data.code == 0){
          that.setData({
            liked: true
          });
        }
        
      }
    })
  },

  getDetail: function(id){
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/topic/detail',
      data: {
        id: id,
        token: app.globalData.token
      },
      success: function (res) {
        that.setData({
          topic: res.data.topic
        });
        var topic = res.data.topic

        // 判断原来是否收藏
        wx.getStorage({
          key: 'favorite',
          success: function (res) {
            var favorite = res.data
            console.log(favorite);
            for (var i = 0; i < favorite.length; i++) {
              if (favorite[i].id == topic.id) {
                that.setData({
                  isLike: true
                })
                return;
              }
            }
          },
          fail: function (res) {
            
          }
        })

        wx.getStorage({
          key: 'follow',
          success: function (res) {
            var favorite = res.data
            console.log(favorite);
            for (var i = 0; i < favorite.length; i++) {
              if (favorite[i].id == topic.user.id) {
                that.setData({
                  isFollow: true
                })
                return;
              }
            }
          },
          fail: function (res) {

          }
        })
      }
    })
  },

  follow: function () {
    var that = this
    // 判断原来是否收藏，是则删除，否则添加
    wx.getStorage({
      key: 'follow',
      success: function (res) {
        var favorite = res.data
        if (that.data.isFollow) {
          // 删除
          for (var i = 0; i < favorite.length; i++) {
            if (favorite[i].id == that.data.topic.user.id) {
              favorite.splice(i, 1)
              that.setData({
                isFollow: false
              })
            }
          }
          wx.setStorage({
            key: 'follow',
            data: favorite,
            success: function (res) {
              console.log(res)
              console.log('----设置成功----')
            }
          })
        } else {
          // 添加
          favorite.push(that.data.topic.user)
          wx.setStorage({
            key: 'follow',
            data: favorite,
            success: function (res) {
              that.setData({
                isFollow: true
              })
            }
          })
        }
      },
      fail: function (res) {
        // 添加
        var favorite = [];
        favorite.push(that.data.topic.user)
        wx.setStorage({
          key: 'follow',
          data: favorite,
          success: function (res) {
            that.setData({
              isFollow: true
            })
          }
        })
      }
    })
  },

  like: function () {
    var that = this
    // 判断原来是否收藏，是则删除，否则添加
    wx.getStorage({
      key: 'favorite',
      success: function (res) {
        var favorite = res.data
        if (that.data.isLike) {
          // 删除
          for (var i = 0; i < favorite.length; i++) {
            if (favorite[i].id == that.data.topic.id) {
              favorite.splice(i, 1)
              that.setData({
                isLike: false
              })
            }
          }
          wx.setStorage({
            key: 'favorite',
            data: favorite,
            success: function (res) {
              console.log(res)
              console.log('----设置成功----')
            }
          })
        } else {
          // 添加
          favorite.push(that.data.topic)
          wx.setStorage({
            key: 'favorite',
            data: favorite,
            success: function (res) {
              that.setData({
                isLike: true
              })
            }
          })
        }
      },
      fail: function (res) {
        // 添加
        var favorite = [];
        favorite.push(that.data.topic)
        wx.setStorage({
          key: 'favorite',
          data: favorite,
          success: function (res) {
            that.setData({
              isLike: true
            })
          }
        })
      }
    })
  },

  comment: function(e){
    var id = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: '/pages/comment/index?id='+id,
    })
  },

  commentList: function (e) {
    var id = e.currentTarget.dataset.id;
    wx.navigateTo({
      url: '/pages/comment-list/index?id=' + id,
    })
  },

  getCommentList: function () {
    var that = this;
    wx.request({
      url: app.globalData.domain + '/api/reply/list',
      data: {
        topicId: that.data.id
      },
      success: function (res) {
        that.setData({
          replyList: res.data.replyList
        })
      }
    })
  },

  liked: function(e){
    var topic = this.data.topic;
    var that = this;
    var id = e.currentTarget.dataset.id;
    wx.showLoading();
    wx.request({
      url: app.globalData.domain + '/api/topic/like',
      data: {
        topicId: id,
        token: app.globalData.token
      },
      success: function (res) {
        if(res.data.code == 0){
          that.setData({
            liked: true
          })
        }
      },
      complete: function(res){
        wx.hideLoading();
      }
    })
  },

  unliked: function (e) {
    var topic = this.data.topic;
    var that = this;
    var id = e.currentTarget.dataset.id;
    wx.showLoading();
    wx.request({
      url: app.globalData.domain + '/api/topic/unlike',
      data: {
        topicId: id,
        token: app.globalData.token
      },
      success: function (res) {
        if (res.data.code == 0) {
          that.setData({
            liked: false
          })
        }
      },
      complete: function (res) {
        wx.hideLoading();
      }
    })
  },

  share: function(){

  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function () {
  
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function () {
    
  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function () {
  
  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function () {
  
  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function () {
  
  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function () {
  
  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function () {
    var path = '/pages/topic-detail/index?id=' + this.data.topic.id;
    return {
      title: this.data.topic.title,
      path: path,
      success: function (res) {
        // 转发成功
      },
      fail: function (res) {
        // 转发失败
      }
    }
  }
})