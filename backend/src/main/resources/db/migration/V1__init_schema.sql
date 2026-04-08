-- ============================================================
-- PROJECT  : SichrPlace MVP
-- FILE     : V1__init_schema.sql
-- VERSION  : 1.0.0
-- DATE     : 2026-04-08
-- AUTHOR   : SichrPlace Dev
-- DESC     : Initial schema — all MVP tables
-- ============================================================

IF NOT EXISTS (SELECT * FROM sys.schemas WHERE name = 'sichr')
    EXEC('CREATE SCHEMA sichr');

-- === TABLE: sichr.users ===
IF OBJECT_ID('sichr.users', 'U') IS NULL
BEGIN
    CREATE TABLE sichr.users (
        id BIGINT IDENTITY(1,1) NOT NULL,
        email NVARCHAR(255) NOT NULL,
        password_hash NVARCHAR(255) NOT NULL,
        role NVARCHAR(50) NOT NULL,
        status NVARCHAR(50) NOT NULL CONSTRAINT DF_users_status DEFAULT 'PENDING',
        email_verified BIT NOT NULL CONSTRAINT DF_users_email_verified DEFAULT 0,
        created_at DATETIME2 NOT NULL CONSTRAINT DF_users_created_at DEFAULT GETDATE(),
        updated_at DATETIME2 NOT NULL CONSTRAINT DF_users_updated_at DEFAULT GETDATE(),
        is_deleted BIT NOT NULL CONSTRAINT DF_users_is_deleted DEFAULT 0,
        CONSTRAINT PK_users PRIMARY KEY (id),
        CONSTRAINT UQ_users_email UNIQUE (email),
        CONSTRAINT CHK_users_role CHECK (role IN ('TENANT','LANDLORD','ADMIN')),
        CONSTRAINT CHK_users_status CHECK (status IN ('PENDING','ACTIVE','SUSPENDED','DELETED'))
    );
    CREATE INDEX IX_users_email ON sichr.users(email);
    CREATE INDEX IX_users_role ON sichr.users(role);
    CREATE INDEX IX_users_status ON sichr.users(status);
    CREATE INDEX IX_users_is_deleted ON sichr.users(is_deleted);
END
GO

-- === TABLE: sichr.refresh_tokens ===
IF OBJECT_ID('sichr.refresh_tokens', 'U') IS NULL
BEGIN
    CREATE TABLE sichr.refresh_tokens (
        id BIGINT IDENTITY(1,1) NOT NULL,
        user_id BIGINT NOT NULL,
        token_hash NVARCHAR(500) NOT NULL,
        expires_at DATETIME2 NOT NULL,
        revoked BIT NOT NULL CONSTRAINT DF_refresh_tokens_revoked DEFAULT 0,
        created_at DATETIME2 NOT NULL CONSTRAINT DF_refresh_tokens_created_at DEFAULT GETDATE(),
        updated_at DATETIME2 NOT NULL CONSTRAINT DF_refresh_tokens_updated_at DEFAULT GETDATE(),
        CONSTRAINT PK_refresh_tokens PRIMARY KEY (id),
        CONSTRAINT FK_refresh_tokens_users FOREIGN KEY (user_id) REFERENCES sichr.users(id)
    );
    CREATE INDEX IX_refresh_tokens_user_id ON sichr.refresh_tokens(user_id);
    CREATE INDEX IX_refresh_tokens_expires_at ON sichr.refresh_tokens(expires_at);
    CREATE INDEX IX_refresh_tokens_revoked ON sichr.refresh_tokens(revoked);
END
GO

-- === TABLE: sichr.hobbies ===
IF OBJECT_ID('sichr.hobbies', 'U') IS NULL
BEGIN
    CREATE TABLE sichr.hobbies (
        id BIGINT IDENTITY(1,1) NOT NULL,
        name NVARCHAR(100) NOT NULL,
        created_at DATETIME2 NOT NULL CONSTRAINT DF_hobbies_created_at DEFAULT GETDATE(),
        updated_at DATETIME2 NOT NULL CONSTRAINT DF_hobbies_updated_at DEFAULT GETDATE(),
        CONSTRAINT PK_hobbies PRIMARY KEY (id),
        CONSTRAINT UQ_hobbies_name UNIQUE (name)
    );
    CREATE INDEX IX_hobbies_name ON sichr.hobbies(name);
