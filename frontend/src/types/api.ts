export interface ApiResponse<T> {
  success: boolean;
  message: string;
  data: T;
  timestamp: string;
}

export type UserRole = 'TENANT' | 'LANDLORD' | 'ADMIN';

export interface User {
  id: number;
  email: string;
  role: UserRole;
}
