<template>
	<div class="diy_edit page_reservation_information" id="reservation_information_edit">
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
					<div v-if="$check_field('set','time_of_appointment') || $check_field('add','time_of_appointment') || $check_field('get','time_of_appointment')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>预约时间:
							</span>
						</div>
						<!-- 日长 -->
						<div class="diy_field diy_datetime">
							<input type="datetime-local" :disabled="disabledObj['time_of_appointment_isDisabled']" id="form_time_of_appointment" v-model="form['time_of_appointment']" placeholder="请输入预约时间" v-if="(form['time_of_appointment'] && $check_field('set','time_of_appointment')) || (!form['time_of_appointment'] && $check_field('add','time_of_appointment'))" />
							<span v-else-if="$check_field('get','time_of_appointment')">{{ form['consultant_name'] }}</span>
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
					<div v-if="$check_field('set','reservation_user') || $check_field('add','reservation_user') || $check_field('get','reservation_user')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>预约用户:
							</span>
						</div>
						<div class="diy_field diy_down">
							<select id="form_reservation_user" :disabled="disabledObj['reservation_user_isDisabled']" v-model="form['reservation_user']" v-if="(form['reservation_user'] && $check_field('set','reservation_user')) || (!form['reservation_user'] && $check_field('add','reservation_user'))" >
								<option v-for="o in list_user_reservation_user" :value="o['user_id']">
									{{o['nickname'] + '-' + o['username']}}
								</option>
							</select>
							<span v-else-if="$check_field('get','reservation_user')">{{ form['reservation_user'] }}</span>
						</div>
					</div>
					<div v-if="$check_field('set','reservation_information') || $check_field('add','reservation_information') || $check_field('get','reservation_information')" class="form-item col-12 col-md-6">
						<div class="diy_title">
							<span>预约信息:
							</span>
						</div>
						<!-- 多文本 -->
						<div class="diy_field diy_desc">
							<textarea id="form_reservation_information" v-model="form['reservation_information']" v-if="(form['reservation_information'] && $check_field('set','reservation_information')) || (!form['reservation_information'] && $check_field('add','reservation_information'))" :disabled="disabledObj['reservation_information_isDisabled']" />
							<span v-else-if="$check_field('get','reservation_information')">{{ form['consultant_name'] }}</span>
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
				url_get_obj: "~/api/reservation_information/get_obj?",
				url_add: "~/api/reservation_information/add?",
				url_set: "~/api/reservation_information/set?",

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
					"time_of_appointment": "",
					"user_name": "",
					"reservation_user": 0,
					"reservation_information": "",
					"reservation_information_id": 0,
				},

				obj: {
					"consultant_name":'', // 咨询师姓名
					"consultant_user": 0, // 咨询师用户
					"consultant_gender":'', // 咨询师性别
					"consulting_direction":'', // 咨询方向
					"time_of_appointment": "1970-01-01 00:00:00",
					"user_name":'', // 用户姓名
					"reservation_user": 0, // 预约用户
					"reservation_information":'', // 预约信息
					"reservation_information_id": 0,
				},

				// 表单字段
				form: {
					"consultant_name":'', // 咨询师姓名
					"consultant_user": 0, // 咨询师用户
					"consultant_gender":'', // 咨询师性别
					"consulting_direction":'', // 咨询方向
					"time_of_appointment": "1970-01-01 00:00:00",
					"user_name":'', // 用户姓名
					"reservation_user": 0, // 预约用户
					"reservation_information":'', // 预约信息
					"reservation_information_id": 0,
				},
				disabledObj:{
					"consultant_name_isDisabled": false,
					"consultant_user_isDisabled": false,
					"consultant_gender_isDisabled": false,
					"consulting_direction_isDisabled": false,
					"time_of_appointment_isDisabled": false,
					"user_name_isDisabled": false,
					"reservation_user_isDisabled": false,
					"reservation_information_isDisabled": false,
				},
				// 用户列表
				list_user_consultant_user: [],
				// 用户列表
				list_user_reservation_user: [],

				// ID字段
				field: "reservation_information_id",
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
			async get_list_user_reservation_user() {
				// if(this.user_group !== "管理员" && this.form["reservation_user"] === 0) {
				//     this.form["reservation_user"] = this.user.user_id;
				// }
				var json = await this.$get("~/api/user/get_list?user_group=普通用户");
				if(json.result && json.result.list){
					this.list_user_reservation_user = json.result.list;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			async get_user_session_reservation_user(){
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
								_this.form["reservation_user"] = user_id
								_this.disabledObj['reservation_user' + '_isDisabled'] = true
								for (var i=0;i<arr.length;i++){
									for (var j=0;j<arrForm.length;j++){
										if (arr[i]===arrForm[j]){
											if (arr[i]!=="reservation_user") {
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
				this.$post("~/api/reservation_information/upload?", form, (res) => {
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
				this.form["time_of_appointment"] = this.$toTime(parseInt(this.form["time_of_appointment"]),"yyyy-MM-ddThh:mm")
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
			this.get_user_session_reservation_user();
			this.get_list_user_reservation_user();
		},
	}
</script>

<style>
</style>
