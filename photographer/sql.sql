USE [Photographer]
GO
/****** Object:  Table [dbo].[Contact]    Script Date: 3/13/2020 9:12:08 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Contact](
	[address] [nvarchar](200) NULL,
	[city] [nvarchar](50) NULL,
	[country] [nvarchar](50) NULL,
	[tel] [int] NULL,
	[email] [nvarchar](100) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Gallery]    Script Date: 3/13/2020 9:12:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Gallery](
	[id] [int] NOT NULL,
	[entryName] [nvarchar](50) NOT NULL,
	[desPicture] [nvarchar](250) NULL,
	[description] [nvarchar](500) NULL,
 CONSTRAINT [PK_Gallery] PRIMARY KEY CLUSTERED 
(
	[id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Information]    Script Date: 3/13/2020 9:12:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Information](
	[mainPic] [nvarchar](200) NULL,
	[mainDescription] [nvarchar](500) NULL,
	[aboutMe] [nvarchar](1000) NULL
) ON [PRIMARY]
GO
/****** Object:  Table [dbo].[Picture]    Script Date: 3/13/2020 9:12:09 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[Picture](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[GalleryID] [int] NOT NULL,
	[PicturePath] [nvarchar](200) NOT NULL,
 CONSTRAINT [PK_Picture] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]
GO
INSERT [dbo].[Contact] ([address], [city], [country], [tel], [email]) VALUES (N'Hà Hoàng, Thạch Trung, Hà Tĩnh', N'Hà Tĩnh', N'Việt Nam', 141177669, N'thaoptphe131006@fpt.edu.vn')
INSERT [dbo].[Gallery] ([id], [entryName], [desPicture], [description]) VALUES (1, N'Gallery 1', N'img/1.jpg', N'Lorem ipsum dolor sit amet 1, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation')
INSERT [dbo].[Gallery] ([id], [entryName], [desPicture], [description]) VALUES (2, N'Gallery 2', N'img/2.jpg', N'Lorem ipsum dolor sit amet 2, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation')
INSERT [dbo].[Gallery] ([id], [entryName], [desPicture], [description]) VALUES (3, N'Gallery 3', N'img/3.jpg', N'Lorem ipsum dolor sit amet 3, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation')
INSERT [dbo].[Gallery] ([id], [entryName], [desPicture], [description]) VALUES (4, N'Gallery 4', N'img/4.jpg', N'Lorem ipsum dolor sit amet 4, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation')
INSERT [dbo].[Gallery] ([id], [entryName], [desPicture], [description]) VALUES (5, N'Gallery 5', N'img/5.jpg', N'Lorem ipsum dolor sit amet 5, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation')
INSERT [dbo].[Gallery] ([id], [entryName], [desPicture], [description]) VALUES (6, N'Gallery 6', N'img/6.jpg', N'Lorem ipsum dolor sit amet 6, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation')
INSERT [dbo].[Gallery] ([id], [entryName], [desPicture], [description]) VALUES (7, N'Gallery 7', N'img/7.jpg', N'Lorem ipsum dolor sit amet 7, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation')
INSERT [dbo].[Information] ([mainPic], [mainDescription], [aboutMe]) VALUES (N'img/main.jpg', N'Hi Lorem ipsum dolor sit amet', N'Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat. Ut wisi enim ad minim veniam, quis nostrud exerci tation ullamcorper suscipit lobortis nisl ut aliquip ex ea commodo consequat. Duis autem vel eum iriure dolor in hendrerit in vulputate velit esse molestie consequat, vel illum dolore eu feugiat nulla facilisis at vero eros et accumsan et iusto odio dignissim qui blandit praesent luptatum zzril delenit augue duis dolore te feugait nulla facilisi. Nam liber tempor cum soluta nobis eleifend option congue nihil imperdiet doming id quod mazim')
SET IDENTITY_INSERT [dbo].[Picture] ON 

INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (1, 1, N'img/1.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (2, 1, N'img/2.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (3, 2, N'img/2.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (4, 2, N'img/3.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (5, 3, N'img/3.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (6, 3, N'img/4.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (7, 4, N'img/4.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (8, 4, N'img/5.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (9, 1, N'img/3.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (10, 1, N'img/4.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (11, 1, N'img/5.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (12, 1, N'img/6.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (13, 2, N'img/4.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (14, 2, N'img/5.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (15, 2, N'img/6.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (16, 2, N'img/7.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (17, 2, N'img/8.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (18, 3, N'img/5.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (19, 3, N'img/6.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (20, 3, N'img/7.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (21, 3, N'img/8.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (22, 3, N'img/9.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (38, 3, N'img/1.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (39, 3, N'img/2.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (41, 4, N'img/6.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (42, 4, N'img/7.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (43, 4, N'img/8.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (44, 4, N'img/9.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (45, 4, N'img/1.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (46, 4, N'img/2.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (47, 4, N'img/3.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (49, 5, N'img/5.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (50, 5, N'img/6.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (51, 5, N'img/7.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (52, 5, N'img/8.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (53, 5, N'img/9.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (54, 5, N'img/1.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (55, 6, N'img/6.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (56, 6, N'img/7.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (57, 6, N'img/8.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (58, 6, N'img/9.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (59, 6, N'img/1.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (60, 7, N'img/7.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (61, 7, N'img/8.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (62, 7, N'img/9.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (63, 7, N'img/1.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (64, 7, N'img/2.jpg')
INSERT [dbo].[Picture] ([ID], [GalleryID], [PicturePath]) VALUES (66, 7, N'img/3.jpg')
SET IDENTITY_INSERT [dbo].[Picture] OFF
/****** Object:  StoredProcedure [dbo].[spGetImgsByPageAndSize]    Script Date: 3/13/2020 9:12:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create PROC [dbo].[spGetImgsByPageAndSize]
@Page INT,
@Size INT
AS
BEGIN
	SELECT * FROM picture
	ORDER BY id DESC
	OFFSET (@Page -1) * @Size ROWS
	FETCH NEXT @Size ROWS ONLY
END
GO
/****** Object:  StoredProcedure [dbo].[spGetRecordsByPageAndSize]    Script Date: 3/13/2020 9:12:10 AM ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
create PROC [dbo].[spGetRecordsByPageAndSize]
@Page INT,
@Size INT
AS
BEGIN
	SELECT * FROM Gallery
	ORDER BY id DESC
	OFFSET (@Page -1) * @Size ROWS
	FETCH NEXT @Size ROWS ONLY
END
GO
