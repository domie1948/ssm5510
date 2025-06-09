<template>
	<div>
		<el-form-item v-if="$check_register_field('add','consultant_name','/consultant/view')" label="咨询师姓名" prop="consultant_name">
		<el-input id="consultant_name" v-model="form['consultant_name']" placeholder="请输入咨询师姓名"></el-input>
		</el-form-item>
		<el-form-item v-if="$check_register_field('add','consultant_gender','/consultant/view')" label="咨询师性别" prop="consultant_gender">
		<el-select id="consultant_gender" v-model="form['consultant_gender']">
			<el-option v-for="o in list_consultant_gender" :key="o" :label="o" :value="o">
			</el-option>
		</el-select>
		</el-form-item>

	</div>
</template>

<script>
	import mixin from "@/mixins/component.js";

	export default {
		mixins: [mixin],
		props:{

			form:{
				type: Object,
				default: function(){
					return {
						"consultant_name":'',
						"consultant_gender":'',
					}
				}
			},

		},
		data() {
			return {
				field: "consultant_id",
				url_add: "~/api/consultant/add?",
				url_set: "~/api/consultant/set?",
				url_upload: "~/api/consultant/upload?",
				list_consultant_gender: ['男','女'],

				rules: {
					"consultant_name": [ ],
					"consultant_gender": [ ],
				}

			}
		},
		methods: {

		},
		created() {
		}
	}
</script>
