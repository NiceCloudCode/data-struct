package com.nice.data.test

/**
 * 第四范式先知系统中算子是核心概念，算子代表了一种计算，类似于数据意义上的函数 y = f(x) 中的 f，而真实使用时往往需要将多个算子能力组织在一起形成一个工作流。 在 SDK 的设计中需要允许用户使用自由的 Java 函数构虚拟工作流并支持导出成良好定义的 JSON 结构，以下是大幅简化版本示例最终的效果(示例使用 Python 输出，Java 类似):
 *
 * >>> func_a = Operator(name='A')
 * >>> func_b = Operator(name='B')
 * >>> data = Data(url='hdfs://abc.txt')
 * >>> data_a = func_a(data)
 * >>> data_b = func_b(data_a)
 * >>> print(data_b.to_workflow())
 * ... {
 * ...    'nodes': [{'name': 'hdfs://abc.txt'， 'type': 'data', 'id': '1'}, {'name': 'A'， 'type': 'operator', 'id': '2'}, {'name': 'B'， 'type': 'operator', 'id': '3'}],
 * ...    'edges': [{'src_node': '1', 'dest_node': 2}, {'src_node': '2', 'dest_node': 3}]
 * ... }
 * 请自行补充其中的类定义，实现简化版本语义，在此基础上可进一步考虑多输入、多输出等，要求可直接运行，代码结构简洁，不使用高级语言特性
 */
class mytest {

}