END
GO

-- === TABLE: sichr.tenant_profiles ===
IF OBJECT_ID('sichr.tenant_profiles', 'U') IS NULL
BEGIN
    CREATE TABLE sichr.tenant_profiles (
        id BIGINT IDENTITY(1,1) NOT NULL,
        user_id BIGINT NOT NULL,
        first_name NVARCHAR(100) NOT NULL,
        last_name NVARCHAR(100) NOT NULL,
        profile_photo_url NVARCHAR(1000) NULL,
        date_of_birth DATE NULL,
        gender NVARCHAR(50) NULL,
        current_city NVARCHAR(150) NULL,
        bio NVARCHAR(300) NULL,
        personality_type NVARCHAR(50) NULL,
        smoking_preference NVARCHAR(50) NULL,
        has_pet BIT NOT NULL CONSTRAINT DF_tenant_profiles_has_pet DEFAULT 0,
        occupation NVARCHAR(150) NULL,
        contact_link NVARCHAR(500) NULL,
        created_at DATETIME2 NOT NULL CONSTRAINT DF_tenant_profiles_created_at DEFAULT GETDATE(),
        updated_at DATETIME2 NOT NULL CONSTRAINT DF_tenant_profiles_updated_at DEFAULT GETDATE(),
        is_deleted BIT NOT NULL CONSTRAINT DF_tenant_profiles_is_deleted DEFAULT 0,
        CONSTRAINT PK_tenant_profiles PRIMARY KEY (id),
        CONSTRAINT FK_tenant_profiles_users FOREIGN KEY (user_id) REFERENCES sichr.users(id),
        CONSTRAINT UQ_tenant_profiles_user_id UNIQUE (user_id),
        CONSTRAINT CHK_tenant_profiles_gender CHECK (gender IN ('MALE','FEMALE','NON_BINARY','PREFER_NOT_TO_SAY')),
        CONSTRAINT CHK_tenant_profiles_personality_type CHECK (personality_type IN ('INTROVERT','EXTROVERT','AMBIVERT')),
        CONSTRAINT CHK_tenant_profiles_smoking_preference CHECK (smoking_preference IN ('YES','NO','OUTSIDE_ONLY'))
    );
    CREATE INDEX IX_tenant_profiles_user_id ON sichr.tenant_profiles(user_id);
    CREATE INDEX IX_tenant_profiles_current_city ON sichr.tenant_profiles(current_city);
    CREATE INDEX IX_tenant_profiles_is_deleted ON sichr.tenant_profiles(is_deleted);
END
GO

-- === TABLE: sichr.tenant_hobbies ===
IF OBJECT_ID('sichr.tenant_hobbies', 'U') IS NULL
BEGIN
    CREATE TABLE sichr.tenant_hobbies (
        id BIGINT IDENTITY(1,1) NOT NULL,
        tenant_profile_id BIGINT NOT NULL,
        hobby_id BIGINT NOT NULL,
        created_at DATETIME2 NOT NULL CONSTRAINT DF_tenant_hobbies_created_at DEFAULT GETDATE(),
        updated_at DATETIME2 NOT NULL CONSTRAINT DF_tenant_hobbies_updated_at DEFAULT GETDATE(),
        CONSTRAINT PK_tenant_hobbies PRIMARY KEY (id),
        CONSTRAINT FK_tenant_hobbies_tenant_profiles FOREIGN KEY (tenant_profile_id) REFERENCES sichr.tenant_profiles(id),
        CONSTRAINT FK_tenant_hobbies_hobbies FOREIGN KEY (hobby_id) REFERENCES sichr.hobbies(id),
        CONSTRAINT UQ_tenant_hobbies_tenant_hobby UNIQUE (tenant_profile_id, hobby_id)
    );
    CREATE INDEX IX_tenant_hobbies_tenant_profile_id ON sichr.tenant_hobbies(tenant_profile_id);
    CREATE INDEX IX_tenant_hobbies_hobby_id ON sichr.tenant_hobbies(hobby_id);
