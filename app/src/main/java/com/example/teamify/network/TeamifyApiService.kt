package com.example.teamify.network




interface TeamifyApi {

        val authApi: AuthApiService
        val userApi: UserApiService
        val projectApi: ProjectApiService
        val subprojectApi: SubprojectApiService
        val teamApi:TeamApiService
        val taskApi: TaskApiService
        val teamMemberApi: TeamMemberApiService
        val milestoneApi: MilestoneApiService
        val issueApi: IssueApiService

}
