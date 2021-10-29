package br.com.dio.app.repositories.data.repositories

import android.os.RemoteException
import br.com.dio.app.repositories.data.model.Repo
import br.com.dio.app.repositories.data.services.GitHubService
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException

class RepoRepositoryImpl(private val service: GitHubService) : RepoRepositories {
    override suspend fun lisRepositories(user: String) = flow {
        try {

            val repoList = service.listRepositories(user)
            emit(repoList)
        } catch (ex: HttpException) {
            throw RemoteException(ex.message ?: "Não foi possível realizar a busca!")

        }
    }


}