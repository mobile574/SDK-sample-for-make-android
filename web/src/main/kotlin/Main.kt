import co.touchlab.kermit.Kermit
import com.mikepenz.common.di.initKoin
import com.mikepenz.common.repository.StoryblokRepositoryInterface
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import react.child
import react.createContext
import react.dom.render

object AppDependencies : KoinComponent {
    val repository: StoryblokRepositoryInterface
    val logger: Kermit

    init {
        initKoin()
        repository = get()
        logger = get()
    }
}

val AppDependenciesContext = createContext<AppDependencies>()


@InternalCoroutinesApi
fun main() {
    render(kotlinx.browser.document.getElementById("root")) {
        AppDependenciesContext.Provider(AppDependencies) {
            child(App)
        }
    }
}