END
GO

-- === TABLE: sichr.landlord_profiles ===
IF OBJECT_ID('sichr.landlord_profiles', 'U') IS NULL
BEGIN
    CREATE TABLE sichr.landlord_profiles (
        id BIGINT IDENTITY(1,1) NOT NULL,
        user_id BIGINT NOT NULL,
        first_name NVARCHAR(100) NOT NULL,
        last_name NVARCHAR(100) NOT NULL,
        profile_photo_url NVARCHAR(1000) NULL,
        date_of_birth DATE NULL,
        gender NVARCHAR(50) NULL,
        current_city NVARCHAR(150) NULL,
        bio NVARCHAR(300) NULL,
        personality_type NVARCHAR(50) NULL,
        occupation NVARCHAR(150) NULL,
        contact_link NVARCHAR(500) NULL,
        company_name NVARCHAR(255) NULL,
        created_at DATETIME2 NOT NULL CONSTRAINT DF_landlord_profiles_created_at DEFAULT GETDATE(),
        updated_at DATETIME2 NOT NULL CONSTRAINT DF_landlord_profiles_updated_at DEFAULT GETDATE(),
        is_deleted BIT NOT NULL CONSTRAINT DF_landlord_profiles_is_deleted DEFAULT 0,
        CONSTRAINT PK_landlord_profiles PRIMARY KEY (id),
        CONSTRAINT FK_landlord_profiles_users FOREIGN KEY (user_id) REFERENCES sichr.users(id),
        CONSTRAINT UQ_landlord_profiles_user_id UNIQUE (user_id),
        CONSTRAINT CHK_landlord_profiles_gender CHECK (gender IN ('MALE','FEMALE','NON_BINARY','PREFER_NOT_TO_SAY')),
        CONSTRAINT CHK_landlord_profiles_personality_type CHECK (personality_type IN ('INTROVERT','EXTROVERT','AMBIVERT'))
    );
    CREATE INDEX IX_landlord_profiles_user_id ON sichr.landlord_profiles(user_id);
    CREATE INDEX IX_landlord_profiles_current_city ON sichr.landlord_profiles(current_city);
    CREATE INDEX IX_landlord_profiles_is_deleted ON sichr.landlord_profiles(is_deleted);
END
GO

-- === TABLE: sichr.landlord_hobbies ===
IF OBJECT_ID('sichr.landlord_hobbies', 'U') IS NULL
BEGIN
    CREATE TABLE sichr.landlord_hobbies (
        id BIGINT IDENTITY(1,1) NOT NULL,
        landlord_profile_id BIGINT NOT NULL,
        hobby_id BIGINT NOT NULL,
        created_at DATETIME2 NOT NULL CONSTRAINT DF_landlord_hobbies_created_at DEFAULT GETDATE(),
        updated_at DATETIME2 NOT NULL CONSTRAINT DF_landlord_hobbies_updated_at DEFAULT GETDATE(),
        CONSTRAINT PK_landlord_hobbies PRIMARY KEY (id),
        CONSTRAINT FK_landlord_hobbies_landlord_profiles FOREIGN KEY (landlord_profile_id) REFERENCES sichr.landlord_profiles(id),
        CONSTRAINT FK_landlord_hobbies_hobbies FOREIGN KEY (hobby_id) REFERENCES sichr.hobbies(id),
        CONSTRAINT UQ_landlord_hobbies_landlord_hobby UNIQUE (landlord_profile_id, hobby_id)
    );
    CREATE INDEX IX_landlord_hobbies_landlord_profile_id ON sichr.landlord_hobbies(landlord_profile_id);
    CREATE INDEX IX_landlord_hobbies_hobby_id ON sichr.landlord_hobbies(hobby_id);
END
GO

