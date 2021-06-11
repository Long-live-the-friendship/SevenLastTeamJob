Page({

  
  data: {
    //定义一个数据，主要是放集合结果的
    students:"",
    all:"",
  },

  onLoad(){ 

    var thisPage = this;
    //累计
    wx.cloud.database().collection('Timi')//我的数据表的名称是student
    .get({   
      success(res){
          console.log(res)          
          thisPage.setData({
            students:res.data,       
          })   
          var a=0          
          for (let index = 0; index < thisPage.data.students.length; index++) {
            //  console.log(thisPage.data.students[index]['time'])
             var a = a + thisPage.data.students[index]['time']

          }
          // console.log(a)
          thisPage.setData({
            all:a,       
          })     
      },
      fail(err){
        console.log(err)
      },
    })

    

    // thisPage.setData({
    //   all:thisPage.data.students,
    // }) 
    // console.log("stu"+this.data.students)
    // console.log("all"+this.data.all)
    



  }
  
})

