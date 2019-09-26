import "./vendor.ts";
import {NgModule} from "@angular/core";
import {BrowserModule} from "@angular/platform-browser";
import {Ng2Webstorage} from "ngx-webstorage";
import {ModulUbezpieczenSharedModule, UserRouteAccessService} from "./shared";
import {ModulUbezpieczenAppRoutingModule} from "./app-routing.module";
import {ModulUbezpieczenHomeModule} from "./home/home.module";
import {ModulUbezpieczenAdminModule} from "./admin/admin.module";
import {ModulUbezpieczenAccountModule} from "./account/account.module";
import {ModulUbezpieczenEntityModule} from "./entities/entity.module";
import {customHttpProvider} from "./blocks/interceptor/http.provider";
import {PaginationConfig} from "./blocks/config/uib-pagination.config";
// jhipster-needle-angular-add-module-import JHipster will add new module here
import {
    JhiMainComponent,
    NavbarComponent,
    FooterComponent,
    ProfileService,
    PageRibbonComponent,
    ActiveMenuDirective,
    ErrorComponent
} from "./layouts";
import {Polisa} from "./home/polisa.service";

@NgModule({
    imports: [
        BrowserModule,
        ModulUbezpieczenAppRoutingModule,
        Ng2Webstorage.forRoot({prefix: 'jhi', separator: '-'}),
        ModulUbezpieczenSharedModule,
        ModulUbezpieczenHomeModule,
        ModulUbezpieczenAdminModule,
        ModulUbezpieczenAccountModule,
        ModulUbezpieczenEntityModule,
        // jhipster-needle-angular-add-module JHipster will add new module here
    ],
    declarations: [
        JhiMainComponent,
        NavbarComponent,
        ErrorComponent,
        PageRibbonComponent,
        ActiveMenuDirective,
        FooterComponent
    ],
    providers: [
        Polisa,
        ProfileService,
        customHttpProvider(),
        PaginationConfig,
        UserRouteAccessService
    ],
    bootstrap: [JhiMainComponent]
})
export class ModulUbezpieczenAppModule {
}