-- === TABLE: sichr.facilities ===
IF OBJECT_ID('sichr.facilities', 'U') IS NULL
BEGIN
    CREATE TABLE sichr.facilities (
        id BIGINT IDENTITY(1,1) NOT NULL,
        name NVARCHAR(100) NOT NULL,
        icon_key NVARCHAR(100) NULL,
        created_at DATETIME2 NOT NULL CONSTRAINT DF_facilities_created_at DEFAULT GETDATE(),
        updated_at DATETIME2 NOT NULL CONSTRAINT DF_facilities_updated_at DEFAULT GETDATE(),
        CONSTRAINT PK_facilities PRIMARY KEY (id),
        CONSTRAINT UQ_facilities_name UNIQUE (name)
    );
    CREATE INDEX IX_facilities_name ON sichr.facilities(name);
END
GO

-- === TABLE: sichr.apartment_listings ===
IF OBJECT_ID('sichr.apartment_listings', 'U') IS NULL
BEGIN
    CREATE TABLE sichr.apartment_listings (
        id BIGINT IDENTITY(1,1) NOT NULL,
        landlord_profile_id BIGINT NOT NULL,
        title NVARCHAR(255) NOT NULL,
        description NVARCHAR(MAX) NULL,
        street_address NVARCHAR(500) NOT NULL,
        city NVARCHAR(150) NOT NULL,
        country NVARCHAR(100) NOT NULL,
        postal_code NVARCHAR(20) NULL,
        latitude DECIMAL(10,7) NULL,
        longitude DECIMAL(10,7) NULL,
        monthly_rent DECIMAL(12,2) NOT NULL,
        deposit_amount DECIMAL(12,2) NULL,
        number_of_rooms INT NULL,
        floor_number INT NULL,
        size_sqm DECIMAL(8,2) NULL,
        furnished_status NVARCHAR(50) NULL,
        available_from DATE NULL,
        available_to DATE NULL,
        listing_status NVARCHAR(50) NOT NULL CONSTRAINT DF_apartment_listings_listing_status DEFAULT 'DRAFT',
        created_at DATETIME2 NOT NULL CONSTRAINT DF_apartment_listings_created_at DEFAULT GETDATE(),
        updated_at DATETIME2 NOT NULL CONSTRAINT DF_apartment_listings_updated_at DEFAULT GETDATE(),
        is_deleted BIT NOT NULL CONSTRAINT DF_apartment_listings_is_deleted DEFAULT 0,
        CONSTRAINT PK_apartment_listings PRIMARY KEY (id),
        CONSTRAINT FK_apartment_listings_landlord_profiles FOREIGN KEY (landlord_profile_id) REFERENCES sichr.landlord_profiles(id),
        CONSTRAINT CHK_apartment_listings_furnished_status CHECK (furnished_status IN ('FURNISHED','UNFURNISHED','PARTIALLY_FURNISHED')),
        CONSTRAINT CHK_apartment_listings_listing_status CHECK (listing_status IN ('DRAFT','ACTIVE','PAUSED','RENTED','DELETED'))
    );
    CREATE INDEX IX_apartment_listings_landlord_profile_id ON sichr.apartment_listings(landlord_profile_id);
    CREATE INDEX IX_apartment_listings_city ON sichr.apartment_listings(city);
    CREATE INDEX IX_apartment_listings_monthly_rent ON sichr.apartment_listings(monthly_rent);
    CREATE INDEX IX_apartment_listings_available_from ON sichr.apartment_listings(available_from);
    CREATE INDEX IX_apartment_listings_listing_status ON sichr.apartment_listings(listing_status);
    CREATE INDEX IX_apartment_listings_furnished_status ON sichr.apartment_listings(furnished_status);
    CREATE INDEX IX_apartment_listings_number_of_rooms ON sichr.apartment_listings(number_of_rooms);
    CREATE INDEX IX_apartment_listings_is_deleted ON sichr.apartment_listings(is_deleted);
END
GO

