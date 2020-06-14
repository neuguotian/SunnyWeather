# SunnyWeather

需求分析（做什么）
    可以搜索全球大多数国家的各个城市数据
    可以查看全球绝大多数城市的天气信息
    可以自由切换城市，查看其他城市的天气
    可以手动刷新实时的天气

技术可行性分析（怎么做）
    怎么才能得到全球大多数国家的城市数据
    怎么才能获取每个城市的天气信息
    
    解决方案：调取yuncai App的接口
        1. 申请接口访问权限---令牌
        2. 查看接口返回数据格式和内容

任务分解



---
（前期准备）

创建远程仓库

创建本地项目

git clone

做一次提交，并git push 到github

建包（搭建MVVM项目架构）、加依赖、加图片

---
（开发第一个task：获取城市数据）

定义全局Context

定义数据模 
    PlaceResponse.kt 中定义
        PlaceResponse, Place, Location
        
定义城市数据访问接口, PlaceService

构建Retrofit，（全局构建器）单例类

定义统一的网络数据访问入口，SunnyWeatherNetwork单例类



---