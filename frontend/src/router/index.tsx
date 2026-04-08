import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom';
import PublicLayout from '../layouts/PublicLayout';
import TenantLayout from '../layouts/TenantLayout';
import LandlordLayout from '../layouts/LandlordLayout';
import AdminLayout from '../layouts/AdminLayout';
import { ProtectedRoute } from '../components/ProtectedRoute';
import { LoginPage } from '../pages/LoginPage';
import { RegisterPage } from '../pages/RegisterPage';
import { TenantDashboardPage } from '../pages/TenantDashboardPage';
import { TenantProfilePage } from '../pages/TenantProfilePage';
import { ListingPage } from '../pages/ListingPage';
import { ListingDetailPage } from '../pages/ListingDetailPage';
import { MessagesPage } from '../pages/MessagesPage';
import { MessageThreadPage } from '../pages/MessageThreadPage';
import { ViewingsPage } from '../pages/ViewingsPage';
import { ContractPage } from '../pages/ContractPage';
import { LandlordDashboardPage } from '../pages/LandlordDashboardPage';
import { LandlordProfilePage } from '../pages/LandlordProfilePage';
import { LandlordListingsPage } from '../pages/LandlordListingsPage';
import { LandlordListingNewPage } from '../pages/LandlordListingNewPage';
import { LandlordListingEditPage } from '../pages/LandlordListingEditPage';
import { ScreeningPage } from '../pages/ScreeningPage';
import { LandlordViewingsPage } from '../pages/LandlordViewingsPage';
import { LandlordContractsNewPage } from '../pages/LandlordContractsNewPage';
import { LandlordDepositsPage } from '../pages/LandlordDepositsPage';
import { AdminDashboardPage } from '../pages/AdminDashboardPage';
import { AdminUsersPage } from '../pages/AdminUsersPage';
import { AdminTicketsPage } from '../pages/AdminTicketsPage';
import { MarketplacePage } from '../pages/MarketplacePage';
import { UnauthorizedPage } from '../pages/UnauthorizedPage';

export function AppRouter() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Navigate to="/listings" replace />} />
        <Route path="/login" element={<PublicLayout><LoginPage /></PublicLayout>} />
        <Route path="/register" element={<PublicLayout><RegisterPage /></PublicLayout>} />
        <Route path="/marketplace" element={<PublicLayout><MarketplacePage /></PublicLayout>} />
        <Route path="/unauthorized" element={<PublicLayout><UnauthorizedPage /></PublicLayout>} />

        <Route
          path="/tenant/dashboard"
          element={
            <ProtectedRoute allowedRoles={['TENANT']}>
              <TenantLayout>
                <TenantDashboardPage />
              </TenantLayout>
            </ProtectedRoute>
          }
        />
        <Route
          path="/tenant/profile"
          element={
            <ProtectedRoute allowedRoles={['TENANT']}>
              <TenantLayout>
                <TenantProfilePage />
              </TenantLayout>
            </ProtectedRoute>
          }
        />

        <Route path="/listings" element={<PublicLayout><ListingPage /></PublicLayout>} />
        <Route path="/listings/:id" element={<PublicLayout><ListingDetailPage /></PublicLayout>} />

        <Route
          path="/messages"
          element={
            <ProtectedRoute allowedRoles={['TENANT', 'LANDLORD']}>
              <TenantLayout>
                <MessagesPage />
              </TenantLayout>
            </ProtectedRoute>
          }
        />
        <Route
          path="/messages/:threadId"
          element={
            <ProtectedRoute allowedRoles={['TENANT', 'LANDLORD']}>
              <TenantLayout>
                <MessageThreadPage />
              </TenantLayout>
            </ProtectedRoute>
          }
        />

        <Route
          path="/viewings"
          element={
            <ProtectedRoute allowedRoles={['TENANT', 'LANDLORD']}>
              <TenantLayout>
                <ViewingsPage />
              </TenantLayout>
            </ProtectedRoute>
          }
        />

        <Route
          path="/contracts/:id"
          element={
            <ProtectedRoute allowedRoles={['TENANT', 'LANDLORD']}>
              <TenantLayout>
                <ContractPage />
              </TenantLayout>
            </ProtectedRoute>
          }
        />

        <Route
          path="/landlord/dashboard"
          element={
            <ProtectedRoute allowedRoles={['LANDLORD']}>
              <LandlordLayout>
                <LandlordDashboardPage />
              </LandlordLayout>
            </ProtectedRoute>
          }
        />
        <Route
          path="/landlord/profile"
          element={
            <ProtectedRoute allowedRoles={['LANDLORD']}>
              <LandlordLayout>
                <LandlordProfilePage />
              </LandlordLayout>
            </ProtectedRoute>
          }
        />
        <Route
          path="/landlord/listings"
          element={
            <ProtectedRoute allowedRoles={['LANDLORD']}>
              <LandlordLayout>
                <LandlordListingsPage />
              </LandlordLayout>
            </ProtectedRoute>
          }
        />
        <Route
          path="/landlord/listings/new"
          element={
            <ProtectedRoute allowedRoles={['LANDLORD']}>
              <LandlordLayout>
                <LandlordListingNewPage />
              </LandlordLayout>
            </ProtectedRoute>
          }
        />
        <Route
          path="/landlord/listings/:id/edit"
          element={
            <ProtectedRoute allowedRoles={['LANDLORD']}>
              <LandlordLayout>
                <LandlordListingEditPage />
              </LandlordLayout>
            </ProtectedRoute>
          }
        />
        <Route
          path="/landlord/screening"
          element={
            <ProtectedRoute allowedRoles={['LANDLORD']}>
              <LandlordLayout>
                <ScreeningPage />
              </LandlordLayout>
            </ProtectedRoute>
          }
        />
        <Route
          path="/landlord/viewings"
          element={
            <ProtectedRoute allowedRoles={['LANDLORD']}>
              <LandlordLayout>
                <LandlordViewingsPage />
              </LandlordLayout>
            </ProtectedRoute>
          }
        />
        <Route
          path="/landlord/contracts/new"
          element={
            <ProtectedRoute allowedRoles={['LANDLORD']}>
              <LandlordLayout>
                <LandlordContractsNewPage />
              </LandlordLayout>
            </ProtectedRoute>
          }
        />
        <Route
          path="/landlord/deposits"
          element={
            <ProtectedRoute allowedRoles={['LANDLORD']}>
              <LandlordLayout>
                <LandlordDepositsPage />
              </LandlordLayout>
            </ProtectedRoute>
          }
        />

        <Route
          path="/admin/dashboard"
          element={
            <ProtectedRoute allowedRoles={['ADMIN']}>
              <AdminLayout>
                <AdminDashboardPage />
              </AdminLayout>
            </ProtectedRoute>
          }
        />
        <Route
          path="/admin/users"
          element={
            <ProtectedRoute allowedRoles={['ADMIN']}>
              <AdminLayout>
                <AdminUsersPage />
              </AdminLayout>
            </ProtectedRoute>
          }
        />
        <Route
          path="/admin/tickets"
          element={
            <ProtectedRoute allowedRoles={['ADMIN']}>
              <AdminLayout>
                <AdminTicketsPage />
              </AdminLayout>
            </ProtectedRoute>
          }
        />

        <Route path="*" element={<Navigate to="/" replace />} />
      </Routes>
    </BrowserRouter>
  );
}

export default AppRouter;
