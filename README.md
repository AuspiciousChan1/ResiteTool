# ResiteTool
基于android的背诵软件

软件介绍
=======================

新知识
=======================
android:layout_weight
--------------------------
##作用范围
    只在LinearLayout中有效
##权重的意义
    各个组件原有的宽度由 android:layout_width 确定。而android:layout_weight控制的是
整个LinearLayout的宽度减去各个组件原有宽度之和，剩下宽度的比例。所以最终各个组件的宽度
为原有宽度+权重赋予它的宽度。
    例如：两个组件A的宽度是3dip，B的宽度是3dip，其中A的权重为2， B的权重为1，则A的宽度为
1 + [w - (3 + 4)] * [1 / (1 + 2)]
     而如果两个组件A，B宽度都是match_parent，其中A的权重为2， B的权重为1，假定
LinearLayout总宽度为w，则A的宽度为 w + [w - (w + w)] * [2 / (1 + 2)] = 1 / 3 * w，
B的宽度为2 / 3 * w。
    而如果两个组件A，B宽度都是0，其中A的权重为2， B的权重为1，假定LinearLayout总宽度为w，
则A的宽度为 0 + [w - (0 + 0)] * [2 / (1 + 2)] = 2 / 3 * w，
B的宽度为1 / 3 * w。

注： 设置width为wrap_content和0，相同android:layout_weight的效果一样