-- === TABLE: sichr.listing_facilities ===
IF OBJECT_ID('sichr.listing_facilities', 'U') IS NULL
BEGIN
    CREATE TABLE sichr.listing_facilities (
        id BIGINT IDENTITY(1,1) NOT NULL,
        listing_id BIGINT NOT NULL,
        facility_id BIGINT NOT NULL,
        created_at DATETIME2 NOT NULL CONSTRAINT DF_listing_facilities_created_at DEFAULT GETDATE(),
        updated_at DATETIME2 NOT NULL CONSTRAINT DF_listing_facilities_updated_at DEFAULT GETDATE(),
        CONSTRAINT PK_listing_facilities PRIMARY KEY (id),
        CONSTRAINT FK_listing_facilities_apartment_listings FOREIGN KEY (listing_id) REFERENCES sichr.apartment_listings(id),
        CONSTRAINT FK_listing_facilities_facilities FOREIGN KEY (facility_id) REFERENCES sichr.facilities(id),
        CONSTRAINT UQ_listing_facilities_listing_facility UNIQUE (listing_id, facility_id)
    );
    CREATE INDEX IX_listing_facilities_listing_id ON sichr.listing_facilities(listing_id);
    CREATE INDEX IX_listing_facilities_facility_id ON sichr.listing_facilities(facility_id);
END
GO

-- === TABLE: sichr.listing_media ===
IF OBJECT_ID('sichr.listing_media', 'U') IS NULL
BEGIN
    CREATE TABLE sichr.listing_media (
        id BIGINT IDENTITY(1,1) NOT NULL,
        listing_id BIGINT NOT NULL,
        media_url NVARCHAR(1000) NOT NULL,
        media_type NVARCHAR(50) NOT NULL CONSTRAINT DF_listing_media_media_type DEFAULT 'IMAGE',
        display_order INT NOT NULL CONSTRAINT DF_listing_media_display_order DEFAULT 0,
        created_at DATETIME2 NOT NULL CONSTRAINT DF_listing_media_created_at DEFAULT GETDATE(),
        updated_at DATETIME2 NOT NULL CONSTRAINT DF_listing_media_updated_at DEFAULT GETDATE(),
        CONSTRAINT PK_listing_media PRIMARY KEY (id),
        CONSTRAINT FK_listing_media_apartment_listings FOREIGN KEY (listing_id) REFERENCES sichr.apartment_listings(id),
        CONSTRAINT CHK_listing_media_media_type CHECK (media_type IN ('IMAGE','VIDEO'))
    );
    CREATE INDEX IX_listing_media_listing_id ON sichr.listing_media(listing_id);
    CREATE INDEX IX_listing_media_media_type ON sichr.listing_media(media_type);
END
GO

-- === TABLE: sichr.contracts ===
IF OBJECT_ID('sichr.contracts', 'U') IS NULL
BEGIN
    CREATE TABLE sichr.contracts (
        id BIGINT IDENTITY(1,1) NOT NULL,
        listing_id BIGINT NOT NULL,
        tenant_profile_id BIGINT NOT NULL,
        landlord_profile_id BIGINT NOT NULL,
        full_name_tenant NVARCHAR(255) NOT NULL,
        full_name_landlord NVARCHAR(255) NOT NULL,
        apartment_details NVARCHAR(MAX) NULL,
        move_in_date DATE NULL,
        move_out_date DATE NULL,
        monthly_rent DECIMAL(12,2) NOT NULL,
        deposit_amount DECIMAL(12,2) NOT NULL,
        next_due_date DATE NULL,
        contract_status NVARCHAR(50) NOT NULL,
        contract_pdf_url NVARCHAR(1000) NULL,
        signed_at DATETIME2 NULL,
        created_at DATETIME2 NOT NULL CONSTRAINT DF_contracts_created_at DEFAULT GETDATE(),
        updated_at DATETIME2 NOT NULL CONSTRAINT DF_contracts_updated_at DEFAULT GETDATE(),
        CONSTRAINT PK_contracts PRIMARY KEY (id),
        CONSTRAINT FK_contracts_apartment_listings FOREIGN KEY (listing_id) REFERENCES sichr.apartment_listings(id),
        CONSTRAINT FK_contracts_tenant_profiles FOREIGN KEY (tenant_profile_id) REFERENCES sichr.tenant_profiles(id),
        CONSTRAINT FK_contracts_landlord_profiles FOREIGN KEY (landlord_profile_id) REFERENCES sichr.landlord_profiles(id),
        CONSTRAINT CHK_contracts_status CHECK (contract_status IN ('DRAFT','SIGNED_LANDLORD','SIGNED_TENANT','ACTIVE','TERMINATED'))
    );
    CREATE INDEX IX_contracts_listing_id ON sichr.contracts(listing_id);
    CREATE INDEX IX_contracts_tenant_profile_id ON sichr.contracts(tenant_profile_id);
    CREATE INDEX IX_contracts_landlord_profile_id ON sichr.contracts(landlord_profile_id);
    CREATE INDEX IX_contracts_contract_status ON sichr.contracts(contract_status);
