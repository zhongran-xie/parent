var indexdata = 
[
    { text: "会员中心",isexpand:false, children: [ 
		{url:"member/deliveryType.jsp",text:"配送方式管理"},
		{url:"member/deliveryAddr.jsp",text:"收货地址管理"},
		{url:"member/store.jsp",text:"店铺管理"},
		{url:"member/market.jsp",text:"市场管理"},
		{url:"member/marketSubarea.jsp",text:"市场分区管理"},
		{url:"member/marketFloor.jsp",text:"市场楼层管理"},
		{url:"member/marketFloorClass.jsp",text:"市场楼层经营分类管理"}
	]},
    { text: "商品中心",isexpand:false, children: [ 
		{url:"product/brand.jsp",text:"品牌管理"},
		{url:"product/category.jsp",text:"类目管理"},
		{url:"product/categoryAttr.jsp",text:"类目属性管理"}     
	]}
	
];


var indexdata2 =
[
    { isexpand: "true", text: "表格", children: [
        { isexpand: "true", text: "可排序", children: [
		    { url: "dotnetdemos/grid/sortable/client.aspx", text: "客户端" },
            { url: "dotnetdemos/grid/sortable/server.aspx", text: "服务器" }
	    ]
        },
        { isexpand: "true", text: "可分页", children: [
		    { url: "dotnetdemos/grid/pager/client.aspx", text: "客户端" },
            { url: "dotnetdemos/grid/pager/server.aspx", text: "服务器" }
	    ]
        },
        { isexpand: "true", text: "树表格", children: [
		    { url: "dotnetdemos/grid/treegrid/tree.aspx", text: "树表格" }, 
		    { url: "dotnetdemos/grid/treegrid/tree2.aspx", text: "树表格2" }
	    ]
        }
    ]
    }
];