<template>
	<el-main class="bg edit_wrap">
		<el-form ref="form" :model="form" status-icon label-width="120px" v-if="is_view()">
			<el-col v-if="user_group === '管理员' || $check_field('get','decompression_title') || $check_field('add','decompression_title') || $check_field('set','decompression_title')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="减压标题" prop="decompression_title">
					<el-input id="decompression_title" v-model="form['decompression_title']" placeholder="请输入减压标题"
							  v-if="user_group === '管理员' || (form['decompression_base_camp_id'] && $check_field('set','decompression_title')) || (!form['decompression_base_camp_id'] && $check_field('add','decompression_title'))" :disabled="disabledObj['decompression_title_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','decompression_title')">{{form['decompression_title']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','consultant_name') || $check_field('add','consultant_name') || $check_field('set','consultant_name')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="咨询师姓名" prop="consultant_name">
					<el-input id="consultant_name" v-model="form['consultant_name']" placeholder="请输入咨询师姓名"
							  v-if="user_group === '管理员' || (form['decompression_base_camp_id'] && $check_field('set','consultant_name')) || (!form['decompression_base_camp_id'] && $check_field('add','consultant_name'))" :disabled="disabledObj['consultant_name_isDisabled']"></el-input>
					<div v-else-if="$check_field('get','consultant_name')">{{form['consultant_name']}}</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','decompression_cover') || $check_field('add','decompression_cover') || $check_field('set','decompression_cover')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="减压封面" prop="decompression_cover">
					<el-upload :disabled="disabledObj['decompression_cover_isDisabled']" id="decompression_cover" class="avatar-uploader" drag
						accept="image/gif, image/jpeg, image/png, image/jpg" action="" :http-request="upload_decompression_cover"
						:show-file-list="false" v-if="user_group === '管理员' || (form['decompression_base_camp_id'] && $check_field('set','decompression_cover')) || (!form['decompression_base_camp_id'] && $check_field('add','decompression_cover'))">
						<img v-if="form['decompression_cover']" :src="$fullUrl(form['decompression_cover'])" class="avatar">
						<i v-else class="el-icon-plus avatar-uploader-icon"></i>
					</el-upload>
					<el-image v-else-if="$check_field('get','decompression_cover')" style="width: 100px; height: 100px"
						:src="$fullUrl(form['decompression_cover'])" :preview-src-list="[$fullUrl(form['decompression_cover'])]">
						<div slot="error" class="image-slot">
							<img src="../../../public/img/error.png" style="width: 90px; height: 90px" />
						</div>
					</el-image>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','consultant_user') || $check_field('add','consultant_user') || $check_field('set','consultant_user')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="咨询师用户" prop="consultant_user">
						<div v-if="user_group !== '管理员'">
							{{ get_user_session_consultant_user(form['consultant_user']) }}
							<!--<el-input id="business_name" v-model="form['consultant_user']" placeholder="请输入咨询师用户"-->
							<!--v-if="user_group === '管理员' || (form['decompression_base_camp_id'] && $check_field('set','consultant_user')) || (!form['decompression_base_camp_id'] && $check_field('add','consultant_user'))" :disabled="disabledObj['consultant_user_isDisabled']"></el-input>-->
							<!--<div v-else-if="$check_field('get','consultant_user')">{{form['consultant_user']}}</div>-->
							<el-select v-if="user_group === '管理员' || (form['decompression_base_camp_id'] && $check_field('set','consultant_user')) || (!form['decompression_base_camp_id'] && $check_field('add','consultant_user'))" id="consultant_user" v-model="form['consultant_user']" :disabled="disabledObj['consultant_user_isDisabled']">
								<el-option v-for="o in list_user_consultant_user" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
							<el-select v-else-if="$check_field('get','consultant_user')" id="consultant_user" v-model="form['consultant_user']" :disabled="true">
								<el-option v-for="o in list_user_consultant_user" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
										   :value="o['user_id']">
								</el-option>
							</el-select>
						</div>
						<el-select v-else id="consultant_user" v-model="form['consultant_user']" :disabled="disabledObj['consultant_user_isDisabled']">
							<el-option v-for="o in list_user_consultant_user" :key="o['username']" :label="o['nickname'] + '-' + o['username']"
									   :value="o['user_id']">
							</el-option>
						</el-select>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','decompression_audio') || $check_field('add','decompression_audio') || $check_field('set','decompression_audio')" :xs="24" :sm="12" :lg="8" class="el_form_item_warp">
				<el-form-item label="减压音频" prop="decompression_audio">
					<el-upload v-if="user_group === '管理员' || (form['decompression_base_camp_id'] && $check_field('set','decompression_audio')) || (!form['decompression_base_camp_id'] && $check_field('add','decompression_audio'))" class="upload-demo" drag
						action="" style="max-width: 300px;width: 100%;" :http-request="upload_decompression_audio" :limit="1" accept="audio/ogg,audio/mp3,audio/wav">
						<i class="el-icon-upload"></i>
						<div class="el-upload__text">将音频拖到此处，或<em>点击上传</em></div>
					</el-upload>
					<div v-else-if="$check_field('get','decompression_audio')">
						<el-button type="primary" @click="download(form['decompression_audio'])">下载<i
								class="el-icon-download el-icon--right"></i></el-button>
					</div>
				</el-form-item>
			</el-col>
			<el-col v-if="user_group === '管理员' || $check_field('get','decompression_content') || $check_field('add','decompression_content') || $check_field('set','decompression_content')" :xs="24" :sm="24" :lg="24" class="el_form_editor_warp">
				<el-form-item label="减压内容" prop="decompression_content">
					<quill-editor v-model.number="form['decompression_content']"
						v-if="user_group === '管理员' || (form['decompression_base_camp_id'] && $check_field('set','decompression_content')) || (!form['decompression_base_camp_id'] && $check_field('add','decompression_content')) ">
					</quill-editor>
					<div v-else-if="$check_field('get','decompression_content')" v-html="form['decompression_content']"></div>
				</el-form-item>
			</el-col>
			<el-col :xs="24" :sm="12" :lg="8" class="el_form_btn_warp">
				<el-form-item>
					<el-button type="primary" @click="submit()">提交</el-button>
					<el-button @click="cancel()">取消</el-button>
				</el-form-item>
			</el-col>

		</el-form>
	</el-main>
</template>

<script>
	import mixin from "@/mixins/page.js";

	export default {
		mixins: [mixin],
		data() {
			return {
				field: "decompression_base_camp_id",
				url_add: "~/api/decompression_base_camp/add?",
				url_set: "~/api/decompression_base_camp/set?",
				url_get_obj: "~/api/decompression_base_camp/get_obj?",
				url_upload: "~/api/decompression_base_camp/upload?",

				query: {
					"decompression_base_camp_id": 0,
				},

				form: {
					"decompression_title":'', // 减压标题
					"consultant_name":'', // 咨询师姓名
					"decompression_cover":'', // 减压封面
					"consultant_user": 0, // 咨询师用户
					"decompression_audio":'', // 减压音频
					"decompression_content":'', // 减压内容
					"decompression_base_camp_id": 0, // ID

				},
				disabledObj:{
					"decompression_title_isDisabled": false,
					"consultant_name_isDisabled": false,
					"decompression_cover_isDisabled": false,
					"consultant_user_isDisabled": false,
					"decompression_audio_isDisabled": false,
					"decompression_content_isDisabled": false,
				},
				// 用户列表
				list_user_consultant_user: [],
				// 用户组
				group_user_consultant_user: "",
			}
		},
		methods: {
			/**
			 * 上传减压封面
			 * @param {Object} param图片参数
			 */
			upload_decompression_cover(param){
				this.uploadFile(param.file, "decompression_cover");
			},
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
			 * 获取咨询师用户组
			 */
			async get_group_user_consultant_user() {
				this.form["consultant_user"] = this.user.user_id;
				var json = await this.$get("~/api/user_group/get_obj?name=咨询师");
				if(json.result && json.result.obj){
					this.group_user_consultant_user = json.result.obj;
				}
				else if(json.error){
					console.error(json.error);
				}
			},
			get_user_session_consultant_user(id){
				var _this = this;
				var user_id = {"user_id":id}
				var url = "~/api/"+_this.group_user_consultant_user.source_table+"/get_obj?"
				this.$get(url, user_id, function(res) {
					if (res.result && res.result.obj) {
						var arr = []
						for (let key in res.result.obj) {
							arr.push(key)
						}
						var arrForm = []
						for (let key in _this.form) {
							arrForm.push(key)
						}
						for (var i=0;i<arr.length;i++){
							for (var j=0;j<arrForm.length;j++){
								if (arr[i]===arrForm[j]){
									if (arr[i]!=="consultant_user") {
										_this.form[arrForm[j]] = res.result.obj[arr[i]]
										_this.disabledObj[arrForm[j] + '_isDisabled'] = true
										break;
									}else {
										_this.disabledObj[arrForm[j] + '_isDisabled'] = true
									}
								}
							}
						}
					}
				});
			},
			get_user_consultant_user(id){
				var obj = this.list_user_consultant_user.getObj({"user_id":id});
				var ret = "";
				if(obj){
					if(obj.nickname){
						ret = obj.nickname;}
					else{
						ret = obj.username;
					}
				}
				return ret;
			},
			/**
			 * 上传减压音频
			 * @param {Object} param音频参数
			 */
			upload_decompression_audio(param){
				this.uploadFile(param.file, "decompression_audio");
			},

			/**
			 * 获取对象之前
			 * @param {Object} param
			 */
			get_obj_before(param) {
				var form = "";
				/**
				* 请求列表前
				* @param {Object} param
				*/
				var user_group = this.user.user_group;
				if (user_group !== "管理员") {
					switch (user_group) {
						case "咨询师用户":
							if(param["consultant_user"] > 0){
								param["consultant_user"] = this.user.user_id;
							}
							break;
					}
				}
				if(this.form && form){
					Object.keys(this.form).forEach(key => {
						Object.keys(form).forEach(dbKey => {
							// if(dbKey === "charging_standard"){
							// 	this.form['charging_rules'] = form[dbKey];
							// 	this.disabledObj['charging_rules_isDisabled'] = true;
							// };
							if(key === dbKey){
								this.disabledObj[key+'_isDisabled'] = true;
							}
						})
					})
				}
				$.db.del("form");
				return param;
			},

			/**
			 * 获取对象之后
			 * @param {Object} json
			 * @param {Object} func
			 */
			get_obj_after(json, func){
			},

			is_view(){
				var bl = this.user_group == "管理员";

				if(!bl){
					bl = this.$check_action('/decompression_base_camp/table','add');
					console.log(bl ? "你有表格添加权限视作有添加权限" : "你没有表格添加权限");
				}
				if(!bl){
					bl = this.$check_action('/decompression_base_camp/table','set');
					console.log(bl ? "你有表格添加权限视作有修改权限" : "你没有表格修改权限");
				}
				if(!bl){
					bl = this.$check_action('/decompression_base_camp/view','add');
					console.log(bl ? "你有视图添加权限视作有添加权限" : "你没有视图添加权限");
				}
				if(!bl){
					bl = this.$check_action('/decompression_base_camp/view','set');
					console.log(bl ? "你有视图修改权限视作有修改权限" : "你没有视图修改权限");
				}
				if(!bl){
					bl = this.$check_action('/decompression_base_camp/view','get');
					console.log(bl ? "你有视图查询权限视作有查询权限" : "你没有视图查询权限");
				}

				console.log(bl ? "具有当前页面的查看权，请注意这不代表你有字段的查看权" : "无权查看当前页，请注意即便有字段查询权限没有页面查询权限也不行");

				return bl;
			},
			/**
			 * 上传文件
			 * @param {Object} param
			 */
			uploadimg(param) {
				this.uploadFile(param.file, "avatar");
			},

		},
		created() {
			this.get_list_user_consultant_user();
			this.get_group_user_consultant_user();
		},
	}
</script>

<style>
	.avatar-uploader .el-upload {
		border: 1px dashed #d9d9d9;
		border-radius: 6px;
		cursor: pointer;
		position: relative;
		overflow: hidden;
	}

	.avatar-uploader .el-upload:hover {
		border-color: #409EFF;
	}

	.avatar-uploader-icon {
		font-size: 28px;
		color: #8c939d;
		width: 178px;
		height: 178px;
		line-height: 178px;
		text-align: center;
	}

	.avatar {
		width: 178px;
		height: 178px;
		display: block;
	}
</style>
