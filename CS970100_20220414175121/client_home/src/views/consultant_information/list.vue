<template>
	<div class="diy_list page_consultant_information" id="consultant_information_list">
		<div class="warp">
			<div class="container diy_list_container">
				<div class="diy_list_title">
					<div class="col">
						<span class="title">咨询师信息列表</span>
					</div>
				</div>
				<div class="row diy_list_search">
					<div class="col">
						<!-- 搜索栏 -->
						<div class="view">							
							<span class="diy_list_search_title">关键字搜索：</span>
							<b-form-input size="sm" class="mr-sm-2" placeholder="咨询师姓名搜索" v-model="query['consultant_name']" />
							<b-form-input size="sm" class="mr-sm-2" placeholder="咨询方向搜索" v-model="query['consulting_direction']" />
							<b-button size="sm" @click="search()" >
								<b-icon icon="search"/>
							</b-button>
						</div>
						<!-- /搜索栏 -->
					</div>
				</div>
				<div class="diy_list_select_box">
					<span class="diy_list_select_title">下拉搜索：</span>
						<div class="diy_list_dropdown_box">
						<div class="col">
							<!-- 筛选 -->
							<div class="view">
								<b-dropdown text="咨询方向" variant="outline-dark" left>
									<b-dropdown-item @click="filter_set('全部','consulting_direction')">全部</b-dropdown-item>
										<b-dropdown-item v-for="(o, i) in list_consulting_direction" :key="i" @click="filter_set(o['consulting_direction'],'consulting_direction')" >
												{{ o['consulting_direction'] }}
										</b-dropdown-item>
								</b-dropdown>
							</div>
							<!-- /筛选 -->
						</div>
					</div>
					<div class="diy_list_sort_box">
						<div class="col">
							<!-- 排序 -->
							<div class="view">
								<b-dropdown text="排序" variant="outline-dark" left>
										<b-dropdown-item v-for="(o, i) in list_sort" :key="i" @click="set_sort(o)" >
												{{ o.name }}
										</b-dropdown-item>
								</b-dropdown>
							</div>
							<!--/排序 -->
						</div>
					</div>
				</div>
				<div class="row diy_list_box">
					<div class="col">
						<!-- 列表 -->
						<list_consultant_information :list="list" />
						<!-- /列表 -->
					</div>
				</div>
				<div class="row diy_list_page_box">
					<div class="col overflow-auto flex_cc">
						<!-- 分页器 -->
<!--						<diy_pager v-model="query['page']" :size="query['size']" :count="count" v-on:toPage="toPage" v-on:toSize="toSize" ></diy_pager>-->
            <b-pagination
                v-model="query.page"
                :total-rows="count"
                :per-page="query.size"
                @change="goToPage"
            />
						<!-- /分页器 -->
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import list_consultant_information from "@/components/diy/list_consultant_information.vue";
	import diy_pager from "@/components/diy/diy_pager";
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		components: {
			diy_pager,
			list_consultant_information
		},
		data() {
			return {
				url_get_list: "~/api/consultant_information/get_list?like=0",

				// 查询条件
				query: {
					keyword: "",
					page: 1,
					size: 10,
					"consultant_name": "", // 咨询师姓名
					"consulting_direction": "", // 咨询方向
				},

				// 排序内容
				list_sort: [{
						name: "创建时间从高到低",
						value: "`create_time` desc",
					},
					{
						name: "创建时间从低到高",
						value: "`create_time` asc",
					},
					{
						name: "更新时间从高到低",
						value: "`update_time` desc",
					},
					{
						name: "更新时间从低到高",
						value: "`update_time` asc",
					},
					{
						name: "咨询师姓名正序",
						value: "`consultant_name` asc",
					},
					{
						name: "咨询师姓名倒序",
						value: "`consultant_name` desc",
					},
					{
						name: "咨询方向正序",
						value: "`consulting_direction` asc",
					},
					{
						name: "咨询方向倒序",
						value: "`consulting_direction` desc",
					},
				],
				// 咨询方向列表
				"list_consulting_direction": [],
			}
		},
		methods: {
      get_list_before(param) {
      },
			/**
			 * 筛选选择
			 */
			filter_set(o,key) {
			    if (o == "全部") {
			        this.query[key] = "";
			    } else {
			        this.query[key] = o;
			    }
			    this.search();
			},

			/**
			 * 排序
			 */
			set_sort(o) {
			    this.query.orderby = o.value;
			    this.search();
			},
			/**
			 * 获取咨询方向列表
			 */
			async get_list_consulting_direction() {
				var json = await this.$get("~/api/consulting_direction/get_list?");
				if (json.result) {
					this.list_consulting_direction = json.result.list;
				} else if (json.error) {
					console.log(json.error);
				}
			},

			/**
			 * 筛选
			 */
			filter_consulting_direction(o) {
				if (o == "全部") {
					this.query["consulting_direction"] = "";
				} else {
					this.query["consulting_direction"] = o;
				}
				this.search();
			},

			/**
			 * 重置
			 */
			reset() {
				this.query.consultant_name = ""
				this.query.consulting_direction = ""
				this.search();
			},

			// 返回条数
			toSize(i){
				this.query.size = i;
				this.first();
			},

			// 返回页数
			toPage(i){
				this.query.page = i;
				this.first();
			},

      goToPage(v){
        this.query.page = v;
        this.goToNew(v)
      },
		},
		computed: {
		},
		created() {
			/**
			 * 获取咨询方向列表
			 */
			this.get_list_consulting_direction();
		}
	}
</script>

<style>
</style>
