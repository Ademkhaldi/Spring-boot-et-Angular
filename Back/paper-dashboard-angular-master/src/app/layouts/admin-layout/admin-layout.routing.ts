import { Routes } from '@angular/router';

import { DashboardComponent } from '../../pages/dashboard/dashboard.component';
import { UserComponent } from '../../pages/user/user.component';
import { TableComponent } from '../../pages/table/table.component';
import { TypographyComponent } from '../../pages/typography/typography.component';
import { IconsComponent } from '../../pages/icons/icons.component';
import { MapsComponent } from '../../pages/maps/maps.component';
import { NotificationsComponent } from '../../pages/notifications/notifications.component';
import { UpgradeComponent } from '../../pages/upgrade/upgrade.component';
import { AddDashboardComponent } from 'app/CRUD/dashboard/add-dashboard/add-dashboard.component';
import { DashboardListComponent } from 'app/CRUD/dashboard/dashboard-list/dashboard-list.component';
import { UpdateDashboardComponent } from 'app/CRUD/dashboard/update-dashboard/update-dashboard.component';
import { DashboardDetailsComponent } from 'app/CRUD/dashboard/dashboard-details/dashboard-details.component';
import { PortletListComponent } from 'app/CRUD/portlet/portlet-list/portlet-list.component';
import { AddPortletComponent } from 'app/CRUD/portlet/add-portlet/add-portlet.component';
import { UpdatePortletComponent } from 'app/CRUD/portlet/update-portlet/update-portlet.component';
import { PortletDetailsComponent } from 'app/CRUD/portlet/portlet-details/portlet-details.component';
import { DatasourceListComponent } from 'app/CRUD/datasource/datasource-list/datasource-list.component';
import { AddDatasourceComponent } from 'app/CRUD/datasource/add-datasource/add-datasource.component';
import { DatasourceDetailsComponent } from 'app/CRUD/datasource/datasource-details/datasource-details.component';
import { UpdateDatasourceComponent } from 'app/CRUD/datasource/update-datasource/update-datasource.component';
import { AddChartComponent } from 'app/CRUD/chart/add-chart/add-chart.component';
import { ChartDetailsComponent } from 'app/CRUD/chart/chart-details/chart-details.component';
import { ChartListComponent } from 'app/CRUD/chart/chart-list/chart-list.component';
import { UpdateChartComponent } from 'app/CRUD/chart/update-chart/update-chart.component';

export const AdminLayoutRoutes: Routes = [
    { path: 'dashboard', component: DashboardComponent },
    { path: 'getAllDashboards', component: DashboardListComponent },
    { path: 'Add', component: AddDashboardComponent },
    { path: 'Update/:id', component: UpdateDashboardComponent },
    { path: 'details/:id', component: DashboardDetailsComponent },
    

    { path: 'getAllPortlets', component: PortletListComponent },
    { path: 'AddPortlet', component: AddPortletComponent },
    { path: 'UpdatePortlet/:id', component: UpdatePortletComponent },
    { path: 'portlet/details/:id', component: PortletDetailsComponent },
    

    
    { path: 'getAllDatasources', component: DatasourceListComponent },
    { path: 'AddDatasource', component: AddDatasourceComponent },
    { path: 'UpdateDatasource/:id', component: UpdateDatasourceComponent },
    { path: 'datasource/details/:id', component: DatasourceDetailsComponent },

    { path: 'getAllCharts', component: ChartListComponent },
    { path: 'AddChart', component: AddChartComponent },
    { path: 'UpdateChart/:id', component: UpdateChartComponent },
    { path: 'chart/details/:id', component: ChartDetailsComponent },
    
    
    
    { path: 'user', component: UserComponent },
    { path: 'table', component: TableComponent },
    { path: 'typography', component: TypographyComponent },
    { path: 'icons', component: IconsComponent },
    { path: 'maps', component: MapsComponent },
    { path: 'notifications', component: NotificationsComponent },
    { path: 'upgrade', component: UpgradeComponent },
//    { path: '', redirectTo: 'dashboard', pathMatch: 'full' }, // Redirection vers le tableau de bord par défaut
//    { path: '**', redirectTo: 'dashboard' } //
];