END
GO

-- === TABLE: sichr.message_threads ===
IF OBJECT_ID('sichr.message_threads', 'U') IS NULL
BEGIN
    CREATE TABLE sichr.message_threads (
        id BIGINT IDENTITY(1,1) NOT NULL,
        listing_id BIGINT NOT NULL,
        tenant_profile_id BIGINT NOT NULL,
        landlord_profile_id BIGINT NOT NULL,
        created_at DATETIME2 NOT NULL CONSTRAINT DF_message_threads_created_at DEFAULT GETDATE(),
        updated_at DATETIME2 NOT NULL CONSTRAINT DF_message_threads_updated_at DEFAULT GETDATE(),
        CONSTRAINT PK_message_threads PRIMARY KEY (id),
        CONSTRAINT FK_message_threads_apartment_listings FOREIGN KEY (listing_id) REFERENCES sichr.apartment_listings(id),
        CONSTRAINT FK_message_threads_tenant_profiles FOREIGN KEY (tenant_profile_id) REFERENCES sichr.tenant_profiles(id),
        CONSTRAINT FK_message_threads_landlord_profiles FOREIGN KEY (landlord_profile_id) REFERENCES sichr.landlord_profiles(id),
        CONSTRAINT UQ_message_threads_listing_tenant UNIQUE (listing_id, tenant_profile_id)
    );
    CREATE INDEX IX_message_threads_listing_id ON sichr.message_threads(listing_id);
    CREATE INDEX IX_message_threads_tenant_profile_id ON sichr.message_threads(tenant_profile_id);
    CREATE INDEX IX_message_threads_landlord_profile_id ON sichr.message_threads(landlord_profile_id);
END
GO

-- === TABLE: sichr.messages ===
IF OBJECT_ID('sichr.messages', 'U') IS NULL
BEGIN
    CREATE TABLE sichr.messages (
        id BIGINT IDENTITY(1,1) NOT NULL,
        thread_id BIGINT NOT NULL,
        sender_user_id BIGINT NOT NULL,
        body NVARCHAR(MAX) NOT NULL,
        sent_at DATETIME2 NOT NULL CONSTRAINT DF_messages_sent_at DEFAULT GETDATE(),
        is_read BIT NOT NULL CONSTRAINT DF_messages_is_read DEFAULT 0,
        created_at DATETIME2 NOT NULL CONSTRAINT DF_messages_created_at DEFAULT GETDATE(),
        updated_at DATETIME2 NOT NULL CONSTRAINT DF_messages_updated_at DEFAULT GETDATE(),
        CONSTRAINT PK_messages PRIMARY KEY (id),
        CONSTRAINT FK_messages_message_threads FOREIGN KEY (thread_id) REFERENCES sichr.message_threads(id),
        CONSTRAINT FK_messages_users FOREIGN KEY (sender_user_id) REFERENCES sichr.users(id)
    );
    CREATE INDEX IX_messages_thread_id_sent_at ON sichr.messages(thread_id, sent_at);
    CREATE INDEX IX_messages_sender_user_id ON sichr.messages(sender_user_id);
    CREATE INDEX IX_messages_is_read ON sichr.messages(is_read);
END
GO

