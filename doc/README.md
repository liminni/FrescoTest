###说明
 本Demo中 主要是依据Fresco来写的Demo，主要描述了fresco怎么用，在listview和RecylerView中怎么用
 此外，中间还乱入了一部分【时间选择器】，【条件选择器】，【相册】,【okHttp断点下载】的使用
 除此之外使用了V7包的Toolbar  还有design包下的TabLayout

 问题说明，这个demo是参考github上面：https://github.com/kaedea/fresco-sample-usage 晓枫大大的demo写的，
 在第二个模块中的photoView 和缩放图以及动图的展示都是参考[晓枫大大]的demo写的，具体实现还没有完全的弄清楚


 最需要说明的一点：Fresco在使用的时候一定要初始化，建议在App启动就初始化，
 所以建议写在Application#onCreate()中，记得在manifest.xml注册Application。
