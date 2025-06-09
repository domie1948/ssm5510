<template>
  <div class="page_search">
	<div class="warp">
	  <div class="container">
		<div class="row">
		  <div class="col-12">
			<div class="card_result_search">
			  <div class="title">搜索结果</div>
				<!-- 文章搜索结果 -->
			  <list_result_search
				:list="result_article"
				title="心理资讯"
				source_table="article"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/ordinary_users/list', 'get')"
				:list="result_ordinary_users_user_name"
				title="普通用户用户姓名"
				source_table="ordinary_users"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/ordinary_users/list', 'get')"
				:list="result_ordinary_users_user_gender"
				title="普通用户用户性别"
				source_table="ordinary_users"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/consultant/list', 'get')"
				:list="result_consultant_consultant_name"
				title="咨询师咨询师姓名"
				source_table="consultant"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/consultant/list', 'get')"
				:list="result_consultant_consultant_gender"
				title="咨询师咨询师性别"
				source_table="consultant"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/consultant_information/list', 'get')"
				:list="result_consultant_information_consultant_name"
				title="咨询师信息咨询师姓名"
				source_table="consultant_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/consultant_information/list', 'get')"
				:list="result_consultant_information_consulting_direction"
				title="咨询师信息咨询方向"
				source_table="consultant_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/reservation_information/list', 'get')"
				:list="result_reservation_information_consultant_name"
				title="预约信息咨询师姓名"
				source_table="reservation_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/reservation_information/list', 'get')"
				:list="result_reservation_information_time_of_appointment"
				title="预约信息预约时间"
				source_table="reservation_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/consulting_information/list', 'get')"
				:list="result_consulting_information_consultant_name"
				title="咨询信息咨询师姓名"
				source_table="consulting_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/consulting_information/list', 'get')"
				:list="result_consulting_information_reply_status"
				title="咨询信息回复状态"
				source_table="consulting_information"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/decompression_base_camp/list', 'get')"
				:list="result_decompression_base_camp_decompression_title"
				title="减压大本营减压标题"
				source_table="decompression_base_camp"
			  ></list_result_search>
			  <list_result_search
				v-if="$check_action('/consulting_direction/list', 'get')"
				:list="result_consulting_direction_consulting_direction"
				title="咨询方向咨询方向"
				source_table="consulting_direction"
			  ></list_result_search>
			</div>
		  </div>
		</div>
	  </div>
	</div>
  </div>
</template>

<script>
import mixin from "../../mixins/page.js";
import list_result_search from "../../components/diy/list_result_search.vue";