-- === TABLE: sichr.viewing_requests ===
IF OBJECT_ID('sichr.viewing_requests', 'U') IS NULL
BEGIN
    CREATE TABLE sichr.viewing_requests (
        id BIGINT IDENTITY(1,1) NOT NULL,
        listing_id BIGINT NOT NULL,
        tenant_profile_id BIGINT NOT NULL,
        landlord_profile_id BIGINT NOT NULL,
        proposed_datetime DATETIME2 NOT NULL,
        confirmed_datetime DATETIME2 NULL,
        viewing_status NVARCHAR(50) NOT NULL CONSTRAINT DF_viewing_requests_viewing_status DEFAULT 'PROPOSED',
        rejection_reason NVARCHAR(500) NULL,
        created_at DATETIME2 NOT NULL CONSTRAINT DF_viewing_requests_created_at DEFAULT GETDATE(),
        updated_at DATETIME2 NOT NULL CONSTRAINT DF_viewing_requests_updated_at DEFAULT GETDATE(),
        CONSTRAINT PK_viewing_requests PRIMARY KEY (id),
        CONSTRAINT FK_viewing_requests_apartment_listings FOREIGN KEY (listing_id) REFERENCES sichr.apartment_listings(id),
        CONSTRAINT FK_viewing_requests_tenant_profiles FOREIGN KEY (tenant_profile_id) REFERENCES sichr.tenant_profiles(id),
        CONSTRAINT FK_viewing_requests_landlord_profiles FOREIGN KEY (landlord_profile_id) REFERENCES sichr.landlord_profiles(id),
        CONSTRAINT CHK_viewing_requests_status CHECK (viewing_status IN ('PROPOSED','CONFIRMED','REJECTED','COMPLETED','CANCELLED'))
    );
    CREATE INDEX IX_viewing_requests_listing_id ON sichr.viewing_requests(listing_id);
    CREATE INDEX IX_viewing_requests_listing_id_viewing_status ON sichr.viewing_requests(listing_id, viewing_status);
    CREATE INDEX IX_viewing_requests_viewing_status ON sichr.viewing_requests(viewing_status);
END
GO

-- === TABLE: sichr.rent_schedules ===
IF OBJECT_ID('sichr.rent_schedules', 'U') IS NULL
BEGIN
    CREATE TABLE sichr.rent_schedules (
        id BIGINT IDENTITY(1,1) NOT NULL,
        listing_id BIGINT NOT NULL,
        tenant_profile_id BIGINT NOT NULL,
        due_date DATE NOT NULL,
        amount DECIMAL(12,2) NOT NULL,
        paid_at DATETIME2 NULL,
        payment_status NVARCHAR(50) NOT NULL CONSTRAINT DF_rent_schedules_payment_status DEFAULT 'PENDING',
        stripe_payment_intent_id NVARCHAR(255) NULL,
        created_at DATETIME2 NOT NULL CONSTRAINT DF_rent_schedules_created_at DEFAULT GETDATE(),
        updated_at DATETIME2 NOT NULL CONSTRAINT DF_rent_schedules_updated_at DEFAULT GETDATE(),
        CONSTRAINT PK_rent_schedules PRIMARY KEY (id),
        CONSTRAINT FK_rent_schedules_apartment_listings FOREIGN KEY (listing_id) REFERENCES sichr.apartment_listings(id),
        CONSTRAINT FK_rent_schedules_tenant_profiles FOREIGN KEY (tenant_profile_id) REFERENCES sichr.tenant_profiles(id),
        CONSTRAINT CHK_rent_schedules_payment_status CHECK (payment_status IN ('PENDING','PAID','OVERDUE','WAIVED'))
    );
    CREATE INDEX IX_rent_schedules_listing_id ON sichr.rent_schedules(listing_id);
    CREATE INDEX IX_rent_schedules_tenant_profile_id_due_date ON sichr.rent_schedules(tenant_profile_id, due_date);
    CREATE INDEX IX_rent_schedules_payment_status ON sichr.rent_schedules(payment_status);
    CREATE INDEX IX_rent_schedules_due_date ON sichr.rent_schedules(due_date);
END
GO

