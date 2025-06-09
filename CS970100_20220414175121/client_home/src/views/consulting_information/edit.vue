<template>
	<div class="diy_edit page_consulting_information" id="consulting_information_edit">
		<div class='warp'>
			<div class='container'>
				<div class='row diy_edit_content_box'>
					<div v-if="$check_field('set','consultant_name') || $check_field('add','consultant_name') || $check_field('get','consultant_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>咨询师姓名:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_consultant_name" v-model="form['consultant_name']" placeholder="请输入咨询师姓名" v-if="(form['consultant_name'] && $check_field('set','consultant_name')) || (!form['consultant_name'] && $check_field('add','consultant_name'))"  :disabled="disabledObj['consultant_name_isDisabled']"/>
							<span v-else-if="$check_field('get','consultant_name')">{{ form['consultant_name'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','consultant_user') || $check_field('add','consultant_user') || $check_field('get','consultant_user')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>咨询师用户:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_consultant_user" :disabled="disabledObj['consultant_user_isDisabled']" v-model="form['consultant_user']" v-if="(form['consultant_user'] && $check_field('set','consultant_user')) || (!form['consultant_user'] && $check_field('add','consultant_user'))" >
								<option v-for="o in list_user_consultant_user" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','consultant_user')">{{ form['consultant_user'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','consultant_gender') || $check_field('add','consultant_gender') || $check_field('get','consultant_gender')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>咨询师性别:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_consultant_gender" v-model="form['consultant_gender']" placeholder="请输入咨询师性别" v-if="(form['consultant_gender'] && $check_field('set','consultant_gender')) || (!form['consultant_gender'] && $check_field('add','consultant_gender'))"  :disabled="disabledObj['consultant_gender_isDisabled']"/>
							<span v-else-if="$check_field('get','consultant_gender')">{{ form['consultant_name'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','consulting_direction') || $check_field('add','consulting_direction') || $check_field('get','consulting_direction')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>咨询方向:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_consulting_direction" v-model="form['consulting_direction']" placeholder="请输入咨询方向" v-if="(form['consulting_direction'] && $check_field('set','consulting_direction')) || (!form['consulting_direction'] && $check_field('add','consulting_direction'))"  :disabled="disabledObj['consulting_direction_isDisabled']"/>
							<span v-else-if="$check_field('get','consulting_direction')">{{ form['consultant_name'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','reply_status') || $check_field('add','reply_status') || $check_field('get','reply_status')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>回复状态:
							</span>
						</div>
						<!-- 选项 -->
						<div class="diy_field diy_down">
							<select id="form_reply_status" v-model="form['reply_status']" v-if="(form['reply_status'] && $check_field('set','reply_status')) || (!form['reply_status'] && $check_field('add','reply_status'))" >
								<option v-for="o in list_reply_status" :value="o">
									{{o}}
								</option>
							</select>
							<span v-else-if="$check_field('get','reply_status')">{{ form['reply_status'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','user_name') || $check_field('add','user_name') || $check_field('get','user_name')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>用户姓名:
							</span>
						</div>
						<!-- 文本 -->
						<div class="diy_field diy_text">
							<input type="text" id="form_user_name" v-model="form['user_name']" placeholder="请输入用户姓名" v-if="(form['user_name'] && $check_field('set','user_name')) || (!form['user_name'] && $check_field('add','user_name'))"  :disabled="disabledObj['user_name_isDisabled']"/>
							<span v-else-if="$check_field('get','user_name')">{{ form['consultant_name'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','consulting_users') || $check_field('add','consulting_users') || $check_field('get','consulting_users')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>咨询用户:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_consulting_users" :disabled="disabledObj['consulting_users_isDisabled']" v-model="form['consulting_users']" v-if="(form['consulting_users'] && $check_field('set','consulting_users')) || (!form['consulting_users'] && $check_field('add','consulting_users'))" >
								<option v-for="o in list_user_consulting_users" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','consulting_users')">{{ form['consulting_users'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','consultation_content') || $check_field('add','consultation_content') || $check_field('get','consultation_content')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>咨询内容:
							</span>
						</div>
						<!-- 多文本 -->
						<div class="diy_field diy_desc">
							<textarea id="form_consultation_content" v-model="form['consultation_content']" v-if="(form['consultation_content'] && $check_field('set','consultation_content')) || (!form['consultation_content'] && $check_field('add','consultation_content'))" :disabled="disabledObj['consultation_content_isDisabled']" />
							<span v-else-if="$check_field('get','consultation_content')">{{ form['consultant_name'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','consultation_reply') || $check_field('add','consultation_reply') || $check_field('get','consultation_reply')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>咨询回复:
							</span>
						</div>
						<!-- 多文本 -->
						<div class="diy_field diy_desc">
							<textarea id="form_consultation_reply" v-model="form['consultation_reply']" v-if="(form['consultation_reply'] && $check_field('set','consultation_reply')) || (!form['consultation_reply'] && $check_field('add','consultation_reply'))" :disabled="disabledObj['consultation_reply_isDisabled']" />
							<span v-else-if="$check_field('get','consultation_reply')">{{ form['consultant_name'] }}</span>
						</div>
					</div>
				</div>
				<div class="diy_edit_submit_box row">
					<div class="col-12">
						<div class="btn_box">
							<button class="btn_submit" @click="submit()">提交</button>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</template>

<script>
	import mixin from "@/mixins/page.js";
	export default {
		mixins: [mixin],
		components: {},
		data() {
			return {
				url_get_obj: "~/api/consulting_information/get_obj?",
				url_add: "~/api/consulting_information/add?",
				url_set: "~/api/consulting_information/set?",

				// 登录权限
				oauth: {
					"signIn": true,
					"user_group": []
				},

				// 查询条件
				query: {
					"consultant_name": "",
					"consultant_user": 0,
					"consultant_gender": "",
					"consulting_direction": "",
					"reply_status": "",
					"user_name": "",
					"consulting_users": 0,
					"consultation_content": "",
					"consultation_reply": "",
					"consulting_information_id": 0,
				},

				obj: {
					"consultant_name":'', // 咨询师姓名
					"consultant_user": 0, // 咨询师用户
					"consultant_gender":'', // 咨询师性别
					"consulting_direction":'', // 咨询方向
					"reply_status":'', // 回复状态
					"user_name":'', // 用户姓名
					"consulting_users": 0, // 咨询用户
					"consultation_content":'', // 咨询内容
					"consultation_reply":'', // 咨询回复
					"consulting_information_id": 0,
				},

				// 表单字段
				form: {
					"consultant_name":'', // 咨询师姓名
					"consultant_user": 0, // 咨询师用户
					"consultant_gender":'', // 咨询师性别
					"consulting_direction":'', // 咨询方向
					"reply_status":'', // 回复状态
					"user_name":'', // 用户姓名
					"consulting_users": 0, // 咨询用户
					"consultation_content":'', // 咨询内容
					"consultation_reply":'', // 咨询回复
					"consulting_information_id": 0,
				},
				disabledObj:{
					"consultant_name_isDisabled": false,
					"consultant_user_isDisabled": false,
					"consultant_gender_isDisabled": false,
					"consulting_direction_isDisabled": false,
					"reply_status_isDisabled": false,
					"user_name_isDisabled": false,
					"consulting_users_isDisabled": false,
					"consultation_content_isDisabled": false,
					"consultation_reply_isDisabled": false,
				},
				// 用户列表
				list_user_consultant_user: [],
				//回复状态选项列表
				list_reply_status: ['待回复','已回复'],
				// 用户列表
				list_user_consulting_users: [],

				// ID字段
				field: "consulting_information_id",
			}
		},
		methods: {
			/**
			 * 获取咨询师用户列表
			 */
			async get_list_user_consultant_user() {
				// if(this.user_group !== "管理员" && this.form["consultant_user"] === 0) {
				//     this.form["consultant_user"] = this.user.user_id;
				// }
				var json = await this.$get("~/api/user/get_list?user_group=咨询师");
				if(json.result && json.result.list){
					this.list_user_consultant_user = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			/**
			 * 获取普通用户用户列表
			 */
			async get_list_user_consulting_users() {
				// if(this.user_group !== "管理员" && this.form["consulting_users"] === 0) {
				//     this.form["consulting_users"] = this.user.user_id;
				// }
				var json = await this.$get("~/api/user/get_list?user_group=普通用户");
				if(json.result && json.result.list){
					this.list_user_consulting_users = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			async get_user_session_consulting_users(){
				var _this = this;
				var json = await this.$get("~/api/user_group/get_obj?name=普通用户");
				if(json.result && json.result.obj){
					var source_table = json.result.obj.source_table;
					var user_id = _this.$store.state.user.user_id;
					if (user_id){
						var url = "~/api/"+source_table+"/get_obj?"
						this.$get(url, {"user_id":_this.$store.state.user.user_id}, function(res) {
							if (res.result && res.result.obj) {
								var arr = []
								for (let key in res.result.obj) {
									arr.push(key)
								}
								var arrForm = []
								for (let key in _this.form) {
									arrForm.push(key)
								}
								_this.form["consulting_users"] = user_id
								_this.disabledObj['consulting_users' + '_isDisabled'] = true
								for (var i=0;i<arr.length;i++){
									for (var j=0;j<arrForm.length;j++){
										if (arr[i]===arrForm[j]){
											if (arr[i]!=="consulting_users") {
												_this.form[arrForm[j]] = res.result.obj[arr[i]]
												_this.disabledObj[arrForm[j] + '_isDisabled'] = true
												break;
											}
										}
									}
								}
							}
						});
					}
				}
				else if(json.error){
					console.error(json.error);
				}
			},

			/**
			 * 修改文件
			 * @param { Object } files 上传文件对象
			 * @param { String } str 表单的属性名
			 */
			change_file(files, str) {
				var form = new FormData();
				form.append("file", files[0]);
				this.$post("~/api/consulting_information/upload?", form, (res) => {
					if (res.result) {
						this.form[str] = res.result.url;
					} else if (res.error) {
						this.$toast(res.error.message);
					}
				});
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_before(param){
				var form = $.db.get("form");
				if (form) {
					this.obj = $.push(this.obj ,form);
					this.form = $.push(this.form ,form);
				}
				var arr = []
				for (let key in form) {
					arr.push(key)
				}
				for (var i=0;i<arr.length;i++){
					this.disabledObj[arr[i] + '_isDisabled'] = true
				}
				return param;
			},

			/**
			 * 获取对象后获取缓存表单
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json ,func){
				var form = $.db.get("form");
				var obj = Object.assign({} ,form ,this.obj);
				if (form) {
					this.obj = $.push(this.obj ,obj);
				}
				if (form) {
					this.form = $.push(this.form ,form);
				}
				if(func){
					func(json);
				}
			},

		},
		created() {
			this.get_list_user_consultant_user();
			this.get_user_session_consulting_users();
			this.get_list_user_consulting_users();
		},
	}
</script>

<style>
</style>