export default {
  mixins: [mixin],
  data() {
	return {
	  "query": {
		word: "",
	  },
	  "result_article": [],
			"result_ordinary_users_user_name":[],
			"result_ordinary_users_user_gender":[],
			"result_consultant_consultant_name":[],
			"result_consultant_consultant_gender":[],
			"result_consultant_information_consultant_name":[],
			"result_consultant_information_consulting_direction":[],
			"result_reservation_information_consultant_name":[],
			"result_reservation_information_time_of_appointment":[],
			"result_consulting_information_consultant_name":[],
			"result_consulting_information_reply_status":[],
			"result_decompression_base_camp_decompression_title":[],
			"result_consulting_direction_consulting_direction":[],
	};
  },
  methods: {
	/**
	 * 获取文章
	 */
	get_article() {
	  this.$get("~/api/article/get_list?like=0", { page: 1, size: 10, title: this.query.word }, (json) => {
		if (json.result) {
		  this.result_article = json.result.list;
		}
	  });
	},
	/**
	 * 获取user_name
	 */
	get_ordinary_users_user_name(){
		this.$get("~/api/ordinary_users/get_list?like=0", { page: 1, size: 10, "user_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_ordinary_users_user_name = json.result.list;
			result_ordinary_users_user_name.map(o => o.title = o['user_name'])
	  			this.result_ordinary_users_user_name = result_ordinary_users_user_name
		 	}
		});
	},
	/**
	 * 获取user_gender
	 */
	get_ordinary_users_user_gender(){
		this.$get("~/api/ordinary_users/get_list?like=0", { page: 1, size: 10, "user_gender": this.query.word }, (json) => {
		  if (json.result) {
			var result_ordinary_users_user_gender = json.result.list;
			result_ordinary_users_user_gender.map(o => o.title = o['user_gender'])
	  			this.result_ordinary_users_user_gender = result_ordinary_users_user_gender
		 	}
		});
	},
	/**
	 * 获取consultant_name
	 */
	get_consultant_consultant_name(){
		this.$get("~/api/consultant/get_list?like=0", { page: 1, size: 10, "consultant_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_consultant_consultant_name = json.result.list;
			result_consultant_consultant_name.map(o => o.title = o['consultant_name'])
	  			this.result_consultant_consultant_name = result_consultant_consultant_name
		 	}
		});
	},
	/**
	 * 获取consultant_gender
	 */
	get_consultant_consultant_gender(){
		this.$get("~/api/consultant/get_list?like=0", { page: 1, size: 10, "consultant_gender": this.query.word }, (json) => {
		  if (json.result) {
			var result_consultant_consultant_gender = json.result.list;
			result_consultant_consultant_gender.map(o => o.title = o['consultant_gender'])
	  			this.result_consultant_consultant_gender = result_consultant_consultant_gender
		 	}
		});
	},
	/**
	 * 获取consultant_name
	 */
	get_consultant_information_consultant_name(){
		this.$get("~/api/consultant_information/get_list?like=0", { page: 1, size: 10, "consultant_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_consultant_information_consultant_name = json.result.list;
			result_consultant_information_consultant_name.map(o => o.title = o['consultant_name'])
	  			this.result_consultant_information_consultant_name = result_consultant_information_consultant_name
		 	}
		});
	},
	/**
	 * 获取consulting_direction
	 */
	get_consultant_information_consulting_direction(){
		this.$get("~/api/consultant_information/get_list?like=0", { page: 1, size: 10, "consulting_direction": this.query.word }, (json) => {
		  if (json.result) {
			var result_consultant_information_consulting_direction = json.result.list;
			result_consultant_information_consulting_direction.map(o => o.title = o['consulting_direction'])
	  			this.result_consultant_information_consulting_direction = result_consultant_information_consulting_direction
		 	}
		});
	},
	/**
	 * 获取consultant_name
	 */
	get_reservation_information_consultant_name(){
		this.$get("~/api/reservation_information/get_list?like=0", { page: 1, size: 10, "consultant_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_reservation_information_consultant_name = json.result.list;
			result_reservation_information_consultant_name.map(o => o.title = o['consultant_name'])
	  			this.result_reservation_information_consultant_name = result_reservation_information_consultant_name
		 	}
		});
	},
	/**
	 * 获取time_of_appointment
	 */
	get_reservation_information_time_of_appointment(){
		this.$get("~/api/reservation_information/get_list?like=0", { page: 1, size: 10, "time_of_appointment": this.query.word }, (json) => {
		  if (json.result) {
			var result_reservation_information_time_of_appointment = json.result.list;
			result_reservation_information_time_of_appointment.map(o => o.title = o['time_of_appointment'])
	  			this.result_reservation_information_time_of_appointment = result_reservation_information_time_of_appointment
		 	}
		});
	},
	/**
	 * 获取consultant_name
	 */
	get_consulting_information_consultant_name(){
		this.$get("~/api/consulting_information/get_list?like=0", { page: 1, size: 10, "consultant_name": this.query.word }, (json) => {
		  if (json.result) {
			var result_consulting_information_consultant_name = json.result.list;
			result_consulting_information_consultant_name.map(o => o.title = o['consultant_name'])
	  			this.result_consulting_information_consultant_name = result_consulting_information_consultant_name
		 	}
		});
	},
	/**
	 * 获取reply_status
	 */
	get_consulting_information_reply_status(){
		this.$get("~/api/consulting_information/get_list?like=0", { page: 1, size: 10, "reply_status": this.query.word }, (json) => {
		  if (json.result) {
			var result_consulting_information_reply_status = json.result.list;
			result_consulting_information_reply_status.map(o => o.title = o['reply_status'])
	  			this.result_consulting_information_reply_status = result_consulting_information_reply_status
		 	}
		});
	},
	/**
	 * 获取decompression_title
	 */
	get_decompression_base_camp_decompression_title(){
		this.$get("~/api/decompression_base_camp/get_list?like=0", { page: 1, size: 10, "decompression_title": this.query.word }, (json) => {
		  if (json.result) {
			var result_decompression_base_camp_decompression_title = json.result.list;
			result_decompression_base_camp_decompression_title.map(o => o.title = o['decompression_title'])
	  			this.result_decompression_base_camp_decompression_title = result_decompression_base_camp_decompression_title
		 	}
		});
	},
	/**
	 * 获取consulting_direction
	 */
	get_consulting_direction_consulting_direction(){
		this.$get("~/api/consulting_direction/get_list?like=0", { page: 1, size: 10, "consulting_direction": this.query.word }, (json) => {
		  if (json.result) {
			var result_consulting_direction_consulting_direction = json.result.list;
			result_consulting_direction_consulting_direction.map(o => o.title = o['consulting_direction'])
	  			this.result_consulting_direction_consulting_direction = result_consulting_direction_consulting_direction
		 	}
		});
	},

  },
  components: { list_result_search },
	created(){
    this.query.word = this.$route.query.word || "";
  },
  mounted() {
	this.get_article();
		this.get_ordinary_users_user_name();
		this.get_ordinary_users_user_gender();
		this.get_consultant_consultant_name();
		this.get_consultant_consultant_gender();
		this.get_consultant_information_consultant_name();
		this.get_consultant_information_consulting_direction();
		this.get_reservation_information_consultant_name();
		this.get_reservation_information_time_of_appointment();
		this.get_consulting_information_consultant_name();
		this.get_consulting_information_reply_status();
		this.get_decompression_base_camp_decompression_title();
		this.get_consulting_direction_consulting_direction();
  },
  watch: {
	$route() {
	  $.push(this.query, this.$route.query);
	  this.get_article();
	  this.get_ordinary_users_user_name();
	  this.get_ordinary_users_user_gender();
	  this.get_consultant_consultant_name();
	  this.get_consultant_consultant_gender();
	  this.get_consultant_information_consultant_name();
	  this.get_consultant_information_consulting_direction();
	  this.get_reservation_information_consultant_name();
	  this.get_reservation_information_time_of_appointment();
	  this.get_consulting_information_consultant_name();
	  this.get_consulting_information_reply_status();
	  this.get_decompression_base_camp_decompression_title();
	  this.get_consulting_direction_consulting_direction();
	},
  },
};
</script>

<style scoped>
.card_search {
  text-align: center;
}
.card_result_search>.title {
  text-align: center;
  padding: 10px 0;
}
</style>