-- === TABLE: sichr.deposits ===
IF OBJECT_ID('sichr.deposits', 'U') IS NULL
BEGIN
    CREATE TABLE sichr.deposits (
        id BIGINT IDENTITY(1,1) NOT NULL,
        listing_id BIGINT NOT NULL,
        tenant_profile_id BIGINT NOT NULL,
        deposit_amount DECIMAL(12,2) NOT NULL,
        deposit_status NVARCHAR(50) NOT NULL CONSTRAINT DF_deposits_deposit_status DEFAULT 'PENDING',
        held_at DATETIME2 NULL,
        released_at DATETIME2 NULL,
        release_reason NVARCHAR(500) NULL,
        stripe_hold_id NVARCHAR(255) NULL,
        created_at DATETIME2 NOT NULL CONSTRAINT DF_deposits_created_at DEFAULT GETDATE(),
        updated_at DATETIME2 NOT NULL CONSTRAINT DF_deposits_updated_at DEFAULT GETDATE(),
        CONSTRAINT PK_deposits PRIMARY KEY (id),
        CONSTRAINT FK_deposits_apartment_listings FOREIGN KEY (listing_id) REFERENCES sichr.apartment_listings(id),
        CONSTRAINT FK_deposits_tenant_profiles FOREIGN KEY (tenant_profile_id) REFERENCES sichr.tenant_profiles(id),
        CONSTRAINT CHK_deposits_deposit_status CHECK (deposit_status IN ('PENDING','HELD','RELEASED','FORFEITED'))
    );
    CREATE INDEX IX_deposits_listing_id ON sichr.deposits(listing_id);
    CREATE INDEX IX_deposits_tenant_profile_id ON sichr.deposits(tenant_profile_id);
    CREATE INDEX IX_deposits_deposit_status ON sichr.deposits(deposit_status);
END
GO

-- === TABLE: sichr.support_tickets ===
IF OBJECT_ID('sichr.support_tickets', 'U') IS NULL
BEGIN
    CREATE TABLE sichr.support_tickets (
        id BIGINT IDENTITY(1,1) NOT NULL,
        sender_user_id BIGINT NOT NULL,
        subject NVARCHAR(255) NOT NULL,
        body NVARCHAR(MAX) NOT NULL,
        ticket_status NVARCHAR(50) NOT NULL CONSTRAINT DF_support_tickets_ticket_status DEFAULT 'OPEN',
        created_at DATETIME2 NOT NULL CONSTRAINT DF_support_tickets_created_at DEFAULT GETDATE(),
        updated_at DATETIME2 NOT NULL CONSTRAINT DF_support_tickets_updated_at DEFAULT GETDATE(),
        is_deleted BIT NOT NULL CONSTRAINT DF_support_tickets_is_deleted DEFAULT 0,
        CONSTRAINT PK_support_tickets PRIMARY KEY (id),
        CONSTRAINT FK_support_tickets_users FOREIGN KEY (sender_user_id) REFERENCES sichr.users(id),
        CONSTRAINT CHK_support_tickets_ticket_status CHECK (ticket_status IN ('OPEN','IN_PROGRESS','RESOLVED'))
    );
    CREATE INDEX IX_support_tickets_sender_user_id ON sichr.support_tickets(sender_user_id);
    CREATE INDEX IX_support_tickets_ticket_status ON sichr.support_tickets(ticket_status);
    CREATE INDEX IX_support_tickets_is_deleted ON sichr.support_tickets(is_deleted);
END
GO

-- === TABLE: sichr.terms_acceptance ===
IF OBJECT_ID('sichr.terms_acceptance', 'U') IS NULL
BEGIN
    CREATE TABLE sichr.terms_acceptance (
        id BIGINT IDENTITY(1,1) NOT NULL,
        user_id BIGINT NOT NULL,
        terms_version NVARCHAR(50) NOT NULL,
        accepted_at DATETIME2 NOT NULL CONSTRAINT DF_terms_acceptance_accepted_at DEFAULT GETDATE(),
        ip_address NVARCHAR(50) NULL,
        created_at DATETIME2 NOT NULL CONSTRAINT DF_terms_acceptance_created_at DEFAULT GETDATE(),
        updated_at DATETIME2 NOT NULL CONSTRAINT DF_terms_acceptance_updated_at DEFAULT GETDATE(),
        CONSTRAINT PK_terms_acceptance PRIMARY KEY (id),
        CONSTRAINT FK_terms_acceptance_users FOREIGN KEY (user_id) REFERENCES sichr.users(id)
    );
    CREATE INDEX IX_terms_acceptance_user_id ON sichr.terms_acceptance(user_id);
END
GO

PRINT 'V1__init_schema.sql completed successfully - SichrPlace MVP';
